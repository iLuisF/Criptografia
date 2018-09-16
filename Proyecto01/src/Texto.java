
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author luis
 */
public class Texto {
        
    //Cadena de texto donde cada n caracteres esta en un nodo.
    private List<String> textoAlfabeto;
    //Cadena del texto.
    private String cadena;
    //Números que corresponden a cada caracter del texto, donde cada nodo
    //es un vector de posiciones.
    private List<Vector> textoVectores;
    //Alfabeto de 27 caracteres
    private final String alfabetoMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public Texto(String cadena, int tamanio){
        System.out.println(cadena);
        textoAlfabeto = new LinkedList<>();
        textoVectores = new LinkedList<>();
        this.cadena = cadena;
        limpiar();
        dividir(tamanio);
        crearVectores(tamanio);
    }
    
    /**
     * Divide el texto en conjuntos de caracteres de tamaño n.
     * Ejemplo:
     * Texto = holamundo
     * n = 2
     * Lista = [ho, la, mu, nd, o]
     * @param n
     */     
    public final void dividir(int n){
        String tupla = "";        
        for(int i = 0; i < this.cadena.length(); i++){            
            for(int j = i; j < i + n; j++){
                if(j < this.cadena.length()){
                tupla = tupla + cadena.charAt(j);                                
                }                                
            }     
            i = i + n - 1;
            textoAlfabeto.add(tupla);
            tupla = "";             
        }
        System.out.println(textoAlfabeto);
    }
        
    /**
     * Forma una cadena nueva donde solo contendra los caracteres dentro del
     * alfabeto. De igual manera los espacios desaparecen. Además todo se convierte
     * en mayusculas.
     * 
     * @return 
     */
    private void limpiar(){
        this.cadena = this.cadena.toUpperCase();
        String cadenaLimpia = "";       
        for(int i = 0; i < this.cadena.length(); i++){            
            if(estaEnAlfabeto(cadena.charAt(i))){
                cadenaLimpia = cadenaLimpia + cadena.charAt(i);
            }            
        }
        this.cadena = cadenaLimpia;                
    }
    
    /**
     * Indica si el caracter esta en el alfabeto.
     * 
     * @return 
     */
    private boolean estaEnAlfabeto(char caracter){
        return alfabetoMayusculas.contains(String.valueOf(caracter));           
    }
    
    /**
     * Genera una lista de vectores pero correspondiendo al indice de cada 
     * caracter.
     * 
     * @param n
     */
    public final void crearVectores(int n){
        for(String pareja : textoAlfabeto){
           Vector vector = new Vector(n);
           for(int i = 0; i < n; i++){
                if(pareja.length() == n){
                 vector.setEntrada(i, this.alfabetoMayusculas.indexOf(pareja.charAt(i)));                                     
                } else {                  
                  for(int j = 0; j < pareja.length(); j++){
                      vector.setEntrada(j, this.alfabetoMayusculas.indexOf(pareja.charAt(j)));                                       
                  }
                }                    
           }                     
           textoVectores.add(vector);
        }
        System.out.println(textoVectores);
    }
    
    /**
     * Dada una lista de vectores de indices, los pasa a sus correspondientes
     * caracteres dentro del alfabeto.
     * 
     * @param indices
     * @return 
     */
    public String toAlfabeto(LinkedList<Vector> indices){
        String resultado = "";
        for (Vector indice : indices) {
            resultado = resultado + alfabetoMayusculas.charAt(indice.getEntrada(0));
            resultado = resultado + alfabetoMayusculas.charAt(indice.getEntrada(1));
        }
        return resultado;
    }    

    public List<String> getTextoAlfabeto() {
        return textoAlfabeto;
    }

    public void setTextoAlfabeto(List<String> textoAlfabeto) {
        this.textoAlfabeto = textoAlfabeto;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    public List<Vector> getTextoVectores() {
        return textoVectores;
    }

    public void setTextoVectores(List<Vector> textoVectores) {
        this.textoVectores = textoVectores;
    }
           
    
    
}