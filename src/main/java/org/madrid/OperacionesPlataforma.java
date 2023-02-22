package org.madrid;

public interface OperacionesPlataforma {
    /**
     * Busca una cartera de un usuario
     * En caso de no encontrarla devuelve una Cartera vacía
     * (un objeto Cartera con el usuario "" y sin criptomonedas)
     * @param usuario nombre del usuario
     * @param posicion Posición desde donde empieza a buscar
     * @return int posicion de la cartera en el array, -1 si no la encuentra
     */
    public int buscarCarteraRecursiva(String usuario, int posicion);

    /**
     * Añade una cartera a la plataforma, si no existe el usuario
     * o el usuario no tiene espacio libre devuelva falso
     * @param usuario
     * @param cripto
     * @return
     */
    public boolean addMonedaCartera(String usuario, CriptoMoneda cripto);

    /**
     * Añade una cartera a la plataforma
     *
     * @param cartera
     * @return true si se ha añadido correctamente
     */
    public boolean addCartera(Cartera cartera);

    /**
     * Borra una cartera de la plataforma
     * Si no existe el usuario de la cartera lanzará una excepción
     * @param cartera
     * @return true si se ha borrado correctamente
     */
    public boolean deleteCartera(Cartera cartera)  ;

}
