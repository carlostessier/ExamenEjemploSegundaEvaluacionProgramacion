package org.madrid;

public class PlataformaIntercambio implements OperacionesPlataforma{
    public static final int MAX_NUM_CARTERAS = 100;
    private String nombre;
    private Cartera[] carteras;

    private int numeroCarteras;

    public PlataformaIntercambio(String nombre) {
        this.nombre = nombre;
        carteras = new Cartera[MAX_NUM_CARTERAS];
        for (int i = 0; i < MAX_NUM_CARTERAS; i++) {
            carteras[i] = new Cartera();
        }
    }

    public PlataformaIntercambio() {
        this("");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cartera[] getCarteras() {
        return carteras;
    }

    public void setCarteras(Cartera[] carteras) {
        this.carteras = carteras;
    }

    @Override
    public int buscarCarteraRecursiva(String usuario, int posicion) {
        return 0;
    }

    @Override
    public boolean addMonedaCartera(String usuario, CriptoMoneda cripto) {
        return false;
    }

    @Override
    public boolean addCartera(Cartera cartera) {
        return false;
    }

    @Override
    public boolean deleteCartera(Cartera cartera) {
        return false;
    }

    public int getNumeroCarteras() {
        return numeroCarteras;
    }

    public void setNumeroCarteras(int numeroCarteras) {
        this.numeroCarteras = numeroCarteras;
    }
}
