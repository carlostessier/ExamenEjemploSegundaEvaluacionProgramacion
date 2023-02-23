package org.madrid;

public class CriptoMoneda extends Moneda {
    
    private String algoritmoHash;
    public CriptoMoneda(String nombre, double cantidad, double valor) {
        super(nombre, cantidad, valor);
        this.algoritmoHash = "";
    }
    
    public CriptoMoneda(String nombre, double cantidad, double valor, String algoritmoHash) {
        super(nombre, cantidad, valor);
        this.algoritmoHash = algoritmoHash;
    }
    
    public CriptoMoneda() {
        super();
        this.algoritmoHash = "";
    }

}
