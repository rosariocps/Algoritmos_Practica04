package Actividad_04.Solucion3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SetVectors {
    private PriorityQueue<Limits> subarreglos;

    public SetVectors() {
        subarreglos = new PriorityQueue<>(Comparator.comparingInt(Limits::longitud).reversed());
    }

    public void insertar(Limits subarreglo) {
        if (subarreglo.inicio <= subarreglo.fin) {
            subarreglos.add(subarreglo);
        }
    }

    public Limits extraerMayor() {
        return subarreglos.poll();
    }

    public int longitudMayor() {
        if (subarreglos.isEmpty()) return 0;
        return subarreglos.peek().longitud();
    }

    public boolean estaVacio() {
        return subarreglos.isEmpty();
    }

    public void destruir() {
        subarreglos.clear();
    }
}