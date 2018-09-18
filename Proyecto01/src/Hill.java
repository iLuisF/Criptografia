
import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author luis
 */
public class Hill {
    
    /**
     * Para poder cifrar el texto claro se necesita: 
     * 
     * 1. El determinante de la matriz debe ser diferente de 0 mod 27.
     * 
     * @param cifrado matriz con coeficientes para cifrar.
     * @param claro cadena de texto en español.
     */
    public void cifrar(Matriz cifrado, Texto claro){
        LinkedList<Vector> indices = new LinkedList<>();
        if(cifrado.esInvertible(27)){            
            for(Vector vector : claro.getTextoVectores()){
                indices.add(cifrado.multiplicarVector(vector, 27));
            }
        } else {
            System.out.println("La matriz no es invertible.");
        }       
        System.out.println("Indices cifrados:");
        System.out.println(indices);
        System.out.println("Criptograma: ");
        System.out.println(claro.toAlfabeto(indices));
    }
    
    
    /**
     * Para poder descifrar el texto encriptado se necesita: 
     * 
     * 1. El determinante de la matriz debe ser diferente de 0 mod 27.
     * 
     * @param cifrado matriz con coeficientes
     * @param cripto 
     */
    public void descifrar(Matriz cifrado, Texto cripto){
       LinkedList<Vector> indices = new LinkedList<>();
       Matriz descifrado = new Matriz(cifrado.invertirMatriz(27));
       System.out.println("Matriz de descifrado: " + Arrays.deepToString(descifrado.getMatriz()));
       if(cifrado.esInvertible(27)){
            for(Vector vector : cripto.getTextoVectores()){
                indices.add(descifrado.multiplicarVector(vector, 27));                
            }
       } else {
           System.out.println("La matriz no es invertible.");
       }
        System.out.println("Indices decifrados: ");
        System.out.println(indices);
        System.out.println("Texto claro: ");
        System.out.println(cripto.toAlfabeto(indices));
    }
    
}
