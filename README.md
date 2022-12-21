# ProyectoSemestral-Progra-II

> ([Informática UdeC](https://fi.udec.cl/pregrado/ingenieria-civil-informatica/) 2022-2)

### Grupo 21
- [Sebastián Benjamín Bustos Beni](https://github.com/sebasinmas)
- [Carlos Efraín Pinto Urtubia](https://github.com/CxrlosKenobi)

---

> Tema: Animación de la física de lanzamiento de misiles desde un avión

> *captura de la interfaz gráfica*

### Diagrama UML

### Diagrama de casos de uso

### Patrones de diseño de software


*breve sección que explica las decisiones que tomamos durante el proyecto*
*breve sección que indica los problemas que tuvimos durante el proyecto y autoevaluación de los mismos*

---

En el panel central habrá un escenario compuesto por avión, blanco y misil, en una animación.

### Misil
- El misil debe ir ajustando la ruta al blanco mediante las clases
  - Angular
  - RellenaConpuntos.

- El misil lanzado deberá impactar sobre un blanco que se mueve a velocidad constante, pero elegida randómicamente, sobre la tierra en una de las dos direcciones.

- El misil tendrá una distancia máxima de detección del blanco y dentro una zona que forma aproximada a un arco, si no detecta, sigue en la dirección que venía.

- El misil ajusta su dirección al blanco en la media que se mueve.

### Avión
- Deberá ser posible mediante controles GUI elegir la:
  - Dirección de vuelo
  - Altura
  - Velocidad del avión

### Blanco
- El blanco, por defecto se mueve a la misma altura randómicamente elegida. Se podría cambiar la dirección del blanco mediante flechas del teclado. 

- El control de disparo se debe realizar mediante el mouse o con teclado o con controles GUI.
