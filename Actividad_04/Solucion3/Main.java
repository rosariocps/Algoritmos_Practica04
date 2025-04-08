package Actividad_04.Solucion3;

public class Main {
    public static void main(String[] args) {
        int[] datos = {2,1,5,1,2,3,4,4,6,7,1,2,4,4};
        int moda = Solucion3.moda3(datos, 0, datos.length - 1);
        System.out.println("Moda: " + moda);
    }
}