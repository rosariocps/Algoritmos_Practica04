package Actividad_04.Solucion3;

public class Limits {
    public int inicio;
    public int fin;

    public Limits(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public int longitud() {
        return fin - inicio + 1;
    }
}
