package org.madrid;

public class Cartera implements OperacionesCartera{
    public static final int MAX_NUMERO_MONEDAS = 10;
    private String usuario;
    private CriptoMoneda[] criptomonedas;
    private int numCriptomonedas;

    public Cartera(String usuario) {
        setUsuario(usuario);
        criptomonedas = new CriptoMoneda[MAX_NUMERO_MONEDAS];
        for (int i = 0; i < criptomonedas.length; i++) {
            criptomonedas[i] = new CriptoMoneda();
        }
    }

    public Cartera(){
        this("");
    }

    public int getNumCriptomonedas() {
        return numCriptomonedas;
    }

    public void setNumCriptomonedas(int numCriptomonedas) {
        this.numCriptomonedas = numCriptomonedas;
    }

    public CriptoMoneda[] getCriptomonedas() {
        return criptomonedas;
    }

    public void setCriptomonedas(CriptoMoneda[] criptomonedas) {
        this.criptomonedas = criptomonedas;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        if (usuario == null){

            this.usuario = "";
        }
        else {
            this.usuario = usuario;
        }
    }

    @Override
    public boolean addCriptoMoneda(CriptoMoneda criptoMoneda) {
        // comprobar si está llena
        if(numCriptomonedas == MAX_NUMERO_MONEDAS){
            System.err.println("La cartera está llena");
            return false;
        }
        //comprobar si ya existe
        int indice = buscarCriptomoneda(criptoMoneda.getNombre());
        if (indice >=0){
            double cantidad = criptomonedas[indice].getCantidad()+criptoMoneda.getCantidad();
            criptomonedas[indice].setCantidad(cantidad);
        }
        //añadir en un hueco libre
        indice = buscarCriptomoneda("");
        if (indice >=0){
            criptomonedas[indice] = criptoMoneda;
            numCriptomonedas++;
            return true;
        }
        return false;
    }

    @Override
    public void deleteCriptoMoneda(CriptoMoneda criptoMoneda) {

    }

    @Override
    public double takeCriptoMoneda(String nombre, double cantidad) {
        return 0;
    }

    @Override
    public int buscarCriptomoneda(String nombre) {
        for (int i = 0; i < criptomonedas.length ; i++) {
            if (criptomonedas[i].getNombre().equals(nombre)){
                return i;
            }
        }

        return -1;
       /* version estructurada
        int indice = -1;

        int i = 0;
        boolean encontrado = false;
        while (i < criptomonedas.length && !encontrado){
            encontrado = criptomonedas[i].getNombre().equals(nombre);
            if (!encontrado){
                i++;
            }
        }
        if (encontrado){
            return indice = i;
        }

        return indice;
         */

    }

    private int buscarCriptomoneda(String nombre, int i) {
        if (i == MAX_NUMERO_MONEDAS){
            return -1;
        }
        if(criptomonedas[i].getNombre().equals(nombre)){
            return i;
        }
        return buscarCriptomoneda(nombre, i+1);

    }
}