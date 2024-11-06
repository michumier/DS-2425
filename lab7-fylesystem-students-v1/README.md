## FILESYSTEM - LAB 7

- Se aplica un Strategy a la solución inicial para encapsular responsabilidades.
- Se piden rediseños con modificaciones --> normalizar, cifrar y eliminar espacios.
- Hay que ENVOLVER al objeto y añadirle funcionalidad nueva --> DECORATOR.


### CAMBIOS

- REDISEÑO INICIAL:
    - CodedOutput, NormalizeOutput, WhiteSpaceOutput: implementan Output y reciben un Output, envuelven al objeto, realizan acciones y luego llaman a las acciones propias del objeto que envolvemos.
    - Es un decorator: Envolvemos, decoramos al objeto con funcionalidad extra y luego dejamos que se realicen las acciones propias.
- MODIFICACIONES:
    - El contador: que no imprima desde la propia clase, que se imprima todo desde el mismo sitio