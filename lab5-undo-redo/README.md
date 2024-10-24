## Instrucciones

No olvidéis renombrar vuestro proyecto antes de subirlo al campus virtual, con el siguiente formato: apellido1_apellido2_nombre_labX, donde X es el número de la práctica correspondiente. Emplead solo letras minúsculas y sin acentos u otros caracteres especiales. Por ejemplo, una alumna llamada María Peláez Nuño debería renombrar su proyecto como pelaez_nuno_maria_lab5.

Si por alguna razón necesitarais enviar más de un proyecto, añadid un sufijo a lo anterior para identificar cada uno.

Tened en cuenta que, si estáis usando Eclipse, deberéis renombrar el proyecto _desde dentro del propio Eclipse_. En el caso de Visual Studio Code debería bastar con renombrar directamente la carpeta raíz.

## UNDO Y REDO - COMMAND

Sistema de hacer y deshacer en el editor gráfico. Hay que implementar que el editor tenga un "botón" de deshacer, que coja de una lista donde están apuntados los cambios y vuelva atrás (que vuelva al dibujo anterior).

- En caso de mover la figura, solo guarde la figura al soltar.

### Solución

- Hay que basarse en dos pilas, una para undo y otra para redo (se puede hacer en una pero mejor en 2).
- Para los casos de crear figuras: figure --> drawing.remove(figure). Si hemos creado una figura, para deshacer, la borramos, pero al hacer el redo, la creamos de nuevo.
- Para los casos de mover figuras: figure dx, dy --> figure.moveBy(-dx, -dy). Al mover una figura, guardamos la distancia que se movió y para redo lo mismo.
- Clave: Envolver el objeto.

