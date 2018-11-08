
public class Main{

    public static void main(String[] args) {
        //antes el limite era 100
        generarEcuaciones(2, 3121, 1000);
    }

    public static void generarEcuaciones(int alfa, int ro, int limite){
        for(int i = 0; i < limite; i++){
            double potencia = Math.pow(alfa, i);
            double modulo = potencia % ro;
            System.out.println(alfa + "^" + i + " mod " + ro + " = " + modulo);
        }
    }
}