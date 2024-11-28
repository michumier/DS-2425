## BallGame

Juego multiplataforma, ahora mismo tiene un enum (obviamente eliminar) y un método play con todo dentro y muchos switch y lógica condicional.

### Versión 1: Adapter

- Se crea un adapter para cada plataforma, teniendo como base la interfaz Platform.
    - Con esto se consigue que no tengas que modificar nada de las APIs.
    - Esto es útil porque si no pudiéramos acceder a las clases en si, si fuera una API externa, no podemos modificarla, entonces tendríamos que adaptarla a nuestro comportamiento.
    - Eliminamos la lógica condicional y obligamos a crear la plataforma que queremos antes de realizar el juego sin switches.

### Versión 2: Abstract method