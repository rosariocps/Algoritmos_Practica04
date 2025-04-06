public class Solucion2 {

    public static int moda2(int array[]) { 
        int first = 1; //i
        int p = 0; // p es el inicio del grupo actual de números repetidos
        int end = array.length - 1;
        int moda = array[0]; // Asumimos que la moda es el primer numero
        int frec = 1; 
        int maxrec = 0; // Máxima Frecuencia hasta ahora

        while (first <= end) {
            if (array[p] == array[first]) { // Si el número actual se repite
                frec++; // Aumentamos la frecuencia en 1
                first++; // Avanzamos al siguiente elemento 
            } else {
                if (frec > maxrec) { // Si la frecuencia actual es la mayor hasta ahora
                    maxrec = frec;
                    moda = array[p];
                }
                p = first;
                first = p + 1;
                frec = 1;
            }
        }

        return moda;
    }
}
