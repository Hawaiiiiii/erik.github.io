/**
 * Descripción de la clase: La clase principal de este programa Java implementa un juego de rol basado en texto donde el jugador puede luchar.
 * enemigos, compra artículos, administra inventario y sube de nivel.
 *
 * @version 1.1
 * @author Erik
 */
package JRPG_MEDACGAME.src;

import java.util.Scanner;
import java.lang.Math;
import java.util.HashMap;

/**
 * El código anterior es una plantilla de clase Java con un comentario indicando
 * al autor como "AlumnoT". no contiene ninguna información específica
 * funcionalidad o implementación de código.
 *
 * @author AlumnoT
 */
public class Main {

    /**
     *
     * @param args La clase Main en Java con un método principal que toma una
     * matriz de cadenas como argumentos.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jugador jugador;
        Inventario inventario;

        System.out.println("MEDAC Adventure: ¡La búsqueda del Dragón!");
        System.out.println("_______________________________________");
        System.out.println("\nDesarrollado por: [David Erik Gª Arenas y Alberto Castillo Guerrero]");
        System.out.println("Fecha de lanzamiento: [17/03/2024]");
        System.out.println("Versión: 1.1\n");

        System.out.println("_______________________________________");
        System.out.println("¡Saludos, valiente aventurero/a! ");
        System.out.println("Antes de embarcarte en esta emocionante aventura, necesito saber tu nombre.");

        System.out.print("\n¿Cómo te llamas? ");
        String nombreJugador = scanner.nextLine();

        System.out.print("\n¡Un gusto, " + nombreJugador + "!");
        System.out.print("\n¿Viendo que es tu primera vez, te gustaría recibir un tutorial sobre cómo jugar? (1: Sí, 2: No): ");
        int Tutorial = scanner.nextInt();

        if (Tutorial == 1) {
            Tutorial tutorial = new Tutorial();
            tutorial.showTutorial();
        }

        jugador = new Jugador(nombreJugador);
        jugador.calcularFuerzaInicial();

        inventario = new Inventario(jugador);

        HashMap<String, Enemigo> enemigos = añadirEnemigos();
        String[] nombresEnemigos = enemigos.keySet().toArray(new String[0]);

        int nivel = 5; // Nivel inicial de los enemigos

        while (true) {
            mostrarMenuPrincipal();
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Luchar contra un enemigo
                    int indiceEnemigo = (int) (Math.random() * nombresEnemigos.length);
                    String nombreEnemigo = nombresEnemigos[indiceEnemigo];
                    Enemigo enemy = enemigos.get(nombreEnemigo);
                    ajustarAtaqueEnemigo(enemy, nivel);

                    lucharContraEnemigo(jugador, enemy);

                    // Aumentar el nivel y la fuerza del enemigo después de cada combate
                    enemy.aumentarFuerza();
                    enemy.aumentarNivel();
                    break;
                case 2:
                    comprar(inventario, jugador);
                    break;
                case 3:
                    inventario.mostrarInventario();
                    break;
                case 4:
                    inventario.mostrarInventario();
                    System.out.print("Seleccione el número del objeto que desea usar: ");
                    int indiceObjeto = scanner.nextInt();
                    inventario.usarObjeto(indiceObjeto, jugador);
                    break;
                case 5:
                    consultarEstadisticas(jugador);
                    break;
                case 6:
                    System.out.println("\nSaliendo de MEDAC Adventure... ¡Muchas gracias por jugar, " + nombreJugador + "!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú.");
            }
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\nHm... Parece que se aproximan enemigos. ¿Qué debería hacer?");
        System.out.println("1. Luchar contra el enemigo");
        System.out.println("2. Comprar ítems");
        System.out.println("3. Mostrar inventario");
        System.out.println("4. Usar objeto");
        System.out.println("5. Mostrar estadística del jugador");
        System.out.println("6. Salir del juego");
        System.out.print("Elige una opción: ");
    }

    /**
     * @param jugador Define un método `lucharContraEnemigo` que simula una
     * batalla entre un jugador (`Jugador`) y un enemigo (`Enemigo`).
     * @param enemy Parámetro de Enemigo en el método `lucharContraEnemigo`
     *
     */
    private static void lucharContraEnemigo(Jugador jugador, Enemigo enemy) {
        System.out.println("\n¡Te enfrentas a " + enemy.getNombre() + " (Nivel " + enemy.getNivel() + ")!");
        System.out.println("Fuerza del enemigo: " + enemy.getPuntosAtaque());
        System.out.println("Tu fuerza: " + jugador.getPuntosAtaque());

        // Comparar fuerzas y determinar el resultado de la batalla
        int resultadoBatalla = calcularResultadoBatalla(jugador, enemy);
        if (resultadoBatalla == 1) {
            int oroGanado = (int) (Math.random() * 5) + 1;
            jugador.setDinero(jugador.getDinero() + oroGanado);
            System.out.println("¡Has ganado la batalla y obtuviste " + oroGanado + " de oro!");
            jugador.subirNivel();
            System.out.println("¡Felicidades! Has subido al nivel " + jugador.getNivel() + " y tus estadísticas han mejorado.");
        } else if (resultadoBatalla == -1) {
            int perdidaSalud = enemy.getPuntosAtaque() - (jugador.getPuntosDefensa() / 2);
            jugador.setPuntosSalud(jugador.getPuntosSalud() - perdidaSalud);
            System.out.println("¡Has perdido la batalla! Pierdes " + perdidaSalud + " puntos de salud.");

            if (jugador.getPuntosSalud() <= 0) {
                System.out.println("¡Tu vida ha llegado a 0! Has perdido el juego.");
                System.exit(0);
            }
        } else {
            System.out.println("La batalla ha terminado en empate. Nadie gana ni pierde.");
        }
    }

