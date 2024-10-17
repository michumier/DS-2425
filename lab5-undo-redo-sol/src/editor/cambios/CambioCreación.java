package editor.cambios;

import editor.cores.*;

public class CambioCreación implements Cambio {

    private Figura figura;
    private Dibujo dibujo;

    public CambioCreación(Dibujo dibujo, Figura figura) {
        this.figura = figura;
        this.dibujo = dibujo;
    }

    public void undo() {
        dibujo.removeFigura(figura);
    }

    public void redo() {
        dibujo.addFigura(figura);
    }

}
