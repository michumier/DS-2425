package editor.cores;

import java.io.*;

import editor.herramientas.HerramientaSeleccion;
import figuras.circulo.HerramientaCirculo;
import figuras.rectangulo.HerramientaRectangulo;
import figuras.triangulo.HerramientaTriangulo;

public class Editor {
    public Editor() {
        dibujo = new Dibujo();

        historial = new Historial();

        doCreateTools();
    }

    protected void doCreateTools() {
        rectangulo = new HerramientaRectangulo(this);
        circulo = new HerramientaCirculo(this);
        triangulo = new HerramientaTriangulo(this);
        seleccion = new HerramientaSeleccion(this);

        actual = seleccion;
    }

    public void run() throws IOException {
        System.out.println("\nComandos de Herramientas: rectangulo | circulo | triangulo | seleccion");
        System.out.println("Comandos de Ratón: pinchar x,y | mover x,y | soltar x,y");
        System.out.println("Otros Comandos: dibujar | exit \n");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.print("> ");
            String[] line = in.readLine().split("[ ,]");

            if (line[0].equals("exit"))
                return;

            //$ Activación de Herramientas -----------------------------

            // La activación de herramientas podría simplificarse usando una tabla hash

            if (line[0].startsWith("rec"))
                setHerramienta(rectangulo);

            else if (line[0].startsWith("cir"))
                setHerramienta(circulo);

            else if (line[0].startsWith("tri"))
                setHerramienta(triangulo);

            else if (line[0].startsWith("sel"))
                setHerramienta(seleccion);

            //$ Acciones del Ratón -----------------------------

            else if (line[0].startsWith("pin"))
                actual.pinchar(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

            else if (line[0].startsWith("mov"))
                actual.mover(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

            else if (line[0].startsWith("sol"))
                actual.soltar(Integer.parseInt(line[1]), Integer.parseInt(line[2]));

            //$ Comandos de Undo/Redo -----------------------------

            else if (line[0].startsWith("und"))
                historial.undo();
            else if (line[0].startsWith("red"))
                historial.redo();

            //$ Otros comandos -----------------------------

            else if (line[0].startsWith("dib"))
                dibujar();

            else
                System.out.println("Comando no válido");

        } while (true);
    }

    //$ Métodos del dibujo -----------------------------

    public Dibujo getDibujo() {
        return dibujo;
    }

    public void dibujar() {

        dibujo.dibuja();

        System.out.println("  => [" + actual.getClass().getSimpleName() + " activada]");
        System.out.println();
    }

    //$ Métodos de Herramientas ---------------------

    public void setHerramienta(Herramienta herramienta) {
        this.actual = herramienta;
    }

    public void finHerramienta() {
        actual = seleccion;
    }

    //$ Métodos de Undo/Redo -----------------------------

    public Historial getHistorial() {
        return historial;
    }

    private Historial historial;

    private Dibujo dibujo;
    private Herramienta rectangulo, circulo, triangulo;

    private Herramienta actual, seleccion;

}
