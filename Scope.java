import java.util.HashMap;

public class Scope <N, V> {
	
	  //Declaración de HashMap 
	 private HashMap<N, V> mapScope;
	  
	 
	  public Scope() {
		this.mapScope = mapScope = new HashMap<N, V>();
	}

	//N para nombre que se le asignara al valor y V para el valor que contiene ese nombre
	  public void add(N nombre, V valor) {
		 mapScope.put(nombre, valor);
	  }
	  
	  //Devolver valor segun la llave
	  public N getValue(N nombre){
		  return (N) mapScope.get(nombre);
	  }
}
