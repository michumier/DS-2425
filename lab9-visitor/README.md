# Patrón Visitor

Para el lab 9 se hará una aplicación usando el patrón visitor.

Estamos creando un intérprete para programas
escritos en un lenguaje de programación.

Queremos poder modelar (representar en memoria,
como objetos) programas como este:

read a;

print a + b;

## Pasos a seguir

1. Crear la interfaz Visitor con un método para cada nodo.
    - Para tener seguridad de tipos
2. Añadir un método accept a la interfaz raíz. Un método para cada clase.
    - Para decidir a qué método llamar
3. Implementar el método accept en cada clase de nodo. 
    - El método accept.


