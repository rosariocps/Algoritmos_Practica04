package Actividad_01;
import java.util.Scanner;

public class PrincipalPrueba {
    public static void main(String[] args) {
        Scanner scannerr = new Scanner(System.in);

        //Ingreso de cantidad de discos
        System.out.print("Ingrese el número de discos: ");
        int numDiscos = scannerr.nextInt();
        // S reinicia el contador de movimientos antes de empezar 
        TorresDeHanoi.resetearMovimientos(); // Limpiar antes de iniciar
        TorresDeHanoi.torresHanoi(numDiscos, 1, 2, 3);
        //Total de movimientos
        System.out.println("\nTotal de movimientos: " + TorresDeHanoi.obtenerMovimientos());

        scannerr.close();
    }
}
