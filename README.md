# Examen final de 1º DAM/DAW   

Se quiere implementar una plataforma para de intercambio de Criptomonedas para la comunidad de Madrid y su moneda AyusoCoin. 

Para el primer sprint del proyecto se ha creado un modelo de clases a implementar para la plataforma.

## Primer ejercicio. 2.5 puntos. 

Crear las siguientes clases en el paquete madrid.org utilizando Programación Orientada a Objetos y procurando que los datos de las clases están encapsulados, y que tengan al menos un constructor por defecto y un constructor para todos los atributos, así como los getters y setters.

- Moneda: Es una clase abstracta con los atributos para el nombre de la moneda, la cantidad y valor.
- Criptomoneda: Hereda de la clase Moneda. Añade el atributo algoritmoHash para el nombre del algoritmo Hash.
- PlataformaIntercambio: Contiene un atributo nombre para el nombre de la plataforma y una array de Carteras de 100 como máximo
- Cartera: Contiene un atributo usuario para guardar el correo electrónico del dueño de la cartera, un array estático llamado criptomonedas para guardar un máximo de 10 Criptomonedas diferentes y un atributo numCriptomonedas para indicar el número de criptomonedas que se han guardado en el array. El array no puede contener elementos null, tendrá siempre un objeto criptomoneda con el nombre inicializado a ""

## Segundo ejercicio. 2.5 puntos. 

La comunidad de Madrid quiere poder añadir y borrar criptomonedas de una Cartera, y obtener monedas para realizar transacciones, para ello copiar la siguiente interfaz OperacionesCartera y completar todos los métodos en la clase Cartera

````
package org.madrid;

public interface OperacionesCartera {

   /**
    * Añade una criptomoneda a la cartera si hay espacio libre
    * (un posición del array donde nombre vale ""
    * En caso de existir añade la cantidad a la que ya existe
    * @param criptoMoneda
    * @return true si se ha podido añadir, false en caso contrario
    *
    * Devuelve una excepción con el mensaje "No hay espacio libre"
    */
   public boolean addCriptoMoneda(CriptoMoneda criptoMoneda);

   /**
    * Borra una criptomoneda a la cartera, asignando el nombre 
    * de la criptomoneda a "" , si no existe no hace nada
    * @param criptoMoneda
    */
   public boolean deleteCriptoMoneda(CriptoMoneda criptoMoneda);

       /**
        * Devuelve una cantidad de criptomonedas de la cartera
        * si esta existe y hay suficiente cantidad
        * En ese caso se descontará la cantidad de la cartera
        * @param nombre
        * @param cantidad
        * @return boolean true si se ha podido realizar la operación, false en caso contrario
        * 
        */
   public double takeCriptoMoneda(String nombre, double cantidad) ;

   /**
    * Devuelve la posición de la criptomoneda en la cartera
    * En caso de no encontrarla devolverá -1
    *
    * @param nombre
    * @return
    */
   public int buscarCriptomoneda(String nombre);
}

````

## Tercer ejercicio. 2 puntos. 

La Comunidad de Madrid quiere gestionar las carteras de los usuarios Para ello debe para ello copiar la siguiente interfaz OperacionesPlataforma y implementar todos los métodos en la clase  PlataformaIntercambio                

````
package org.madrid;

public interface OperacionesPlataforma {
   /**
   * Busca una cartera de un usuario de  forma RECURSIVA
   * En caso de no encontrarla devuelve una Cartera vacía
   * (un objeto Cartera con el usuario "" y sin criptomonedas)
   * @param usuario nombre del usuario
   * @param index Posición desde donde empieza a buscar
   * @return Cartera del usuario
   */
public int buscarCarteraRecursiva(String usuario, int index);


   /**
    * Añade una cartera a la plataforma, si no existe el usuario
    * o el usuario no tiene espacio libre devuelva falso
    * @param usuario
    * @param crito
    * @return devuelve el indice donde está la cartera, -1 en caso contrario
    */
   public boolean addMonedaCartera(String usuario, CriptoMoneda cripto);

   /**
    * Añade una cartera a la plataforma
    *
    * @param cartera
    * @return true si se ha podido añadir, false en caso contrario
    */
   public boolean addCartera(Cartera cartera);

   /**
    * Borra una cartera de la plataforma
    * Si no existe el usuario de la cartera lanzará una excepción
    * @param cartera
    * @return true si se ha podido borrar, false en caso contrario
    */
   public boolean deleteCartera(Cartera cartera) throws Exception;

}

````








