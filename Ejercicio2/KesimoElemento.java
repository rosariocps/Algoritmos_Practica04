package Ejercicio2;
import java.util.Scanner;

public class KesimoElemento {
    // metodo QuickSelect para encontrar el k-ésimo elemento mas pequeño
    public static int quickSelect(int[] arr, int inicio, int fin, int k) {
        //caso base
        if (inicio == fin) { // si solo queda un elemento en el arreglo
            return arr[inicio]; // devolvemos ese elemento
        }

        int pivoteIndex = particionar(arr, inicio, fin); // particionamos el arreglo usando un pivote

        if (k == pivoteIndex) { // si encontramos el elemento en la posición k
            return arr[k]; // devolvemos el valor en la posición k
        } else if (k < pivoteIndex) { // si k está antes del pivote
            return quickSelect(arr, inicio, pivoteIndex - 1, k); // buscamos en la parte izquierda del arreglo
        } else { // si k está después del pivote
            return quickSelect(arr, pivoteIndex + 1, fin, k); // buscamos en la parte derecha del arreglo
        }
    }
    // metodo para particionar el arreglo (usado en QuickSelect)
    public static int particionar(int[] arr, int inicio, int fin) {
        int pivote = arr[fin]; // el pivote es el último elemento del arreglo
        int i = inicio; // i empieza en el inicio del arreglo

        // recorremos el arreglo para reorganizar los elementos
        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) { // si el elemento es menor o igual al pivote
                intercambiar(arr, i, j); // intercambiamos los elementos
                i++; // incrementar i
            }
        }

        intercambiar(arr, i, fin); // colocamos el pivote en su posición final
        return i; // devolvemos la posición del pivote
    }
}
