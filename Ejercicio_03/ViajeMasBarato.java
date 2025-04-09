package Ejercicio_03;


public class ViajeMasBarato {

    static int[][] calcularCostosMinimos(int[][] tarifas) {
        int n = tarifas.length;
        int[][] costos = new int[n][n];

        // Inicializamos la diagonal
        for (int i = 0; i < n; i++) {
            costos[i][i] = 0;
        }

        // Calculamos costos mínimos en orden diagonal
        for (int distancia = 1; distancia < n; distancia++) { // distancia entre i y j
            for (int i = 0; i < n - distancia; i++) {
                int j = i + distancia;
                costos[i][j] = tarifas[i][j]; // costo directo

                for (int k = i + 1; k < j; k++) {
                    costos[i][j] = Math.min(costos[i][j], tarifas[i][k] + costos[k][j]);
                }
            }
        }

        return costos;
    }

    static void imprimirMatriz(String titulo, int[][] matriz, boolean triangularSuperior) {
        int n = matriz.length;
        System.out.println(titulo + ":\n");

        // Encabezado de columnas
        System.out.print("     ");
        for (int j = 0; j < n; j++) {
            System.out.printf(" %4d", j);
        }
        System.out.println();

        
        System.out.print("     ");
        for (int j = 0; j < n; j++) {
            System.out.print("-----"); // Línea separadora
        }
        System.out.println();

        // Contenido de la matriz
        for (int i = 0; i < n; i++) {
            System.out.printf("%3d |", i);
            for (int j = 0; j < n; j++) {
                if (!triangularSuperior || i <= j) {
                    System.out.printf(" %4d", matriz[i][j]);
                } else {
                    System.out.print("    -");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] tarifas = {
            { 0,  6, 14, 20, 25, 13, 18, 100},
            { 0,  0,  7, 18, 21, 15, 40, 19},
            { 0,  0,  0,  3, 10, 70, 14, 16},
            { 0,  0,  0,  0,  5, 13, 11, 50},
            { 0,  0,  0,  0,  0,  8,  6,  9},
            { 0,  0,  0,  0,  0,  0,  9,  3},
            { 0,  0,  0,  0,  0,  0,  0,  2},
            { 0,  0,  0,  0,  0,  0,  0,  0}
        };
        

        int[][] costos = calcularCostosMinimos(tarifas);

        imprimirMatriz("Matriz de tarifas T[i][j]", tarifas, true);
        imprimirMatriz("Matriz de costos mínimos C[i][j]", costos, true);
    }
}
