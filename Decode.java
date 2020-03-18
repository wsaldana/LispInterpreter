/**
 * @author Walter Saldaña
 * @author Javier Cotto
 * @author Jose Gutierrez
 * 
 * Clase que identifica y almacena las operaciones del programa
 */

 public class Decode{

    private String programa;

    /**
     * Constructor
     */
    public Decode(){}

    /**
     * Separar y almacenar operaciones
     */
    public void instructionRegister(){
        this.programa = this.programa.replace("\n", " ");
    }

 }