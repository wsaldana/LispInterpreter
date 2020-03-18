import java.util.HashMap;

public class Scope <N, V> {
	
	  //Declaración de HashMap 
	 private HashMap<N, V> mapScope;
	  
	 
	  public Scope() {
		this.mapScope = new HashMap<N, V>();
	}

	//N para nombre que se le asignara al valor y V para el valor que contiene ese nombre
	  public void add(N nombre, V valor) {
		 mapScope.put(nombre, valor);
	  }
	// Se agrega un nombre de tipo N
	public void add(N nombre) {
		mapScope.put(nombre, null);
	}
	  
	  //Devolver valor segun la llave
	  public V getValue(N nombre){
		  return mapScope.get(nombre);
	  }

	// Comparacion entre dos valores distintos de tipo N
	public boolean equality(N first, N second){
	if (first.equals(second)){
			return true;
		}
		else{
			return false;
		}
	}
}
