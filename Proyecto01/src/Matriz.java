
import static java.lang.Math.toIntExact;


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
    public Matriz(int dimension) {
        this.matriz = new int[dimension][dimension];
        this.dimension = dimension;
    }
    
    public Matriz(int[][] matriz, int dimension){
        this.matriz = matriz;
        this.dimension = dimension;
    }

    public void setEntrada(int renglon, int columna, int valor) {
        this.matriz[renglon][columna] = valor;
    }

    public int getEntrada(int renglon, int columna) {
        return this.matriz[renglon][columna];
    }

    public Vector multiplicarVector(Vector vector, int modulo) {
        Vector nuevoVector = new Vector(2);
        int renglon0 = (this.matriz[0][0] * vector.getEntrada(0))
                + (this.matriz[0][1] * vector.getEntrada(1));
        int renglon1 = (this.matriz[1][0] * vector.getEntrada(0))
                + (this.matriz[1][1] * vector.getEntrada(1));
        nuevoVector.setEntrada(0, renglon0 % modulo);
        nuevoVector.setEntrada(1, renglon1 % modulo);

        return nuevoVector;
    }

    public boolean esInvertible(int modulo) {
        boolean esInvertible = false;
        int determinanteMod = calcularDeterminanteMod(modulo);
        if (calcularMcd(determinanteMod, modulo) == 1) {
            esInvertible = true;
        }
        return esInvertible;
    }

    //Por el momento solo soporta de dimension2.
    public int calcularDeterminante() {
        return (this.matriz[0][0] * this.matriz[1][1])
                - (this.matriz[1][0] * this.matriz[0][1]);
    }

    /**
     * Calcula el determinante modulo n.
     *
     * @param mod
     * @return
     */
    public int calcularDeterminanteMod(int mod) {
        return calcularDeterminante() % mod;
    }

    /**
     * Calcula el maximo comun divisor de dos numeros.
     *
     * @param a
     * @param b
     * @return
     */
    public int calcularMcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calcularMcd(b, a % b);
        }
    }

    public int[][] invertirMatriz(int mod) {
        int determinante =  calcularDeterminanteMod(mod);
        System.out.println("Determinante: " + determinante);        
        int inversoMultiplicativo = calcularInversoMultiplicativo(determinante);
        System.out.println("Inverso multiplicativo: " + inversoMultiplicativo);
        int[][] inversa = new int[2][2];                
        //modulo sin negativo (((-1 % 2) + 2) % 2)
        inversa[0][0] = (toIntExact(inversoMultiplicativo) * this.matriz[1][1]) % mod;
        inversa[1][0] = (((toIntExact(inversoMultiplicativo) * (- this.matriz[1][0])) % mod) + mod) % mod;
        inversa[0][1] = (((toIntExact(inversoMultiplicativo) * (- this.matriz[0][1])) % mod) + mod) % mod;
        inversa[1][1] = (toIntExact(inversoMultiplicativo) * this.matriz[0][0]) % mod;        
        return inversa;
    }

    /**
     * Sabemos que xa congruente 1 (mod m), donde x es un inverso multiplicativo
     * modulo m de a.
     * 
     * @param num
     * @return inverso multiplicativo dentro de Z 26.
     */
    private int calcularInversoMultiplicativo(int num){
        int inverso = 1;
        switch (num){
            case 1:
                inverso = 1;
                break;
            case 3:
                inverso = 9;
                break;
            case 5:
                inverso = 21;
                break;
            case 7:
                inverso = 15;
                break;
            case 9:
                inverso = 3;
                break;
            case 11:
                inverso = 19;
                break;
            case 15:
                inverso = 7;
                break;
            case 17:
                inverso = 23;
                break;
            case 19:
                inverso = 11;
                break;
            case 21:
                inverso = 5;
                break;                
            case 23:
                inverso = 17;
                break;      
            case 25:
                inverso = 25;
                break;                                
        }                
        return inverso;
    }

    public int[][] getMatriz() {
        return matriz;
    }
    
}
