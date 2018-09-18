
/**
 * Operaciones necesarias para aplicar criptografia de Hill.
 * 
 * @author luis
 */
public class Matriz {
    
    private final int[][] matriz;
    //Orden de la matriz.
    private final int dimension;

    /**
     * Construye una matriz de orden dado.
     * 
     * @param dimension orden de la matriz.
     */
    public Matriz(int dimension) {
        this.matriz = new int[dimension][dimension];
        this.dimension = dimension;
    }

    /**
     * Construye una matriz partiendo de otra.
     * 
     * @param matriz 
     */
    public Matriz(int[][] matriz) {
        this.matriz = matriz;
        this.dimension = matriz.length;
    }

    /**
     * Asigna un valor a un indice de la matriz.
     * 
     * @param renglon
     * @param columna
     * @param valor 
     */
    public void setEntrada(int renglon, int columna, int valor) {
        this.matriz[renglon][columna] = valor;
    }

    /**
     * Obtiene un valor de un indice de la matriz.
     * 
     * @param renglon
     * @param columna
     * @return valor entero.
     */
    public int getEntrada(int renglon, int columna) {
        return this.matriz[renglon][columna];
    }

    /**
     * Multiplica un vector por una matriz modulo m.
     * 
     * @param vector
     * @param modulo
     * @return 
     */
    public Vector multiplicarVector(Vector vector, int modulo) {
        Vector vectorProducto = new Vector(this.dimension);
        int producto = 0;
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                producto += (this.matriz[i][j] * vector.getEntrada(j));
            }
            vectorProducto.setEntrada(i, producto % modulo);
            producto = 0;
        }
        return vectorProducto;
    }

    /**
     * Comprueba si la matriz actual es invertible o no.
     * 
     * @param modulo en el que estamos trabajando.
     * @return 
     */
    public boolean esInvertible(int modulo) {
        boolean esInvertible = false;
        int determinanteMod = calcularDeterminanteMod(modulo);
        if (calcularMcd(determinanteMod, modulo) == 1) {
            esInvertible = true;
        }
        return esInvertible;
    }
    
    /**
     * Calcula el determinante modulo n.
     *
     * @param mod
     * @return
     */
    public int calcularDeterminanteMod(int mod) {
        return calcularDeterminante(this.matriz) % mod;
    }

    /**
     * Calcula el determinante de una matriz.
     * 
     * @param matriz
     * @return entero.
     */
    private int calcularDeterminante(int[][] matriz) {
        int det;
        if (matriz.length == 2) {
            det = (matriz[0][0] * matriz[1][1]) - (matriz[1][0] * matriz[0][1]);
            return det;
        }
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            int[][] nm = new int[matriz.length - 1][matriz.length - 1];
            for (int j = 0; j < matriz.length; j++) {
                if (j != i) {
                    for (int k = 1; k < matriz.length; k++) {
                        int indice = -1;
                        if (j < i) {
                            indice = j;
                        } else if (j > i) {
                            indice = j - 1;
                        }
                        nm[indice][k - 1] = matriz[j][k];
                    }
                }
            }
            if (i % 2 == 0) {
                suma += matriz[i][0] * calcularDeterminante(nm);
            } else {
                suma -= matriz[i][0] * calcularDeterminante(nm);
            }
        }
        return suma;
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

    /**
     * Invierte una matriz, la multiplica por su inverso multiplicativo y
     * le aplica modulo n.
     * 
     * @param mod
     * @return 
     */
    public int[][] invertirMatriz(int mod) {
        int[][] inversa = invertir(this.matriz);
        int determinante = calcularDeterminanteMod(mod);
        System.out.println("Determinante: " + determinante);
        int inversoMultiplicativo = calcularInversoMultiplicativo(determinante);
        System.out.println("Inverso multiplicativo: " + inversoMultiplicativo);        
        //Modulo sin negativo. Ejemplo: (((-1 % 2) + 2) % 2)
        for(int i = 0; i < this.dimension; i++){
            for(int j = 0; j < this.dimension; j++){                
                inversa[i][j] = (((inversoMultiplicativo * (inversa[i][j])) % mod) + mod) % mod;;
            }
        }
        return inversa;
    }
    
    /**
     * Solo invierte una matriz.
     * 
     * @return matriz inversa.
     */
    private int[][] invertir(int[][] matriz){
        int[][] inversa = new int[2][2];        
        inversa[0][0] = matriz[1][1];
        inversa[1][0] = -matriz[1][0];
        inversa[0][1] = -matriz[0][1];
        inversa[1][1] = matriz[0][0];
        return inversa;
    }
       
    /**
     * Sabemos que xa congruente 1 (mod m), donde x es un inverso multiplicativo
     * modulo m de a.
     *
     * @param num
     * @return inverso multiplicativo dentro de Z 27.
     */
    private int calcularInversoMultiplicativo(int num) {
        int inverso = 1;
        switch (num) {
            case 1:
                inverso = 1;
                break;
            case 3:
                inverso = 1;
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
            case 16:
                inverso = 22;
                break;
            case 17:
                inverso = 8;
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
            case 26:
                inverso = 26;
                break;                
        }
        return inverso;
    }

    public int[][] getMatriz() {
        return matriz;
    }

}
