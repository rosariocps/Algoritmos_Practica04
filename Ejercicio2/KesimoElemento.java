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
    // metodo para intercambiar dos elementos en el arreglo
    public static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i]; // guardamos temporalmente el valor de arr[i]
        arr[i] = arr[j]; // ponemos el valor de arr[j] en arr[i]
        arr[j] = temp; // ponemos el valor guardado de arr[i] en arr[j]
    }
    // metodo para ejecutar las pruebas predefinidas con valores de ejemplo
    public static void ejecutarPruebas() {
        String[] pruebas = {
            "4 2 7 10 4 17, 3",  // 4
            "4 2 7 10 4 1 6, 5",  // 6
            "4 2 7 1 4 6, 1",     // 1
            "9 2 7 1 7, 4"        // 7
        };

        // recorremos cada prueba predefinida
        for (String prueba : pruebas) {
            String[] partes = prueba.split(", "); // separamos el arreglo y el valor de k
            String[] arregloStr = partes[0].split(" "); // separamos los elementos del arreglo
            int[] arreglo = new int[arregloStr.length]; // creamos un arreglo para los elementos
            for (int i = 0; i < arregloStr.length; i++) { // convertimos los valores de String a int
                arreglo[i] = Integer.parseInt(arregloStr[i]);
            }
            int k = Integer.parseInt(partes[1]); // leemos el valor de k
            System.out.println("\nEntrada: " + partes[0] + " k = " + k);
            int resultado = quickSelect(arreglo, 0, arreglo.length - 1, k - 1); // buscamos el k-ésimo elemento
            System.out.println("Resultado: " + resultado);
        }
    }
}
