package Actividad_03;

public class PruebaIterativa {
    public static void main(String[] args) {
        BinarySearchIterativo buscador1=new BinarySearchIterativo();

        int[] arreglo = {1,2,3,4,5};

        int valorABuscar=2;

        int posicion = buscador1.binarySearch(arreglo, valorABuscar);
        
        if (posicion==-1){
            System.out.println("Elemento no encontrado");

        }else{
            System.out.println("Elemento encontrado en el índice , " + posicion);
        }

    }
}
