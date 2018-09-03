
/**
 * Representa una matriz de 2x2.
 * 
 * @author Flores González Luis.
 */
public class Matriz {

    private int[][] matriz;

    public Matriz() {
        this.matriz = new int[2][2];
    }

    public void setEntrada(int renglon, int columna, int valor) {
        this.matriz[renglon][columna] = valor;
    }

    public int getEntrada(int renglon, int columna) {
        return this.matriz[renglon][columna];
    }

    public Vector multiplicarVector(Vector vector) {
        Vector nuevoVector = new Vector();        
        int renglon0 = this.matriz[0][0] * vector.getEntrada(0) +
                       this.matriz[0][1] * vector.getEntrada(1);
        int renglon1 = this.matriz[1][0] * vector.getEntrada(0) +
                       this.matriz[1][1] * vector.getEntrada(1);
        nuevoVector.setEntrada(0, renglon0);
        nuevoVector.setEntrada(1, renglon1);
        
        return nuevoVector;
    }

    @Override
    public String toString() {
        String cadena = "";
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j <= this.matriz.length; j++) {
                if (j == this.matriz.length) {
                    cadena = cadena + "\n";
                } else {
                    cadena = cadena + " " + this.getEntrada(i, j);                    
                }
            }
        }
        cadena = cadena + "\n";
        return cadena;
    }
}