    /**
     * @param jugador Clase Jugador
     * @param enemy Clase Enemigo
     * @return int Define un método estático privado llamado
     * `calcularResultadoBatalla` que calcula el resultado de una batalla entre
     * un jugador (`Jugador`) y un enemigo (`Enemigo`).
     */
    private static int calcularResultadoBatalla(Jugador jugador, Enemigo enemy) {
        int resultado = 0;

        // Calcula el daño causado por el jugador y el enemigo
        int danoJugador = jugador.getPuntosAtaque() - enemy.getPuntosDefensa();
        int danoEnemigo = enemy.getPuntosAtaque() - jugador.getPuntosDefensa();

        if (danoJugador > danoEnemigo) {
            resultado = 1; // Jugador gana
        } else if (danoJugador < danoEnemigo) {
            resultado = -1; // Jugador pierde
        }

        return resultado;
    }

    /**
     * @param jugador Define un método estático privado. llamado
     * `consultarEstadisticas` que toma un objeto `Jugador` como parámetro.
     * Dentro del método, imprime un mensaje indicando que mostrará las
     * estadísticas del jugador y luego imprimirá las detalles del objeto
     * `Jugador` usando su método `toString()`.
     */
    private static void consultarEstadisticas(Jugador jugador) {
        System.out.println("\nEstadísticas del jugador:");
        System.out.println(jugador);
    }

    /**
     * La función añadirEnemigos() crea un HashMap de objetos Enemigo con
     * nombres predefinidos.
     *
     * @return El método `añadirEnemigos` está devolviendo un
     * HashMap<String, Enemigo> que contiene una colección de objetos Enemigo
     * con nombres como claves.
     */
    /**
     * Función para añadir enemigos al HashMap.
     *
     * @return Define un método estático llamado `añadirEnemigos` que crea un
     * HashMap de tipo `<String, Enemigo>` y lo llena con un conjunto de objetos
     * enemigos. Inicializa una serie de nombres de enemigos, itera sobre los
     * nombres, crea un nuevo objeto `Enemigo` para cada nombre, y lo agrega al
     * HashMap con el nombre como clave. Finalmente, devuelve el HashMap poblado
     * de enemigos.
     */
    public static HashMap<String, Enemigo> añadirEnemigos() {
        HashMap<String, Enemigo> enemigos = new HashMap<>();
        String[] nombresEnemigos = {"Javi", "Luis", "Jose", "Paquiñou", "Tito Albertillou", "Chumbeta", "CheitDOWN", "Cuñadito", "Pe CAUSA", "El Luismi(ma)", "Artista", "Ihihihillo"};

        for (String nombre : nombresEnemigos) {
            enemigos.put(nombre, new Enemigo(nombre));
        }

        return enemigos;
    }

