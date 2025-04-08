package Actividad_04.Solucion3;

public class Pivote2 {
    public static void dividirEnTres(int[] arreglo, int valorPivote, int inicio, int fin, Limits izquierda, Limits centro, Limits derecha) {
        int[] temporal = new int[fin - inicio + 1];
        int izquierdaPuntero = 0;
        int contadorCentro = 0;
        int derechaPuntero = temporal.length - 1;

        for (int i = inicio; i <= fin; i++) {
            if (arreglo[i] < valorPivote) {
                temporal[izquierdaPuntero++] = arreglo[i];
            } else if (arreglo[i] == valorPivote) {
                contadorCentro++;
            } else {
                temporal[derechaPuntero--] = arreglo[i];
            }
        }

    }
}

