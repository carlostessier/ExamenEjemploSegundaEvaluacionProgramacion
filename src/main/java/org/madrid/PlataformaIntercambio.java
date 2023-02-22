package org.madrid;

public class PlataformaIntercambio implements OperacionesPlataforma {

    private static final int MAX_NUMERO_CARTERAS = 100;
    private int numeroCarteras;
    private String nombre;
    private Cartera [] listaCarteras;

    public PlataformaIntercambio(Cartera [] listaCarteras) {
        this.listaCarteras = listaCarteras;
    }

    public PlataformaIntercambio() {
        this.listaCarteras = new Cartera [MAX_NUMERO_CARTERAS];
        for (int i = 0; i < MAX_NUMERO_CARTERAS; i++) {
            listaCarteras[i] = new Cartera();
        }
        numeroCarteras = 0;
    }

    public boolean deleteCartera(Cartera cartera) {
        boolean carteraBorrada = false;
        int posicion = buscarCarteraRecursiva(cartera.getUsuario(), 0);

        if (posicion >= 0) {
            listaCarteras[posicion] = new Cartera();
            numeroCarteras--;
            carteraBorrada = true;
        } else {
            System.err.println("No existe la cartera");

        }
        return carteraBorrada;
    }

    @Override
    public boolean addCartera(Cartera cartera)  {
        boolean creada = false;
        // comprobamos si la cartera existe
        int posicion = buscarCarteraRecursiva(cartera.getUsuario(),0);
        if (posicion >=0) {
            System.err.println("La cartera ya existe");
        } else {
             posicion = buscarCarteraRecursiva("",0);
            listaCarteras[posicion] = new Cartera(cartera);
            numeroCarteras++;
            creada = true;
        }
        return creada;
    }





    @Override
    public int buscarCarteraRecursiva(String nombre, int posicion) {
        if (posicion == MAX_NUMERO_CARTERAS) {
            return -1;
        } else {
            if (listaCarteras[posicion].getUsuario().equals(nombre)) {
                return posicion;
            } else {
                return buscarCarteraRecursiva(nombre, posicion + 1);
            }
        }
    }

    @Override
    public boolean addMonedaCartera(String usuario, CriptoMoneda crito) {
        boolean añadida = false;
        int posicion  = buscarCarteraRecursiva(usuario,0);
        if (posicion >= 0) {
            try {
                listaCarteras[posicion].addCriptoMoneda(crito);
                añadida = true;
            } catch (Exception e) {

            }
        }
        return añadida;
    }

    public Cartera [] getListaCarteras() {
        return listaCarteras;
    }

    public void setListaCarteras(Cartera [] listaCarteras) {
        this.listaCarteras = listaCarteras;
    }

    public void imprimirCarteras() {
        for (Cartera cartera : listaCarteras) {
            System.out.println(cartera);

        }
    }

    public int getNumeroCarteras() {
        return numeroCarteras;
    }

    public void setNumeroCarteras(int numeroCarteras) {
        this.numeroCarteras = numeroCarteras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
