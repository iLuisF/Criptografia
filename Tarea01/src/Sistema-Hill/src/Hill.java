
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author luis
 */
public class Hill {

    //Texto cifrado.
    private List<String> textoCifrado;
    //Indices de cada caracter del texto claro.
    private final List<Vector> indices;
    //Alfabeto de 26.
    private String alfabetoMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    
    /**
     * Contruimos un texto cifrado y las parejas de los digramas.
     */
    public Hill(){
        this.textoCifrado = new ArrayList<>();
        this.indices = new LinkedList<>();
    }
    
    /**
     * Lee caracteres desde la terminal(separandolos por un espacios)
     * y los agrega a la lista.
     */
    public void leerTexto(String texto){
        textoCifrado = Arrays.asList(texto.split(" "));        
        toIndice();
    }
    
    /**
     * Genera una lista de vectores pero correspondiendo al indice de cada 
     * caracter.
     * 
     */
    public void toIndice(){
        for(String pareja : textoCifrado){
           indices.add(new Vector(this.alfabetoMayusculas.indexOf(pareja.charAt(0)), 
           this.alfabetoMayusculas.indexOf(pareja.charAt(1))));
        }
    }
    
    /**
     * Lista de vectores.
     * 
     * @return 
     */
    public List getVectores(){
        return this.indices;
    }
    
    /**
     * Dada una lista de vectores de indices, los pasa a sus correspondientes
     * caracteres dentro del alfabeto.
     * 
     * @param indices
     * @return 
     */
    public String toAlfabeto(List<Vector> indices){
        String resultado = "";
        for (Vector indice : indices) {
            resultado = resultado + alfabetoMayusculas.charAt(indice.getEntrada(0));
            resultado = resultado + alfabetoMayusculas.charAt(indice.getEntrada(1));
        }
        return resultado;
    }    
}
