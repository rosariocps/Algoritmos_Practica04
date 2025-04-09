package Actividad_05;

public class naiveSolution {
    // Método recursivo que calcula el valor máximo para una longitud de varilla dada
    static int getValue(int[] values, int length) {
        if (length <= 0) // Caso base: si la longitud es 0 o negativa, no hay valor
            return 0;
        
        int tmpMax = -1; // Valor máximo inicial
        // Probamos todas las combinaciones posibles de cortes
        for (int i = 0; i < length; i++) {
            // Calculamos el valor máximo sumando el precio de un corte y el valor de la parte restante
            tmpMax = Math.max(tmpMax, values[i] + getValue(values, length - i - 1));
        }
        return tmpMax; // Devolvemos el valor máximo encontrado
    }

    public static void main(String[] args) {
        int[] values = new int[]{3, 7, 1, 3, 9}; // Precios de las piezas
        int rodLength = values.length; // Longitud de la varilla
        System.out.println("El valor máximo: " + getValue(values, rodLength)); // Resultado final
    }
}
