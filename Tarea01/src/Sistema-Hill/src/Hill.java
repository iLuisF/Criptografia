
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author luis
 */
public class Hill {

    //Texto cifrado.
    private List<String> textoCifrado;
    //Indices de cada caracter del texto claro.
    private List<Vector> indices;
    //Alfabeto de 26.
    String alfabetoMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    
    public Hill(){
        this.textoCifrado = new ArrayList<>();
        this.indices = new LinkedList<>();
    }
    
    /**
     * Lee caracteres desde la terminal.
     */
    public void leerTexto(String texto){
        textoCifrado = Arrays.asList(texto.split(" "));        
        toIndice();
    }
    
    /**
     * Obtiene una lista de vectores pero correspondiendo al indice de cada 
     * caracter.
     * 
     */
    public void toIndice(){
        for(String pareja : textoCifrado){
           indices.add(new Vector(this.alfabetoMayusculas.indexOf(pareja.charAt(0)), 
           this.alfabetoMayusculas.indexOf(pareja.charAt(1))));
        }
    }
    
    public List getVectores(){
        return this.indices;
    }
    
    public String toAlfabeto(List<Vector> indices){
        String resultado = "";
        for (Vector indice : indices) {
            resultado = resultado + alfabetoMayusculas.charAt(indice.getEntrada(0));
            resultado = resultado + alfabetoMayusculas.charAt(indice.getEntrada(1));
        }
        return resultado;
    }    
}
