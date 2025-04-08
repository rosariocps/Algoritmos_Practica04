package Actividad2;

import javax.swing.*; // importa las clases para crear la interfaz grafica
import java.awt.*; // importa las clases para trabajar con gráficos
import java.awt.geom.*; // importa clases para manejar geometría
import java.util.*; // importa clases de utilidades como listas

public class PythagorasTree extends JPanel {
    private int profundidad; // guardamos el nivel de profundidad del arbol

    // constructor que recibe el nivel de profundidad y establece el tamaño del panel
    public PythagorasTree(int profundidad) {
        this.profundidad = profundidad; // guardamos la profundidad recibida
        setPreferredSize(new Dimension(800, 800)); // establecemos el tamaño del panel a 800x800
    }

    // este metodo se llama automaticamente para dibujar los graficos en el panel
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // llamamos al metodo de la clase base para pintar el fondo
        Graphics2D g2d = (Graphics2D) g; // convertimos el Graphics en Graphics2D para poder usar mas opciones de dibujo
        g2d.setColor(Color.BLACK); // cambiamos el color a negro para el fondo
        g2d.fillRect(0, 0, getWidth(), getHeight()); // rellenamos todo el panel con el color negro
        g2d.setColor(Color.GREEN); // cambiamos el color a verde para los cuadrados

        // aqui iniciamos la recursión llamando a trazaArbol con la posición y tamaño iniciales
        trazaArbol(g2d, 350, 600, 100, -90, profundidad);
    }

    // esta funcion es la que dibuja el arbol de manera recursiva
    private void trazaArbol(Graphics2D g, int x, int y, int lado, double angulo, int nivel) {
        if (nivel == 0 || lado < 2) return; // caso base: si el nivel llega a 0 o el lado es muy pequeño, termina la recursión
        // calculamos la nueva posición donde se dibujará la línea
        int x2 = x + (int) (lado * Math.cos(Math.toRadians(angulo)));
        int y2 = y + (int) (lado * Math.sin(Math.toRadians(angulo)));
        
        // dibujamos la línea entre las dos posiciones calculadas
        g.drawLine(x, y, x2, y2);

        // se calcula el nuevo tamaño del cuadrado, que es un 70% del tamaño anterior
        int nuevoLado = (int) (lado * 0.7); 
        
        // aqui hacemos dos llamadas recursivas para dibujar los dos cuadrados en las direcciones de los ángulos
        trazaArbol(g, x2, y2, nuevoLado, angulo - 45, nivel - 1); // llamado recursivo hacia la izquierda
        trazaArbol(g, x2, y2, nuevoLado, angulo + 45, nivel - 1); // llamado recursivo hacia la derecha
    }
    public static void main(String[] args) {       
        // creamos el arbol con 6 niveles y lo añadimos a la ventana
        PythagorasTree arbol6 = new PythagorasTree(6);
        JFrame frame6 = new JFrame("Árbol de Pitágoras - 6 Niveles"); // creamos una ventana con el título
        frame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // configuramos que la aplicación se cierre al cerrar la ventana
        frame6.setSize(800, 800); // establecemos el tamaño de la ventana a 800x800 píxeles
        frame6.add(arbol6); 
        frame6.setVisible(true); // hacemos visible la ventana
        
        // creamos otro arbol con 8 niveles y una nueva ventana para mostrarlo
        PythagorasTree arbol8 = new PythagorasTree(8);
        JFrame frame8 = new JFrame("Árbol de Pitágoras - 8 Niveles"); // creamos una ventana con el título
        frame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // configuramos que la aplicación se cierre al cerrar la ventana
        frame8.setSize(800, 800); // establecemos el tamaño de la ventana a 800x800 píxeles
        frame8.add(arbol8);
        frame8.setVisible(true);

        // creamos otro arbol con 10 niveles y otra ventana para mostrarlo
        PythagorasTree arbol10 = new PythagorasTree(10);
        JFrame frame10 = new JFrame("Árbol de Pitágoras - 10 Niveles"); // creamos una ventana con el título
        frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // configuramos que la aplicación se cierre al cerrar la ventana
        frame10.setSize(800, 800); // establecemos el tamaño de la ventana a 800x800 píxeles
        frame10.add(arbol10);
        frame10.setVisible(true);
    }
}