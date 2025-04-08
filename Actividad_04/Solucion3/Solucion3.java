package Actividad_04.Solucion3;

public class Solucion3 {

    public static int moda3(int[] arreglo, int inicio, int fin) {
        SetVectors conjuntoHomogeneo = new SetVectors();
        SetVectors conjuntoHeterogeneo = new SetVectors();

        conjuntoHeterogeneo.insertar(new Limits(inicio, fin));

        while (conjuntoHeterogeneo.longitudMayor() > conjuntoHomogeneo.longitudMayor()) {
            Limits segmentoActual = conjuntoHeterogeneo.extraerMayor();
            int valorPivote = arreglo[(segmentoActual.inicio + segmentoActual.fin) / 2];

            Limits izquierda = new Limits(0, 0);
            Limits centro = new Limits(0, 0);
            Limits derecha = new Limits(0, 0);

            Pivote2.dividirEnTres(arreglo, valorPivote, segmentoActual.inicio, segmentoActual.fin, izquierda, centro, derecha);

            if (izquierda.inicio <= izquierda.fin) conjuntoHeterogeneo.insertar(izquierda);
            if (derecha.inicio <= derecha.fin) conjuntoHeterogeneo.insertar(derecha);
            if (centro.inicio <= centro.fin) conjuntoHomogeneo.insertar(centro);
        }

        if (conjuntoHomogeneo.estaVacio()) return arreglo[inicio];

        Limits segmentoModa = conjuntoHomogeneo.extraerMayor();
        return arreglo[segmentoModa.inicio];
    }
}