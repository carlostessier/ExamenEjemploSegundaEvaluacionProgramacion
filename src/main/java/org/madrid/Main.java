package org.madrid;

public class Main {
    public static void main(String[] args) {

        PlataformaIntercambio p = new PlataformaIntercambio();
        Cartera c1 = new Cartera("Carlos");
        Cartera c2 = new Cartera("María");
        CriptoMoneda bitcoin = new CriptoMoneda("Bitcoin", 1, 10000,"SHA-256");
        CriptoMoneda etherum = new CriptoMoneda("Ether", 1, 10000,"SHA-256");

        try {
            // lo sientos carlos no entrobaba error
            //p.addCartera(c1);
            //p.addCartera(c2);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //p.addMonedaCartera("Carlos", bitcoin);
        //p.addMonedaCartera("Carlos", etherum);
        //p.addMonedaCartera("María", bitcoin);

        //p.imprimirCarteras();
    }
}