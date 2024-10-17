package figuras.rectangulo;

import java.awt.Point;

import editor.cores.Figura;

public class Rectangulo implements Figura {

    public Rectangulo(Point esquina, int ancho, int alto) {
        this.esquina = new Point(esquina);
        this.ancho = ancho;
        this.alto = alto;
    }

    public Rectangulo(Point inicio, Point fin) {
        this(inicio, fin.x - inicio.x, fin.y - inicio.y);
    }

    public void dibujar() {
        System.out.println(
                "  - Rectangulo: x = " + esquina.x + ", y = " + esquina.y + ", ancho = " + ancho + ", alto = " + alto);
    }

    public void mover(int dx, int dy) {
        esquina.translate(dx, dy);
    }

    public boolean contiene(int x, int y) {
        return (esquina.x <= x && x <= esquina.x + ancho) && (esquina.y <= y && y <= esquina.y + alto);
    }

    private Point esquina;
    private int ancho;
    private int alto;
}
