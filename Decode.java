import java.util.Map;
import java.util.TreeMap;

/**
 * @author Walter Saldaña
 * @author Javier Cotto
 * @author Jose Gutierrez
 * 
 *         Clase que identifica y almacena las operaciones del programa
 */

 public class Decode{

    private String code;
    private Stack<String> stack;
    private Map<String,String> scope;
    private Map<String, Stack<String>> functions;

    /**
     * Constructor sin parametros
     */
    public Decode(){}

    /**
     * @param code String que contiene las instrucciones del programa
     * Constructor con parametros
     */
    public Decode(String code){
        this.code = code; 
        this.stack = tokenize();
        this.scope = new TreeMap<String,String>();
        this.scope.put("t", "true");
        this.functions = new TreeMap<String, Stack<String>>();
    }

    /**
     * Metodo que manda a llamar la ejecucion siempre que existan instrucciones almacenadas
     */
    public void interpret(){
        while(!this.stack.empty()){
            execute(this.stack);
        }
    }

    /**
     * Separar y almacenar operaciones
     */
    public Stack<String> tokenize(){
        String[] initialCode = this.code.split(" ");
        Stack<String> tokenized = new myVector<String>();
        for(int i=initialCode.length-1; i>=0; i--){
            tokenized.push(initialCode[i]);
        }
        return tokenized;
    }

    /**
     * Verifica el tipo de instruccion y la ejecuta
     * @param a stack con las instrucciones
     * @return resultado de la ejecucion
     */
    public String execute(Stack<String> a){
        //Val almacena los resultados parciales al ejecutar una instruccion
        String val = "";
        //Ejecutar unicamente la ultima instruccion, al ser capturada sera eliminada del almacenamiento
        String pop = a.pop();
        //OPERACIONES ARITMETICAS
        if(pop.equals("+")){
            val = String.valueOf(Double.parseDouble(execute(a))+Double.parseDouble(execute(a)));
        }else if(pop.equals("-")){
            val = String.valueOf(Double.parseDouble(execute(a)) - Double.parseDouble(execute(a)));
        }else if(pop.equals("*")){
            val = String.valueOf(Double.parseDouble(execute(a)) * Double.parseDouble(execute(a)));
        }else if(pop.equals("/")){
            try {
                val = String.valueOf(Double.parseDouble(execute(a)) / Double.parseDouble(execute(a)));
            } catch (Exception e) {
                System.out.println("DIVISION ENTE 0 INDEFINIDA - "+e.getMessage());
                return "0";
            }
        //COMPARADORES
        }else if(pop.equals("=")){
            val = String.valueOf(execute(a).equals((execute(a))));
        }else if(pop.equals("<")){
            val = String.valueOf(Double.parseDouble(execute(a)) < Double.parseDouble(execute(a)));
        }else if(pop.equals(">")){
            val = String.valueOf(Double.parseDouble(execute(a)) > Double.parseDouble(execute(a)));
        }else if(pop.equals("COND")){
            if(execute(a).equals("true")){
                execute(a);
            }else{}
            val = String.valueOf(execute(a).equals((execute(a))));
        }else if(pop.equals("WRITE")){
            System.out.println(execute(a));
        }else if(pop.equals("SETQ")){
            this.scope.put(a.pop(), execute(a));
        //EL SIGUIENTE CONDICIONAL ES PARA EVALUAR FUNCIONES, EXPRESIONES O VALORES 
        }else{
            if(this.scope.containsKey(pop)){
                val = this.scope.get(pop);
            }else if(this.functions.containsKey(pop)){
                val = execute(this.functions.get(pop));
            }else{
                val = pop;
            }
        }
        this.stack = a;
        return val;
    }

 }