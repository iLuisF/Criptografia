
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
        //(19, 13)
        //(21, 20)
        Matriz cifrado = new Matriz(2);
        cifrado.setEntrada(0, 0, 19);
        cifrado.setEntrada(0, 1, 13);
        cifrado.setEntrada(1, 0, 21);
        cifrado.setEntrada(1, 1, 20);
        System.out.println("Matriz de cifrado: \n" + Arrays.deepToString(cifrado.getMatriz()));
        
        Hill sistema = new Hill();        
        sistema.cifrar(cifrado, claro);        
        System.out.println("\nDescifrar...");        
        Texto cripto = new Texto("IEJGEDJHVIHZFDRAKU", 2);                
        sistema.descifrar(cifrado, cripto);
        
        System.out.println("\nEjemplo 2: ");        
        System.out.println("Cifrado...");        
        Texto claro2 = new Texto("Con diez cañones//", 2);                
        //(9, 4)
        //(5, 7)
        Matriz cifrado2 = new Matriz(2);
        cifrado2.setEntrada(0, 0, 9);
        cifrado2.setEntrada(0, 1, 4);
        cifrado2.setEntrada(1, 0, 5);
        cifrado2.setEntrada(1, 1, 7);
        System.out.println("Matriz de cifrado: \n" + Arrays.deepToString(cifrado2.getMatriz()));
        
        Hill sistema2 = new Hill();        
        sistema2.cifrar(cifrado2, claro2);  
        System.out.println("\nDescifrar...");        
        Texto criptograma2 = new Texto("XHUFHÑZJCQYEER", 2);                
        sistema.descifrar(cifrado2, criptograma2);       
    }
    
}
