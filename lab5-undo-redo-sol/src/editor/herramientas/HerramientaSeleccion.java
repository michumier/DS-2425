package editor.herramientas;

import java.awt.Point;

import editor.cambios.*;
import editor.cores.Editor;
import editor.cores.*;

public class HerramientaSeleccion implements Herramienta {

    public HerramientaSeleccion(Editor editor) {
        this.editor = editor;
    }

    public void pinchar(int x, int y) {
        seleccionada = editor.getDibujo().getFigura(x, y);
        inicio = anterior = new Point(x, y);
    }

    public void mover(int x, int y) {
        mueveIncremento(x, y);
    }

    public void soltar(int x, int y) {
        mueveIncremento(x, y);

        if (seleccionada != null)
            editor.getHistorial()
                    .añadeCambio(new CambioMovimiento(seleccionada, anterior.x - inicio.x, anterior.y - inicio.y));
    }

    private void mueveIncremento(int x, int y) {
        if (seleccionada != null) {
            seleccionada.mover(x - anterior.x, y - anterior.y);
            anterior = new Point(x, y);
        }
    }

    private Point inicio, anterior;

    private Editor editor;
    private Figura seleccionada;
}
