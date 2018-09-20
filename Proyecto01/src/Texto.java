
import java.util.LinkedList;
import java.util.List;

/**
 * Manejador de texto tanto para texto claro como para criptograma, así como
 * la llave.
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
    private final String alfabetoMayusculas = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    
    /**
     * Se contruye un texto con una cadena y el tamaño con el que formaran atomos.
     * 
     * @param cadena criptograma o texto claro.
     * @param tamanio tamaño de cada conjunto de caracteres.
     */
    public Texto(String cadena, int tamanio){
        System.out.println(cadena);
        textoAlfabeto = new LinkedList<>();
        textoVectores = new LinkedList<>();
        this.cadena = cadena;
        limpiar();
        dividir(tamanio);
        crearVectores(tamanio);
    }
        
    public Texto(){
        
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
            for(int i = 0; i < indices.getFirst().getVector().length; i++){
                resultado = resultado + alfabetoMayusculas.charAt(indice.getEntrada(i));
            }
        }
        return resultado;
    }    

    /**
     * Cadena de texto donde cada n caracteres esta en un nodo.
     * 
     * @return nodos de n caracteres cada uno.
     */
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

    /**
     * Números que corresponden a cada caracter del texto, donde cada nodo
     * es un vector de posiciones.
     * 
     * @return correspondencia de caractares a numeros dentro del alfabeto.
     */
    public List<Vector> getTextoVectores() {
        return textoVectores;
    }

    public void setTextoVectores(List<Vector> textoVectores) {
        this.textoVectores = textoVectores;
    }
           
    /**
     * Construye una matriz de cifrado(clave) a partir de una cadena de texto.
     * 
     * @param clave
     * @return
     */
    public int[][] getMatrizClave(String clave){
        clave = clave.toUpperCase();
        int[][] rtnClave = new int[0][0];

        double raizDouble = Math.sqrt( clave.length() );
        if (raizDouble == (int)raizDouble){

            int raizInt = (int)raizDouble;
            rtnClave = new int[raizInt][raizInt];
            int flagClave = 0;
            for(int i=0; i<raizInt; i++){
                for(int j=0; j<raizInt; j++){
                    rtnClave[i][j] = alfabetoMayusculas.indexOf(clave.charAt(flagClave));
                    flagClave++;
                }
            }

        }
        else{ //no es exacto la raíz cuadrada del la clave
            System.out.println("Llave invalida, no se puede formar una matriz de NxN");
            System.out.println("Error en clase Texto: 170");
            // rtnClave[i][j] = null;
        }

        return rtnClave;
    }    
}