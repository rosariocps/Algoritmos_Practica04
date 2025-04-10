package Ejercicio_03;

public class ViajeMasBarato {

    static int[][] calcularCostosMinimos(int[][] tarifas) {
        int n = tarifas.length; // Número de estaciones
        int[][] costos = new int[n][n]; // Matriz para almacenar los costos mínimos

        // Inicializamos la diagonal
        for (int i = 0; i < n; i++) {
            costos[i][i] = 0; // El costo de ir de una estación a sí misma es cero
        }

        // Calculamos costos mínimos en orden diagonal para considerar primero trayectos cortos
        for (int distancia = 1; distancia < n; distancia++) { // distancia entre estaciones i y j
            for (int i = 0; i < n - distancia; i++) {
                int j = i + distancia; // Estación destino
                costos[i][j] = tarifas[i][j]; // Tomamos inicialmente el costo directo
                
                // Verificamos si hay una ruta más barata pasando por estaciones intermedias
                for (int k = i + 1; k < j; k++) { // Probamos todas las posibles estaciones intermedias entre i y j para encontrar el costo más barato
                    costos[i][j] = Math.min(costos[i][j], tarifas[i][k] + costos[k][j]);
                }
            }
        }

        return costos; // Devolvemos la matriz de costos mínimos
    }

    // Método para imprimir una matriz
    static void imprimirMatriz(String titulo, int[][] matriz, boolean triangularSuperior) {
        int n = matriz.length;
        System.out.println(titulo + ":\n"); // Título de la matriz

        // Encabezado de columnas
        System.out.print("     ");
        for (int j = 0; j < n; j++) {
            System.out.printf(" %4d", j);
        }
        System.out.println();

        // Línea separadora
        System.out.print("     ");
        for (int j = 0; j < n; j++) {
            System.out.print("-----"); // Línea separadora
        }
        System.out.println();

        // Contenido de la matriz
        for (int i = 0; i < n; i++) {
            System.out.printf("%3d |", i); // Índice de la fila
            for (int j = 0; j < n; j++) {
                if (!triangularSuperior || i <= j) {
                    // Se imprime el valor si representa un viaje posible
                    System.out.printf(" %4d", matriz[i][j]);
                } else {
                    // Se imprime un guion cuando el viaje va hacia atrás, lo cual no es posible
                    System.out.print("    -");
                }
            }
            System.out.println();
        }
        System.out.println(); // Línea extra al final
    }

    public static void main(String[] args) {
        // Matriz de tarifas directas entre estaciones
        int[][] tarifas = {
            { 0,  6, 14, 20, 25},
            { 0,  0,  7, 18, 21},
            { 0,  0,  0,  3, 10},
            { 0,  0,  0,  0,  5},
            { 0,  0,  0,  0,  0},
        };
        

        int[][] costos = calcularCostosMinimos(tarifas); // Calculamos los costos mínimos
        
        // Mostramos la matriz de tarifas original
        imprimirMatriz("Matriz de tarifas T[i][j]", tarifas, true);
        
        // Mostramos la matriz de costos mínimos calculados
        imprimirMatriz("Matriz de costos mínimos C[i][j]", costos, true);
    }
}


