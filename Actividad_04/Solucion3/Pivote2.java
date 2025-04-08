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
     
        int indice = inicio;
        for (int i = 0; i < izquierdaPuntero; i++) arreglo[indice++] = temporal[i];
        for (int i = 0; i < contadorCentro; i++) arreglo[indice++] = valorPivote;
        for (int i = temporal.length - 1; i > derechaPuntero; i--) arreglo[indice++] = temporal[i];

        int finIzquierda = inicio + izquierdaPuntero - 1;
        int inicioCentro = finIzquierda + 1;
        int finCentro = inicioCentro + contadorCentro - 1;

        izquierda.inicio = inicio;
        izquierda.fin = finIzquierda;

        centro.inicio = inicioCentro;
        centro.fin = finCentro;

        derecha.inicio = finCentro + 1;
        derecha.fin = fin;
    }
}

