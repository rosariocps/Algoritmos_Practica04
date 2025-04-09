package Actividad_03;
public class BinarySearchRecursivo {

    // Este método hace lo mismo que el iterativo, pero usando recursividad
    public int binarySearch(int arr[], int lo, int hi, int x) {
        // Verificamos que los límites sean válidos
        if (hi >= lo && lo < arr.length) {
            // Calculamos el punto medio
            int mid = lo + (hi - lo) / 2;

            // Si encontramos el elemento, devolvemos su posición
            if (arr[mid] == x)
                return mid;

            // Si el valor del medio es mayor al que buscamos, buscamos en la mitad izquierda
            if (arr[mid] > x)
                return binarySearch(arr, lo, mid - 1, x);

            // Si el valor del medio es menor, buscamos en la mitad derecha
            return binarySearch(arr, mid + 1, hi, x);
        }

        // Si no encontramos el valor, devolvemos -1
        return -1;
    }
}