    /**
     *
     * @param enemy Función de la clase Enemigo.
     * @param nivel Función llamada `ajustarAtaqueEnemigo` que ajusta los puntos
     * de ataque de un enemigo basado en un nivel determinado. Se necesita un
     * objeto `Enemigo` y un número entero. `nivel` como parámetros. Dentro de
     * la función, hay un nuevo valor de ataque calculado usando una fórmula que
     * involucra el nivel del enemigo, un azar número y algunas constantes.
     * Finalmente, los puntos de ataque del enemigo se establecen en el valor
     * recién calculado.
     */
    public static void ajustarAtaqueEnemigo(Enemigo enemy, int nivel) {
        int nuevoAtaque = (int) (enemy.getNivel() * Math.random() * 50 + 5);
        enemy.setPuntosAtaque(nuevoAtaque);
    }

    // Función para comprar un objeto
    /**
     *
     * @param inventario Función de la clase Inventario.
     * @param jugador Función para comprar un artículo en un juego. Muestra una
     * lista de elementos disponibles con sus descripciones. y precios, solicita
     * al jugador que seleccione un artículo para comprar y luego llama a
     * métodos específicos para manejar la compra del artículo elegido en
     * función de la entrada del jugador. La función interactúa con el
     * reproductor y se actualiza. el inventario del jugador correctamente.
     */
    public static void comprar(Inventario inventario, Jugador jugador) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nBazar del chino Chan - ítems disponibles:");
        System.out.println("1. Espada (+10 puntos de ataque) - 5 de oro");
        System.out.println("2. Armadura (+5 puntos de salud y +2 puntos de defensa) - 3 de oro");
        System.out.println("3. Poción de curación (+7 puntos de salud) - 4 de oro");
        System.out.println("4. Calculadora (+3 puntos de ataque) - 2 de oro");
        System.out.println("5. Martillo (+5 puntos de ataque) - 1 de oro");
        System.out.println("6. Vendas (+5 puntos de vida) - 2 de oro");
        System.out.print("Seleccione el número del objeto que desea comprar: ");
        int opcion = scanner.nextInt();

        int precioObjeto = 0;
        String nombreObjeto = "";
        int puntos = 0;

