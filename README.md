# JRPG MEDAC-GAME®
# Videojuego JRPG basado en Java que implementa un juego de rol basado en texto. Aquí hay un resumen de las funcionalidades principales del juego:

1. El juego comienza con un mensaje de bienvenida y una solicitud para que el jugador ingrese su nombre.
2. Se ofrece un tutorial opcional para explicar cómo jugar.
3. Se crea un jugador con el nombre proporcionado por el usuario.
4. Se inicializa un inventario para el jugador.
5. Se generan una serie de enemigos con nombres aleatorios.
6. El juego presenta un menú principal con varias opciones:
   - Luchar contra un enemigo aleatorio.
   - Comprar ítems del bazar.
   - Mostrar el inventario del jugador.
   - Usar un objeto del inventario.
   - Mostrar estadísticas del jugador.
   - Salir del juego.
     
7. La lucha contra un enemigo implica calcular el resultado de la batalla basado en las estadísticas del jugador y el enemigo.
8. Se actualizan las estadísticas del jugador y del enemigo después de cada batalla.
9. El jugador puede comprar diferentes objetos del bazar para mejorar sus estadísticas.
10. El juego continúa en un bucle hasta que el jugador decide salir.


________________________________________________________________________________________________________________________________________________________________________________________________________
# Componentes del programa

- **Clase Main**: La clase principal del programa. Contiene el método `main`, que es el punto de entrada del programa. Desde aquí, se gestionan todas las interacciones con el usuario y se controla el flujo del juego.
  
- **Clases Jugador y Enemigo**: Representan al jugador y a los enemigos respectivamente. Almacenan información como el nombre, nivel, salud, puntos de ataque y defensa.

- **Clase Inventario**: Permite al jugador gestionar su inventario, incluyendo la compra y uso de objetos.

- **Métodos de Batalla**: `lucharContraEnemigo` y `calcularResultadoBatalla` son métodos encargados de simular las batallas entre el jugador y los enemigos, calculando el resultado y ajustando la salud y otros atributos según el resultado.

-  **Funciones de Compra**: Permiten al jugador comprar diferentes objetos con su dinero virtual, como espadas, armaduras, pociones de curación, entre otros.

- **Funciones de Utilidad**: Incluyen métodos para mostrar el menú principal, consultar estadísticas del jugador, ajustar el ataque de los enemigos, entre otros.
# JRP-MEDAC-GAME
