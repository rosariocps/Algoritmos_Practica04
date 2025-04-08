package Ejercicio1;

import java.util.*;

public class SubconjuntoPotencias {
    public static void procesarEntrada(String linea) {
        String[] partes = linea.trim().split(" "); // separamos los numeros por espacios
        int N = Integer.parseInt(partes[0]); // el primer numero es la cantidad de elementos
        int[] arreglo = new int[N]; // creamos el arreglo con ese tamaño

        for (int i = 0; i < N; i++) {
            arreglo[i] = Integer.parseInt(partes[i + 1]); // guardamos los numeros en el arreglo
        }

        int objetivo = Integer.parseInt(partes[partes.length - 1]); // el ultimo numero es el objetivo
        boolean resultado = sePuedeFormarSuma(arreglo, objetivo); // vemos si se puede formar la suma
        System.out.println("Resultado: " + resultado); // mostramos el resultado
    }
    public static void ejecutarPruebaEjemplo() {
        String prueba = "5 4 8 10 3 6 27"; // esta es la prueba de ejemplo que se va a usar
        System.out.println("\nPrueba de ejemplo:");
        System.out.println("Entrada: " + prueba);
        procesarEntrada(prueba); // mandamos la prueba al metodo que procesa la entrada
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