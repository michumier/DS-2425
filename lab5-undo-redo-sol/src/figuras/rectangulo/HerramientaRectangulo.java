package figuras.rectangulo;

import java.awt.Point;

import editor.cores.Editor;
import editor.cores.*;
import editor.herramientas.HerramientaCreacion;

public class HerramientaRectangulo extends HerramientaCreacion {

    public HerramientaRectangulo(Editor editor) {
        super(editor);
    }

    protected Figura doCreaFigura(Point inicio, Point fin) {
        return new Rectangulo(inicio, fin);
    }
}
