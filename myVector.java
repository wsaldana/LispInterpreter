/**
 * @author Walter Saldaña
 * @author Javier Cotto
 * @author Jose Gutierrez
 * 
 * Referencias: 
 * Duane A. Bailey. (2007). Java Structures. 7ma edicion.
 */

import java.util.Vector;

public class myVector<E> implements Stack<E>{

	protected Vector<E> data;

    /**
     * Constructor sin parametros
     * Inicializa el vector
     */
	public myVector(){
		data = new Vector<E>();
	}

    /**
     * @param item Elemento que se agrega a la coleccion
     * Agrega el elemento del parametro a la ultima posicion del vector
     */
	public void push(E item){
		data.add(item);
	}

    /**
     * @return ultimo elemento de la coleccion
     * Elimina el ultimo elemento de la coleccion
     */
	public E pop(){
		return data.remove(size()-1);
	}

    /**
     * @return Ultimo elemento de la coleccion
     * Devuelve el ultimo elemento de la coleccion
     */
	public E peek(){
		return data.get(size() - 1);
	}
    
    /**
     * @return Tamaño del vector
     * Retorna entero con la longitud del vector
     */
	public int size(){
		return data.size();
	}

    /**
     * @return false si la lista tiene elementos
     * @return true si la lista esta vacia
     */
    public boolean empty(){
        return !(data.size() > 0);
    }
}