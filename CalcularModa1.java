//Actividad 4: Solución 1

public class CalcularModa1 {

    
    private static int frecuencia(int[] array, int first, int end, int ele) {    
        if (first > end) return 0;                                  // O(1)                                         
        int suma = 0;                                               // O(1)
        for (int i = first; i <= end; i++) {                        // O(n)
            if (array[i] == ele)                                    // O(1)
                suma++;                                             // O(1)                                                             
        }
        return suma;                                                // O(1)
    }

    //Complejidad Algoritmica de Frecuencia: O(n) en el peor caso


    public static int moda1(int array[]) {
        int first = 0;                                              // O(1)
        int end = array.length - 1;                                 // O(1)

        if (first == end)                                           // O(1)
            return array[first];                                    // O(1)

        int moda = array[first];                                    // O(1)
        //Ya sabemos que Frecuencia() es O(n) 
        int maxfrec = frecuencia(array, first, end, moda);          // O(n)

        for (int i = first + 1; i < end; i++) {                     // O(n)
            int frec = frecuencia(array, i, end, array[i]);         // O(n)
            if (frec > maxfrec) {                                   // O(1)
                maxfrec = frec;                                     // O(1)
                moda = array[i];                                    // O(1)
            }
        }

        return moda;
    }
    //Complejidad Algoritmica de moda1: O(n^2)
}
