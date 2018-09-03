
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author luis
 */
public class Main {

   public static void main(String[] args){
        
        //Escribe archivos.
       ManejadorArchivos archivos = new ManejadorArchivos();
       
       //Matriz de decifrado de Hill.
       Matriz descifrado = new Matriz();       
       
       descifrado.setEntrada(0, 0, 24);
       descifrado.setEntrada(0, 1, 13);
       descifrado.setEntrada(1, 0, 19);
       descifrado.setEntrada(1, 1, 15);
              
       Hill sistema = new Hill();
       sistema.leerTexto(leerTextoTerminal());
       
       List<Vector> vectores = new LinkedList<>();
       vectores = sistema.getVectores();
       List<Vector> indices = new LinkedList<>();
       
       for (Vector vector : vectores) {
           Vector tmp = new Vector();
           tmp = descifrado.multiplicarVector(vector);
           tmp.modulo(26);
           indices.add(tmp);
       }
                            
       archivos.escribir(sistema.toAlfabeto(indices), "descifrado");
   }
   
   static String leerTextoTerminal(){
        Scanner leer = new Scanner(System.in);
        String linea = "";
        return linea = leer.nextLine();
   }
    
}
