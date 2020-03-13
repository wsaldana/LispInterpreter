import java.util.HashMap;

public class Scope <N, V> {
	
	  //Declaración de HashMap 
	  HashMap<String, String> Scope = new HashMap<String, String>();
	  
	  //N para nombre que se le asignara al valor y V para el valor que contiene ese nombre
	  public void add(String N, String V) {
		  
	  }
	  
	  //Devolver valor segun la llave
	  public String getValue(String N){
		  return Scope.get(N);
	  }
}
