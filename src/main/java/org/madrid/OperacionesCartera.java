package org.madrid;

public interface OperacionesCartera {

    /**
     * Añade una criptomoneda a la cartera si hay espacio libre
     * En caso de existir añade la cantidad a la que ya existe
     *
     * @param criptoMoneda
     * @return true si se ha añadido correctamente
     */
    public boolean addCriptoMoneda(CriptoMoneda criptoMoneda)  ;

    /**
     * Borra una criptomoneda a la cartera
     *
     * @param criptoMoneda
     */
    public void deleteCriptoMoneda(CriptoMoneda criptoMoneda);


        /**
         * Devuelve una cantidad de criptomonedas de la cartera
         * si esta existe y hay suficiente cantidad
         * En ese caso se descontará la cantidad de la cartera
         *
         * @param nombre
         * @param cantidad
         * @return cantidad de criptomonedas que se han retirado
         * En caso de no existir la criptomoneda o no haber suficiente cantidad
         * devuelve -1
         */
    public double takeCriptoMoneda(String nombre, double cantidad)  ;

    /**
     * Devuelve la posición de la criptomoneda en la cartera
     * En caso de no encontrarla devolverá -1
     *
     * @param nombre
     * @return
     */
    public int buscarCriptomoneda(String nombre);
}

