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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1; // inicializamos la opcion con un valor fuera del rango

        while (opcion != 0) { // el ciclo se ejecuta mientras la opcion no sea 0
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ingresar un conjunto de datos");
            System.out.println("2. Ejecutar pruebas de ejemplo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt(); // leemos la opcion del usuario
            scanner.nextLine(); // limpiamos el buffer de entrada

            switch (opcion) {
                case 1: // caso para ingresar un conjunto de datos
                    System.out.print("Ingresa los elementos del arreglo separados por espacio: ");
                    String[] entrada = scanner.nextLine().split(" "); // leemos los datos y separarlos por espacio
                    int[] arreglo = new int[entrada.length]; // creamos un arreglo con el tamaño de los datos ingresados
                    for (int i = 0; i < entrada.length; i++) { // recorremos el arreglo para convertir los datos de String a int
                        arreglo[i] = Integer.parseInt(entrada[i]);
                    }

                    System.out.print("Ingresa el valor de k (1 para el menor, n (cant del arreglo) para el mayor): ");
                    int k = scanner.nextInt(); // leemos el valor de k

                    if (k < 1 || k > arreglo.length) { // verificamos si k está dentro del rango válido
                        System.out.println("k está fuera del rango válido.");
                    } else {
                        int resultado = quickSelect(arreglo, 0, arreglo.length - 1, k - 1); // llamamos a la función quickSelect
                        System.out.println("El elemento número " + k + " más pequeño es: " + resultado);
                    }
                    break;

                case 2: // caso para ejecutar las pruebas de ejemplo
                    ejecutarPruebas(); // llamamos a la función que ejecuta las pruebas
                    break;

                case 0: // caso para salir del programa
                    System.out.println("El programa termino :]");
                    break;

                default: // si la opción es invalida
                    System.out.println("Opción inválida.");
            }

        }

        scanner.close(); // cerramos el scanner para evitar posibles fugas de recursos
    }
}
