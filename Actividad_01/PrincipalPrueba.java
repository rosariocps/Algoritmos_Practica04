package Actividad_01;
import java.util.Scanner;

public class PrincipalPrueba {
    public static void main(String[] args) {
        Scanner scannerr = new Scanner(System.in);

        System.out.print("Ingrese el número de discos: ");
        int numDiscos = scannerr.nextInt();

        TorresDeHanoi.resetearMovimientos(); // Limpiar antes de iniciar
        TorresDeHanoi.torresHanoi(numDiscos, 1, 2, 3);

        System.out.println("\nTotal de movimientos: " + TorresDeHanoi.obtenerMovimientos());
    }
}
