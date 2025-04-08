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
    


}