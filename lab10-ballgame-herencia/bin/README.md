## BallGame

Juego multiplataforma, ahora mismo tiene un enum (obviamente eliminar) y un método play con todo dentro y muchos switch y lógica condicional.

### Versión 1: Adapter

- Se crea un adapter para cada plataforma, teniendo como base la interfaz Platform.
    - Con esto se consigue que no tengas que modificar nada de las APIs.
    - Esto es útil porque si no pudiéramos acceder a las clases en si, si fuera una API externa, no podemos modificarla, entonces tendríamos que adaptarla a nuestro comportamiento.
    - Eliminamos la lógica condicional y obligamos a crear la plataforma que queremos antes de realizar el juego sin switches.

### Versión 2: Template method

- Hacemos al BallGame Abstracto.
- Seguimos unos principios parecidos al Adapter, no modificamos las clases API.
    - Creamos un juego por cada API, solo que en vez de implementar la interfaz Platform, hacemos que extienda ball game.
    - Definimos una estructura base que se extiende en los hijos.

### Diferencias

- El template es útil si va a haber funcionalidad común previa a la llamada de los métodos (pasos opcionales) y puedes permitir que si en una plataforma implementas JuegoOnline puedes hacer que sea en algunas si y en otras no, mientras que en el adapter le obligas a hacerlo.
- Lo bueno del adapter es que si hubiera varias plataformas que fueran de una misma jerarquía, las puedes adaptar a la vez.
- Si hay un juego nuevo, el adapter vale para usarse de nuevo, pero en el template tienes que hacer todas las clases de nuevo.
