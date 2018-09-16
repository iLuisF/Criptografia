
/**
 *
 * @author luis
 */
public class Main {
    
    public static void main(String[] args){
        
        Texto claro = new Texto("con diez cañonesr//", 2);        
        
        //(9, 4)
        //(5, 7)
        Matriz cifrado = new Matriz(2);
        cifrado.setEntrada(0, 0, 9);
        cifrado.setEntrada(0, 1, 4);
        cifrado.setEntrada(1, 0, 5);
        cifrado.setEntrada(1, 1, 7);
        
        Hill sistema = new Hill();
        
        sistema.cifrar(cifrado, claro);
        
    }
    
}
