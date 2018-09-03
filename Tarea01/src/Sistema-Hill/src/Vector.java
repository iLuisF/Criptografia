
/**
 * Representa un vector de tamaño 2.
 * 
 * @author Flores González Luis.
 */
public class Vector {
    
    private int[] vector;
    
    public Vector(){
        this.vector = new int[2];
    }
    
    /**
     * Asigna valores a las dos entradas correspondientes de un vector.
     * @param valor1
     * @param valor2 
     */
    public Vector(int valor1, int valor2){
        this.vector = new int[2];
        this.setEntrada(0, valor1);
        this.setEntrada(1, valor2);
    }
    
    public void setEntrada(int renglon, int valor) {
        this.vector[renglon] = valor;
    }

    public int getEntrada(int renglon) {
        return this.vector[renglon];
    }
    
    public void modulo(int valor){
        this.vector[0] = this.vector[0] % valor;
        this.vector[1] = this.vector[1] % valor;
    }
            
    @Override
    public String toString(){
       return "[" + this.vector[0] + ", " + this.vector[1] + "]";
    }
}
