package Actividad_05;

public class dpSolution {
    // Método de Programación Dinámica para calcular el valor máximo de la varilla
    static int getValue(int[] values, int rodLength) {
        int[] subSolutions = new int[rodLength + 1]; // Arreglo para almacenar las soluciones parciales
        // Iteramos sobre todas las longitudes posibles de varilla
        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1; // Valor máximo para la longitud 'i'
            // Probamos todas las combinaciones posibles de cortes
            for (int j = 0; j < i; j++) {
                tmpMax = Math.max(tmpMax, values[j] + subSolutions[i - j - 1]); // Sumamos el valor del corte y la solución de la sublongitud
            }
            subSolutions[i] = tmpMax; // Almacenamos la solución para la longitud 'i'
        }
        return subSolutions[rodLength]; // Devolvemos la solución para la longitud total
    }

    public static void main(String[] args) {
        int[] values = new int[]{3, 7, 1, 3, 9}; // Precios de las piezas
        int rodLength = values.length; // Longitud de la varilla
        System.out.println("El valor máximo: " + getValue(values, rodLength)); //  Resultado final
    }
}

