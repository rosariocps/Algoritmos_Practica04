package Ejercicio1;

import java.util.*;

public class SubconjuntoPotencias {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creamos un objeto Scanner para leer datos
        int opcion = -1; // Variable para almacenar la opción del menú

        // Empezamos un ciclo while que va a seguir ejecutándose hasta que se elija la opción de salir (0)
        while (opcion != 0) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Ingresar un conjunto manualmente");
            System.out.println("2. Ejecutar pruebas de ejemplo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt(); // Leemos la opción elegida
            sc.nextLine(); // Limpiamos el buffer del Scanner

            // Usamos un switch para manejar las opciones del menú
            switch (opcion) {
                case 1:
                    // Opción 1: el usuario ingresa un conjunto manualmente
                    System.out.println("NOTA:");
                    System.out.println("- 1er num -> cantidad de elementos del arreglo ");
                    System.out.println("- Luego los elementos del arreglo");
                    System.out.println("- Último número -> objetivo (suma esperada)");
                    System.out.print("Ingresa los números separados por espacio (ej. 5 2 4 8 10 3 14): ");
                    String linea = sc.nextLine(); // Leemos la línea de entrada
                    procesarEntrada(linea); // Procesamos la entrada
                    break;

                case 2:
                    // Opción 2: ejecutar pruebas predefinidas
                    ejecutarPruebas();
                    break;

                case 0:
                    // Opción 0: Salir del programa
                    System.out.println("chauuu");
                    break;

                default:
                    // Si el usuario ingresa una opción inválida
                    System.out.println("Opción inválida.");
            }
        }
    }
    // Método para procesar la entrada que el usuario da
    public static void procesarEntrada(String linea) {
        String[] partes = linea.trim().split(" "); // Separamos la entrada en partes
        int N = Integer.parseInt(partes[0]); // El primer número es la cantidad de elementos
        int[] arreglo = new int[N]; // Creamos un arreglo con los elementos

        for (int i = 0; i < N; i++) {
            arreglo[i] = Integer.parseInt(partes[i + 1]); // Llenamos el arreglo con los valores
        }

        int objetivo = Integer.parseInt(partes[partes.length - 1]); // El último número es el objetivo
        boolean resultado = sePuedeFormarSuma(arreglo, objetivo); // Llamamos al método que verifica si es posible formar la suma
        System.out.println("Resultado: " + resultado); // Mostramos el resultado
    }
    public static void ejecutarPruebas() {
        String[] pruebas = {
            "5 2 4 8 10 3 14",    // true
            "5 4 8 10 3 5 27",    // false
            "5 4 8 10 3 6 27",    // false
            "6 2 16 5 7 10 33",   // false
            "6 2 16 5 3 10 33",   // false
            "4 2 5 1 6 13"        // false
        };

        // Ejecutamos cada prueba
        for (String prueba : pruebas) {
            System.out.println("\nEntrada: " + prueba); // Mostramos la entrada
            procesarEntrada(prueba); // Procesamos la entrada
        }
    }
    public static boolean sePuedeFormarSuma(int[] arr, int objetivo) {
        List<Integer> obligatorios = new ArrayList<>(); // aqui se guardan los numeros que son potencias de 2
        List<Integer> opcionales = new ArrayList<>(); // aqui van los demas numeros validos

        for (int i = 0; i < arr.length; i++) {
            int actual = arr[i];

            if (esPotenciaDeDos(actual)) {
                obligatorios.add(actual); // las potencias de 2 siempre se usan
            } else if (esMultiploDeCinco(actual)) {
                // si es multiplo de 5 y no esta seguido por un impar o es el ultimo, lo agregamos
                if (i == arr.length - 1 || !esImpar(arr[i + 1])) {
                    opcionales.add(actual);
                }
                // si esta seguido de impar, no lo usamos
            } else {
                opcionales.add(actual); // los demas numeros tambien se pueden usar
            }
        }

        int sumaObligatoria = sumaLista(obligatorios); // sumamos los numeros obligatorios
        int objetivoRestante = objetivo - sumaObligatoria; // restamos esa suma al objetivo

        if (objetivoRestante < 0) return false; // si ya nos pasamos, no se puede
        return sePuedeFormarSubconjunto(opcionales, objetivoRestante); // vemos si con los opcionales llegamos al objetivo restante
    }
    public static boolean esPotenciaDeDos(int n) {
        return n > 0 && (n & (n - 1)) == 0; // forma rapida de saber si es potencia de 2
    }

    public static boolean esMultiploDeCinco(int n) {
        return n % 5 == 0; // verifica si es divisible entre 5
    }

    public static boolean esImpar(int n) {
        return n % 2 != 0; // verifica si es impar
    }

    public static int sumaLista(List<Integer> lista) {
        int suma = 0;
        for (int num : lista) suma += num; // suma todos los numeros de la lista
        return suma;
    }

    public static boolean sePuedeFormarSubconjunto(List<Integer> nums, int objetivo) {
        int n = nums.size();
        boolean[][] dp = new boolean[n + 1][objetivo + 1]; // creamos una tabla dp

        for (int i = 0; i <= n; i++) dp[i][0] = true; // siempre se puede llegar a 0 sin usar nada

        for (int i = 1; i <= n; i++) {
            int num = nums.get(i - 1); // agarramos el numero actual
            for (int j = 0; j <= objetivo; j++) {
                if (j < num) {
                    dp[i][j] = dp[i - 1][j]; // si el numero es mayor que j, no lo usamos
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num]; // vemos si podemos llegar con o sin usar ese numero
                }
            }
        }
        return dp[n][objetivo]; // devuelve si se puede llegar al objetivo exacto
    }

}