package Actividad_03;

public class BinarySearchIterativo{ 

    public int binarySearch(int arr[], int x) { // Este mpetodo busca un número(x) dentro del arreglo (arr)
        int lo = 0;                        //Límite inferior 
        int hi = arr.length-1;             //Límite superior

        while (lo <= hi){ //Bucle se repite mientras que el límite inferior no sobrepase al límite superior
            int mid = lo + (hi-lo)/2;   //Punto medio del arregloo
            
            if (arr[mid]==x) //si se encuentra el elemento en el medio, se devuelve ese valor
                return mid;

            if (arr[mid]<x)  // si el valor del medio es menor al que se busca, se empezará a buscar en la parte derecha, estos son mayores
                lo=mid+1;

            else
                hi=mid-1; //si el valor del medio es mayor al que se busca, se empezará a buscar en la parte izquiera, estos son menores 
        
        
        
        }
        return -1; //si no se encuentra el valor, se retorna -1 
    }
}
