
/**
 *
 * @author luis
 */
public class Matriz {

    private final int[][] matriz;
    private final int dimension;
    
    /**
     * 
     * @param dimension
     */
    public Matriz(int dimension){
        this.matriz = new int[dimension][dimension];
        this.dimension = dimension;
    }
   
    public void setEntrada(int renglon, int columna, int valor) {
        this.matriz[renglon][columna] = valor;
    }

    public int getEntrada(int renglon, int columna) {
        return this.matriz[renglon][columna];
    }
    
    public Vector multiplicarVector(Vector vector){
        Vector nuevoVector = new Vector(2);        
        int renglon0 = (this.matriz[0][0] * vector.getEntrada(0)) +
                       (this.matriz[0][1] * vector.getEntrada(1));        
        int renglon1 = (this.matriz[1][0] * vector.getEntrada(0)) +
                       (this.matriz[1][1] * vector.getEntrada(1));
        nuevoVector.setEntrada(0, renglon0 % 27);
        nuevoVector.setEntrada(1, renglon1 % 27);
        
        return nuevoVector;
    }
    
    public boolean esInvertible(){
        boolean esInvertible =  false;
        int determinanteMod27 = calcularDeterminanteMod(27);
        if(calcularMcd(determinanteMod27, 27) == 1){
            esInvertible = true;
        }        
        return esInvertible;
    }
    
    //Por el momento solo soporta de dimension2.
    public int calcularDeterminante(){
        return (this.matriz[0][0] * this.matriz[1][1]) - 
                (this.matriz[1][0] * this.matriz[0][1]);                        
    }
    
    /**
     * Calcula el determinante modulo n.
     * 
     * @param mod
     * @return 
     */
    public int calcularDeterminanteMod(int mod){
        return calcularDeterminante() % mod;
    }
    
    /**
     * Calcula el maximo comun divisor de dos numeros.
     * 
     * @param a
     * @param b
     * @return 
     */
    public int calcularMcd(int a, int b){
        if(b == 0){
            return a;
        } else {
            return calcularMcd(b, a % b);
        }
    }
}
