
/**
 * Clase de ayuda para obtener matriz adjunta.
 * 
 * @author luis
 */
public class MatrixMathematics {

    /**
     * Esta clase usa Matrix y no puede ser instanciada.
     */
    private MatrixMathematics() {
    }

    /**
     * Transpuesta de una matriz - intercambia columnas con renglones.
     *
     * @param matrix
     * @return
     */
    public static Matrix transpose(Matrix matrix) {
        Matrix transposedMatrix = new Matrix(matrix.getNcols(), matrix.getNrows());
        for (int i = 0; i < matrix.getNrows(); i++) {
            for (int j = 0; j < matrix.getNcols(); j++) {
                transposedMatrix.setValueAt(j, i, matrix.getValueAt(i, j));
            }
        }
        return transposedMatrix;
    }

    /**
     * Determinanate de una matriz cuadrada.
     *
     * @param matrix
     * @return
     */
    public static double determinant(Matrix matrix) {
        if (!matrix.isSquare()) {
            System.out.println("La matriz necesita ser cuadrada.");
        }
        if (matrix.size() == 1) {
            return matrix.getValueAt(0, 0);
        }
        if (matrix.size() == 2) {
            return (matrix.getValueAt(0, 0) * matrix.getValueAt(1, 1)) - (matrix.getValueAt(0, 1) * matrix.getValueAt(1, 0));
        }
        double sum = 0.0;
        for (int i = 0; i < matrix.getNcols(); i++) {
            sum += changeSign(i) * matrix.getValueAt(0, i) * determinant(createSubMatrix(matrix, 0, i));
        }
        return sum;
    }

    /**
     * Determina el signo, es decir, los números pares tienen signo + e impares -.
     *
     * @param i
     * @return
     */
    private static int changeSign(int i) {
        if (i % 2 == 0) {
            return 1;
        }
        return -1;
    }

    /**
     * Crea una matriz excluyendo la columna y renglon dados.
     *
     * @param matrix
     * @param excluding_row
     * @param excluding_col
     * @return
     */
    public static Matrix createSubMatrix(Matrix matrix, int excluding_row, int excluding_col) {
        Matrix mat = new Matrix(matrix.getNrows() - 1, matrix.getNcols() - 1);
        int r = -1;
        for (int i = 0; i < matrix.getNrows(); i++) {
            if (i == excluding_row) {
                continue;
            }
            r++;
            int c = -1;
            for (int j = 0; j < matrix.getNcols(); j++) {
                if (j == excluding_col) {
                    continue;
                }
                mat.setValueAt(r, ++c, matrix.getValueAt(i, j));
            }
        }
        return mat;
    }

    /**
     * El cofactor de una matriz.
     *
     * @param matrix
     * @return
     */
    public static Matrix cofactor(Matrix matrix) {
        Matrix mat = new Matrix(matrix.getNrows(), matrix.getNcols());
        for (int i = 0; i < matrix.getNrows(); i++) {
            for (int j = 0; j < matrix.getNcols(); j++) {
                mat.setValueAt(i, j, changeSign(i) * changeSign(j) * determinant(createSubMatrix(matrix, i, j)));
            }
        }

        return mat;
    }

    /**
     * Convierte los valores doubles de una matriz a enteros.
     * 
     * @param matrix
     * @return 
     */
    public static int[][] toInt(Matrix matrix) {
        int[][] mat = new int[matrix.getNrows()][matrix.getNcols()];
        for (int i = 0; i < matrix.getNrows(); i++) {
            for (int j = 0; j < matrix.getNrows(); j++) {
                mat[i][j] = (int) matrix.getValueAt(i, j);
            }
        }
        return mat;
    }

}
