/**
 * @author Walter Saldaña
 * @author Javier Cotto
 * @author Jose Gutierrez
 * 
 * Clase que modela un token para categorizar las instrucciones del programa
 */

 public class Token{

    //Atributos de la clase
    private String tipo;
    private String valor;

    /**
     * Constructor sin parametros
     */
    public Token(){}

    /**
     * 
     * @param tipo indica la clasificacion del token
     * @param valor valor que se le asigna al token
     */
    public Token(String tipo, String valor){
        this.tipo = tipo;
        this.valor = valor;
    }

    /**
     * 
     * @param tipo
     */
    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    /**
     * 
     * @return tipo de token
     */
    public String getTipo(){
        return this.tipo;
    }

    /**
     * 
     * @param valor
     */
    public void setValor(String valor){
        this.valor = valor;
    }

    /**
     * 
     * @return valor de token
     */
    public String getValor(){
        return this.valor;
    }

    /**
     * Devuelve el Strin de un token
     * @return string con datos del token
     */
    public String toString(){
        return "{"+this.getTipo()+","+this.getValor()+"}";
    }

    /**
     * Convierte o parsea un String a Token
     * @param token string que se desea parsear en formato "{tipo,valor}""
     * @return Objeto token con valores obtenidps del String
     */
    public Token parseToken(String token){
        String[] splited = token.replace("{","").replace("}","").split(",");
        return new Token(splited[0],splited[1]);
    }
    
 }