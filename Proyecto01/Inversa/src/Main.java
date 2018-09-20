
import java.util.Arrays;
import matrix.Matrix;
import matrix.MatrixMathematics;
import matrix.NoSquareException;


/**
 *
 * @author luis
 */
public class Main {

    public static void main(String[] args) throws NoSquareException{
        Main hola = new Main();
        double[][] matricita = new double[2][2];
        matricita[0][0] = 1.00;
        matricita[0][1] = 2.00;
        matricita[1][0] = 3.00;
        matricita[1][1] = 4.00;
        Matrix hola2 = new Matrix(matricita);        
        System.out.println(Arrays.deepToString(matricita));
        Matrix cofactor = new Matrix(MatrixMathematics.cofactor(hola2).getValues());
        System.out.println(Arrays.deepToString(MatrixMathematics.transpose(cofactor).getValues()));
        //System.out.println(Arrays.deepToString(hola.matrizInversa(matricita)));
    }

}
