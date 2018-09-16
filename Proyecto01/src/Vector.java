
/**
 *
 * @author luis
 */
public class Vector {

    private final int[] vector;
    
    /**
     * 
     * @param renglones numero de renglones.
     */
    public Vector(int renglones){
        this.vector = new int[renglones];
    }
        
    public void setEntrada(int renglon, int valor) {
        this.vector[renglon] = valor;
    }

    public int getEntrada(int renglon) {
        return this.vector[renglon];
    }
        
    @Override
    public String toString(){
        String cadena = "";
        for(int i = 0; i < this.vector.length; i++){
            cadena = cadena + vector[i] + " ";
        }
        return cadena;
    }
}
