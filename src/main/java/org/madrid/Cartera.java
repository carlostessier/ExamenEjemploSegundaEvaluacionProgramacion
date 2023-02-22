package org.madrid;

import java.util.Arrays;
import java.util.Objects;

public class Cartera implements OperacionesCartera{
    public static final int TAMAGNO_CARTERA = 10;
    private String usuario;
    private CriptoMoneda [] criptomonedas;
    private int numCriptomonedas;

    public Cartera( ) {
        this("");
    }

    public Cartera (Cartera cartera) {
        this(cartera.getUsuario());
        for (int i = 0; i < cartera.getNumCriptomonedas(); i++) {
            addCriptoMoneda(cartera.getCriptomonedas()[i]);
        }
    }

    public Cartera(String usuario) {
        this.usuario = usuario;
        criptomonedas = new CriptoMoneda [TAMAGNO_CARTERA];
        for(int i = 0; i < TAMAGNO_CARTERA; i++) {
            criptomonedas[i] = new CriptoMoneda("", 0, 0);
        }
        numCriptomonedas = 0;
    }

    // devuelve la posición de la criptomoneda en la cartera
    @Override
    public int buscarCriptomoneda(String nombre) {
        if(numCriptomonedas == 0)
            return -1;

        for (int i = 0; i < criptomonedas.length; i++) {
            if (criptomonedas[i].getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;

    }

    public void deleteCriptoMoneda(CriptoMoneda criptoMoneda) {
        int indice = buscarCriptomoneda(criptoMoneda.getNombre());
        if (indice >= 0) {
            criptomonedas[indice] = new CriptoMoneda();
            numCriptomonedas--;
        }
    }

        @Override
    public boolean addCriptoMoneda(CriptoMoneda criptoMoneda)  {
        // buscamos si la criptoMoneda existe en la cartera
        if(numCriptomonedas == TAMAGNO_CARTERA){
            System.err.println("No hay espacio libre");
            return false;}
        int indice = buscarCriptomoneda(criptoMoneda.getNombre());
        if (indice>=0){
            criptomonedas[indice].setCantidad(criptomonedas[indice].getCantidad()+criptoMoneda.getCantidad());
        } else {
                // buscamos la primera posición libre
                for (int i = 0; i < criptomonedas.length; i++) {
                    if (estaVacio(criptomonedas[i] )) {
                        criptomonedas[i] = new CriptoMoneda(criptoMoneda.getNombre(), criptoMoneda.getCantidad(), criptoMoneda.getValor());
                        numCriptomonedas++;
                        break;
                    }
                }
        }
        return true;
    }

    private boolean estaVacio(CriptoMoneda criptomoneda ) {
        return criptomoneda.getNombre().equals("");
    }

    @Override
    public double takeCriptoMoneda(String nombre,double cantidad) {
        // buscamos si la criptoMoneda existe en la cartera
        int indice = buscarCriptomoneda(nombre);
        double monedas = 0;
        if (indice>=0){
            if (criptomonedas[indice].getCantidad()>=cantidad){
                criptomonedas[indice].setCantidad(criptomonedas[indice].getCantidad()-cantidad);
                monedas = cantidad;
            } else {
                System.err.println("No hay suficientes criptomonedas");
                return -1;
            }
        } else {
            System.err.println("No existe la criptomoneda");
            return -1;
        }
        return monedas;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public  CriptoMoneda [] getCriptomonedas() {
        return criptomonedas;
    }

    public void setCriptomonedas(CriptoMoneda [] criptomonedas) {
        this.criptomonedas = criptomonedas;
    }

    public int getNumCriptomonedas() {
        return numCriptomonedas;
    }

    public void setNumCriptomonedas(int numCriptomonedas) {
        this.numCriptomonedas = numCriptomonedas;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario: ");
        sb.append(usuario);
        sb.append(" Monedas:");
        for (int i = 0; !criptomonedas[i].getNombre().equals("") && i < criptomonedas.length; i++) {
            sb.append(criptomonedas[i].getNombre());
            sb.append(" ");
            sb.append(criptomonedas[i].getCantidad());
            sb.append(" ");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        boolean iguales = false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cartera cartera = (Cartera) o;

        if (numCriptomonedas != cartera.numCriptomonedas) return false;
        return (Objects.equals(usuario, cartera.usuario));
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
    }

    @Override
    public int hashCode() {
        int result = usuario != null ? usuario.hashCode() : 0;
        result = 31 * result + Arrays.hashCode(criptomonedas);
        result = 31 * result + numCriptomonedas;
        return result;
    }
}
