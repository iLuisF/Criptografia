
import java.util.Arrays;


/**
 *
 * @author luis
 */
public class Main {
    
    public static void main(String[] args){
        
        System.out.println("Ejemplo 1: ");        
        System.out.println("Cifrado...");        
        Texto claro = new Texto("algunas conjeturas//", 2);                
        Matriz cifrado = new Matriz(claro.getMatrizClave("SNUT"));
        System.out.println("Matriz de cifrado: \n" + Arrays.deepToString(cifrado.getMatriz()));
        
        Hill sistema = new Hill();        
        sistema.cifrar(cifrado, claro);        
        System.out.println("\nDescifrar...");        
        Texto cripto = new Texto("IEJGEDJHVIHZFDRAKU", 2);                
        sistema.descifrar(cifrado, cripto);
        
        
        System.out.println("\nEjemplo 2: ");        
        System.out.println("Cifrado...");        
        Texto claro2 = new Texto("Con diez cañones//", 2);                
        Matriz cifrado2 = new Matriz(claro.getMatrizClave("IEFG"));
        System.out.println("Matriz de cifrado: \n" + Arrays.deepToString(cifrado2.getMatriz()));
        
        Hill sistema2 = new Hill();        
        sistema2.cifrar(cifrado2, claro2);  
        System.out.println("\nDescifrar...");        
        Texto criptograma2 = new Texto("XHUFHÑZJCQYEER", 2);                
        sistema.descifrar(cifrado2, criptograma2);       
       
    }
    
}