        switch (opcion) {
            case 1:
                comprarEspada(jugador, inventario);
                break;
            case 2:
                comprarArmadura(jugador, inventario);
                break;
            case 3:
                comprarPocion(jugador, inventario);
                break;
            case 4:
                comprarCalculadora(jugador, inventario);
                break;
            case 5:
                comprarMartillo(jugador, inventario);
                break;
            case 6:
                comprarVendas(jugador, inventario);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    /**
     * Método que permite a un jugador comprar una espada si tiene suficiente
     * dinero.
     *
     * @param jugador Método de la clase Jugador.
     * @param inventario Define un método llamado `comprarEspada` que permite a
     * un jugador comprar una espada si tiene suficiente dinero. El método toma
     * un objeto `Jugador` (que representa el jugador) y un objeto `Inventario`
     * (que representa el inventario) como parámetros.
     */
    private static void comprarEspada(Jugador jugador, Inventario inventario) {
        if (jugador.getDinero() >= 2) {
            jugador.setDinero(jugador.getDinero() - 2);
            inventario.agregarObjetoAtaque("Espada", 10);
            System.out.println("¡Has comprado una espada! Tu fuerza ahora es: " + jugador.getPuntosAtaque());
        } else {
            System.out.println("No tienes suficiente oro para comprar una espada. Vaya pena...");
        }
    }

    /**
     * @param jugador Método de la clase Jugador.
     * @param inventario Define un método llamado `comprarArmadura` que permite
     * a un jugador comprar armadura en un juego. El el método toma un objeto
     * `Jugador` y un `Inventario` objeto como parámetros.
     */
    private static void comprarArmadura(Jugador jugador, Inventario inventario) {
        if (jugador.getDinero() >= 3) {
            jugador.setDinero(jugador.getDinero() - 3);
            jugador.setPuntosSalud(jugador.getPuntosSalud() + 5);
            jugador.setPuntosDefensa(jugador.getPuntosDefensa() + 2);
            inventario.agregarObjetoVida("Armadura", 3);
            System.out.println("¡Has comprado una armadura! Tu salud ahora es: " + jugador.getPuntosSalud()
                    + " y tu defensa es: " + jugador.getPuntosDefensa());
        } else {
            System.out.println("No tienes suficiente oro para comprar una armadura... No sabía que estaba tan tieso.");
        }
    }

    /**
     * @param jugador El jugador que realiza la compra.
     * @param inventario Define un método llamado `comprarPocion` que permite a
     * un jugador (`Jugador`) comprar una salud poción de un inventario
     * (`Inventario`). Si el jugador tiene suficiente dinero (4 o más), el
     * dinero del jugador se reduce en 4, sus puntos de salud aumentan en 7, se
     * agrega un objeto de poción de salud al inventario con una cantidad de 3,
     * y se imprime un mensaje indicando el éxito compra. Si el jugador no tiene
     * suficiente dinero, aparecerá un mensaje. impreso indicando que no pueden
     * permitirse comprar una poción de salud.
     */
    private static void comprarPocion(Jugador jugador, Inventario inventario) {
        if (jugador.getDinero() >= 4) {
            jugador.setDinero(jugador.getDinero() - 4);
            jugador.setPuntosSalud(jugador.getPuntosSalud() + 7);
            inventario.agregarObjetoVida("Poción", 3);
            System.out.println("¡Has comprado una poción de curación! Tu salud ahora es: " + jugador.getPuntosSalud());
        } else {
            System.out.println("No tienes suficiente oro para comprar una poción de curación... Ni para curarme tengo...");
        }
    }

    /**
     * @param jugador El jugador que realiza la compra.
     * @param inventario Define un método llamado comprarCalculadora` que
     * permite a un jugador comprar una calculadora en una partida. El método
     * toma un objeto `Jugador` (que representa al jugador) y un objeto
     * `Inventario` (que representa el inventario del jugador) como parámetros.
     */
    private static void comprarCalculadora(Jugador jugador, Inventario inventario) {
        if (jugador.getDinero() >= 3) {
            jugador.setDinero(jugador.getDinero() - 3);
            jugador.setPuntosSalud(jugador.getPuntosSalud() + 0);
            inventario.agregarObjetoAtaque("Calculadora", 3);
            System.out.println("¡Has comprado una calculadora! Tu fuerza ahora es: " + jugador.getPuntosSalud());
        } else {
            System.out.println("No tienes suficiente oro para comprar una calculadora... Normal que ni pueda saber cuanto oro me queda...");
        }
    }

    /**
     * @param jugador El jugador que realiza la compra.
     * @param inventario El código Java anterior define un método llamado
     * `comprarMartillo` que toma un objeto `Jugador` y // un `Inventario`
     * objeto como parámetros. El método comprueba si el jugador tiene
     * suficiente dinero para comprar un // martillo (martillo) por 3 unidades
     * de moneda. Si el jugador tiene suficiente dinero, su dinero disminuye en
     * 3, sus puntos de salud son aumentado en 0, y se agrega un objeto martillo
     * con un valor de ataque de 5 al inventario. Luego se imprime un mensaje
     * indicando que el jugador ha comprado un martillo y su nuevo valor de
     * resistencia. Si el jugador lo hace, se le sumarán a los valores de
     * ataque.
     */
    private static void comprarMartillo(Jugador jugador, Inventario inventario) {
        if (jugador.getDinero() >= 3) {
            jugador.setDinero(jugador.getDinero() - 3);
            jugador.setPuntosSalud(jugador.getPuntosSalud() + 0);
            inventario.agregarObjetoAtaque("Martillo", 5);
            System.out.println("¡Has comprado un martillo! Tu fuerza ahora es: " + jugador.getPuntosSalud());
        } else {
            System.out.println("No tienes suficiente oro para comprar un martillo... Ya no podré construirme una casita...");
        }
    }

    /**
     * @param inventario el inventario del jugador
     * @param jugador Define un método llamado `comprarVendas` que toma como
     * parámetros un objeto `Jugador` y un objeto `Inventario`. El método
     * comprueba si el jugador tiene suficiente dinero para comprar vendas
     * (vendas) por 2 monedas de oro. Si el jugador tiene suficiente dinero, su
     * dinero se reduce. en 2, sus puntos de salud aumentan en 5 y las vendas se
     * incrementan agregado al inventario con una cantidad de 5. Luego se
     * imprime un mensaje indicando que el jugador ha comprado vendajes y sus
     * actuales Puntos de salud. Si el jugador no tiene, no podrá comprarlos.
     */
    private static void comprarVendas(Jugador jugador, Inventario inventario) {
        if (jugador.getDinero() >= 2) {
            jugador.setDinero(jugador.getDinero() - 2);
            jugador.setPuntosSalud(jugador.getPuntosSalud() + 5);
            inventario.agregarObjetoVida("Vendas", 5);
            System.out.println("¡Has comprado unas vendas! Tu salud ahora es: " + jugador.getPuntosSalud());
        } else {
            System.out.println("No tienes suficiente oro para comprar unas vendas... Pues vaya pena...");
        }
    }
}
