
import java.util.LinkedList;
import java.util.List;


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
        if(cifrado.esInvertible()){            
            for(Vector vector : claro.getTextoVectores()){
                indices.add(cifrado.multiplicarVector(vector));
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
     * @param descifrado matriz con coeficientes
     * @param cript 
     */
    public void descifrar(Matriz descifrado, Texto cript){
       
    }
}
