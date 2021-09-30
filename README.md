# Pasapalabra
**[EN]** Final project for the subject "Software Engineering". It is a words game. It uses Object Oriented Programming (OOP), programming patterns and a windowed GUI. Developed in Java Language.

## Introducción

### Descripción del proyecto
Se trata de un juego programado en lenguaje Java. Está basado en la última prueba del programa de televisión “PasaPalabra”. El jugador tendrá un tiempo predefinido en segundos y tendrá que responder las preguntas que se le formulen. En total hay unas 27 preguntas, una por cada letra de nuestro alfabeto. El usuario tiene la opción de responder o pasar a la siguiente pregunta. Una vez se haya completado la primera vuelta, el usuario tendrá que responder a las preguntas que no haya contestado.

Las respuestas pueden ser acertadas o falladas. Por cada acierto se suman puntos, pero los fallos penalizan y descuentan puntos. La puntuación no podrá ser nunca negativa, en el caso de que esto ocurra la puntuación final será cero.

### Motivaciones
Es un proyecto que permite agrupar un conjunto de aspectos ya vistos en otras asignaturas de la carrera. Se aplican los conocimientos de diseño de diagramas de clases y de secuencias vistos en PMOO y en IS. También permite la reflexión sobre qué tipo de algoritmo pudiera ser más eficiente y apto para las listas, lo cual aprendimos en la asignatura EDA. Además, uno de los requisitos es también el uso de una interfaz gráfica, con lo que también tenemos que aplicar conocimientos adquiridos en IS.

En resumen, es un proyecto que requiere de conocer un poco de todo lo estudiado durante nuestra formación, con lo cual es apto para nuestro aprendizaje.

### Aspectos Técnicos
Para el correcto desarrollo de este juego lo primero que hemos tenido que hacer son los diagramas de clases y de secuencia. Desde el primero que hicimos hasta el último que hemos utilizado para elaborar nuestro juego hay bastantes diferencias. Hemos tenido que hacer unos cuantos cambios y modificaciones hasta dar con el diseño correcto. Al final de este documento se incluirán en un anexo los diagramas que hemos utilizado y seguido.

A la hora de hacer las listas hemos intentado coger lo que más se adecúe a este juego. Para el diccionario queremos velocidad, es por ello que como debe albergar un conjunto de palabras y definiciones significativo, la mejor forma de hacerlo es a través de un HashMap.

En el rosco, observamos que es una lista que cuando llega al final, vuelve al principio, es circular. Por ello hemos decidido que el modelo que mejor se adapta es una lista ligada doble. Además tiene la ventaja que sabemos la casilla en la que estamos, la siguiente y la anterior. Cuando una respuesta es contestada podemos anotar en ese mismo momento si es correcta o no. Al pasar a la siguiente letra podemos saber también si ha sido contestada o no, y en caso de estar contestada se puede eliminar de esa lista para que no se vuelva a repetir. Es un algoritmo muy versátil.

En cuanto a la interfaz, lo más primordial es que permita una interacción básica con el usuario y que sea fácil de entender. Como aspectos opcionales está la estética y los adornos que le queramos añadir. Cabe resaltar que para crear el rosco de forma circular, hemos tenido que recurrir a una fórmula matemática que explicaremos más adelante, cuando detallemos todos los métodos del programa en profundidad.

## Autores:

- [mbarcina001](https://github.com/mbarcina001)
- [jagumiel](https://github.com/jagumiel)
