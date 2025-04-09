package Actividad_03;

public class PruebaRecursiva {
    public static void main(String[] args) {
        BinarySearchRecursivo buscador = new BinarySearchRecursivo();

        // Arreglo ordenado
        int[] arreglo = {1, 2, 3, 4, 5};

        // Número que queremos buscar
        int valorBuscado = 4;

        // Llamamos al método recursivo pasando los índices inicial y final
        int posicion = buscador.binarySearch(arreglo, 0, arreglo.length - 1, valorBuscado);

        // Mostramos el resultado
        if (posicion == -1)
            System.out.println("Elemento no encontrado.");
        else
            System.out.println("Elemento encontrado en el índice: " + posicion);
    }
}
