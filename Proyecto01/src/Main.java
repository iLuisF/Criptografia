
import java.util.Arrays;


/**
 * Se prueba el cifrado y descifrado de Hill con 3 ejemplos, el primero visto en
 * la tarea, el segundo visto en clase y el tercero visto en laboratrio.
 * 
 * @author Flores González Luis Brandon, Santaella Marin Hector.
 */
public class Main {
    
    /**
     * <strong>Pasos para cifrar:</strong>
     * <ul>
     * <li>Creamos una llave de texto y la convertimos en matriz(cifrado).</li>
     * <li>Creamos un texto claro para cifrar.</li>
     * <li>Ciframos con el sistema de Hill.</li>
     * </ul>
     * <strong>Pasos para descifrar:</strong>
     * <ul>
     * <li>Usamos el criptograma que nos devolvio el cifrado.</li>
     * <li>Usamos la matriz de cifrado.</li>
     * <li>Desciframos con el sistema de Hill.</li>
     * </ul>
     * 
     * @param args sin uso
     */
    public static void main(String[] args){
                        
        System.out.println("Flores González Luis Brandon");
        System.out.println("Santaella Marin Hector\n");
        
        System.out.println("Ejemplo 1: ");        
        System.out.println("Cifrado...");        
        //Llave que se convertira posteriormente en la matriz de cifrado con indices.
        String llave = "SNUT";        
        //Matriz que se formo con los indices de la llave anterior.
        int[][] clave = new Texto().getMatrizClave(llave);
        //Texto claro a cifrar, junto con la longitud con que se dividira.
        Texto claro = new Texto("algunas conjeturas//", clave.length);    
        //Matriz de cifrado.
        Matriz cifrado = new Matriz(clave);
        System.out.println("Matriz de cifrado: \n" + Arrays.deepToString(cifrado.getMatriz()));
                
        Hill sistema = new Hill();        
        //Ciframos con la matriz de cifrado el texto claro.
        sistema.cifrar(cifrado, claro);        
        System.out.println("\nDescifrar...");        
        //Usamos el criptograma que nos genero el cifrado.
        Texto cripto = new Texto("IEJGEDJHVIHZFDRAKU", cifrado.getMatriz().length);                
        //Desciframos el criptograma.
        sistema.descifrar(cifrado, cripto);
                
        
        System.out.println("\nEjemplo 2: ");        
        System.out.println("Cifrado...");        
        String llave2 = "IEFG";
        int[][] clave2 = new Texto().getMatrizClave(llave2);
        Texto claro2 = new Texto("Con diez cañones//", clave2.length);                        
        Matriz cifrado2 = new Matriz(clave2);        
        System.out.println("Matriz de cifrado: \n" + Arrays.deepToString(cifrado2.getMatriz()));
        
        Hill sistema2 = new Hill();        
        sistema2.cifrar(cifrado2, claro2);  
        System.out.println("\nDescifrar...");        
        Texto criptograma2 = new Texto("VSICZKAHCDKRAZ", cifrado2.getMatriz().length);                
        sistema.descifrar(cifrado2, criptograma2);       

        System.out.println("\nEjemplo 3: ");        
        System.out.println("Cifrado...");        
        String llave3 = "FORTALEZA";        
        int[][] clave3 = new Texto().getMatrizClave(llave3);
        Matriz cifrado3 = new Matriz(clave3);
        Texto claro3 = new Texto("esto es una prueba//", clave3.length);                
        System.out.println("Matriz de cifrado: \n" + Arrays.deepToString(cifrado3.getMatriz()));
        
        Hill sistema3 = new Hill();        
        sistema3.cifrar(cifrado3, claro3);  
        System.out.println("\nDescifrar...");        
        Texto criptograma3 = new Texto("QDXRWCDOQZLSIZO", 3);                
        sistema.descifrar(cifrado3, criptograma3);       
    }
          
}
