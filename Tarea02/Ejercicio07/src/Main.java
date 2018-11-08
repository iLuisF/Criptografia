import java.math.BigInteger;

/**
 *  Genera una tabla con los pasos intermedios del algoritmo de Rho de Pollard.
 */
public class Main {

    //Valor anterior a x_(i+1), es decir, antecesor.
    static BigInteger x_i = new BigInteger("1");
    //Valor anterior a a_(i+1), es decir, antecesor.
    static BigInteger a_i = new BigInteger("0");
    //Valor anterior a b_(i+1), es decir, antecesor.
    static BigInteger b_i = new BigInteger("0");
    static BigInteger beta = new BigInteger("56851");
    static BigInteger alfa = new BigInteger("2");
    static BigInteger primo = new BigInteger("458009");
    //Limite de valores que queremos obtener.
    static int limite = 3000;
    static BigInteger orden = new BigInteger("57251");

    /**
     * Genera los valores para cada iteración de x, a, b.
     *
     * @param args
     */
    public static void main(String[] args) {
        generarValores(x_i, a_i,b_i,1, limite);
    }

    /**
     * Genera los valores para x, a, b.
     *
     * @param iteraciones Numero de iteracion actual.
     * @param limite Numero de iteraciones total que habra.
     */
    public static void generarValores(BigInteger x_i, BigInteger a_i, BigInteger b_i, int iteraciones, int limite){
        if(iteraciones == limite){
            System.out.println("Caso base: numero de iteraciones alcanzado.");
        }else{
            BigInteger tmpX = getX(x_i, beta, alfa, primo);
            BigInteger tmpA = getA(x_i, a_i, orden, primo);
            BigInteger tmpB = getB(x_i, b_i, orden, primo);
            if(true){//if(tmp % 2 == 0){
                System.out.println("i = " + iteraciones + " x_i = " + tmpX + "  a_i =  "  + tmpA + " b_i = " +  tmpB);
                //System.out.println(tmpX);
                iteraciones++;
            }
            generarValores(tmpX, tmpA, tmpB, iteraciones, limite);
        }
    }

    /**
     * Genera el valor de x_i+1.
     *
     * @return
     */
    private static BigInteger getX(BigInteger x_i, BigInteger beta, BigInteger alfa, BigInteger primo){
        BigInteger x0 = x_i;//x_i+1
        if((x_i.mod(new BigInteger("3")).equals(BigInteger.ZERO))){ //X_i pertenece a S2
            x0 = (x0.multiply(x0)).mod(primo);
        }
        if((x_i.mod(new BigInteger("3")).equals(BigInteger.ONE))){ //X_i pertenece a S1
            x0 = (x0.multiply(beta)).mod(primo);
        }
        if((x_i.mod(new BigInteger("3")).equals(new BigInteger("2")))){ //X_i pertenece a S3
            x0 = (x0.multiply(alfa)).mod(primo);
        }
        return x0;
    }

    private static BigInteger getA(BigInteger x_i, BigInteger a_i, BigInteger orden, BigInteger primo){
        BigInteger a = a_i;//a_i+1
        if((x_i.mod(new BigInteger("3")).equals(BigInteger.ZERO))){ //X_i pertenece a S2
            a = (a_i.multiply(new BigInteger("2"))).mod(orden);
        }
        if((x_i.mod(new BigInteger("3")).equals(BigInteger.ONE))){ //X_i pertenece a S1
            a = a_i.mod(primo);
        }
        if((x_i.mod(new BigInteger("3")).equals(new BigInteger("2")))){ //X_i pertenece a S3
            a = (a_i.add(BigInteger.ONE)).mod(orden);
        }
        return a;
    }

    private static BigInteger getB(BigInteger x_i, BigInteger b_i, BigInteger orden, BigInteger primo){
        BigInteger b = b_i;//b_i+1
        if((x_i.mod(new BigInteger("3")).equals(BigInteger.ZERO))){ //X_i pertenece a S2
            b = (b_i.multiply(new BigInteger("2"))).mod(orden);
        }
        if((x_i.mod(new BigInteger("3")).equals(BigInteger.ONE))){ //X_i pertenece a S1
            b = (b_i.add(BigInteger.ONE)).mod(orden);
        }
        if((x_i.mod(new BigInteger("3")).equals(new BigInteger("2")))){ //X_i pertenece a S3
            b = b_i.mod(primo);
        }
        return b;
    }
}
