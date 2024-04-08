/**
 * Descripción de la clase: La clase "Jugador" representa a un jugador en un juego JRPG con atributos como nombre, nivel, salud.
 * puntos, puntos de ataque, puntos de defensa y dinero.
 *
 * @version 1.0
 * @author Erik
 */
package JRPG_MEDACGAME.src;

import java.util.Scanner;
import java.lang.Math;

/**
 * @author AlumnoT
 */
class Jugador {

    private String nombre;
    private int nivel;
    private int puntosSalud;
    private int puntosAtaque;
    private int puntosDefensa;
    private int dinero;

    /**
     * Constructor para la clase Jugador.
     * @param nombre El nombre del jugador.
     */
    
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.nivel = 1;
        this.puntosSalud = 20;
        this.puntosAtaque = 0;
        this.puntosDefensa = 0;
        this.dinero = 2;
    }

    /**
     * Obtiene el nivel del jugador.
     * 
     * @return String Este método es un método getter diseñado
     * específicamente para recuperar el valor del atributo `nivel`, que
     * representa el nivel de un jugador en el juego JRPG.
     */
    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene los puntos de salud del jugador.
     * 
     * @return int Este método es un método getter. diseñado específicamente
     * para recuperar el valor del atributo `nivel`, que representa el nivel de
     * un jugador en el juego JRPG.
     */
    public int getNivel() {
        return nivel;
    }

    public void subirNivel() {
        nivel++;
        puntosSalud += 100; // Cada vez que subes de nivel, obtienes más salud
        puntosAtaque += 100; // Cada vez que subes de nivel, obtienes más ataque
        puntosDefensa += 100; // Cada vez que subes de nivel, obtienes más defensa
    }

    /**
     * Establece los puntos de salud del jugador.
     * 
     * @return int Este método es un captador diseñado específicamente para
     * recuperar el valor de los `puntosSalud` atributo, que representa los
     * puntos de salud de un jugador en el JRPG juego. Cuando se llama a este
     * método en un objeto `Jugador`, devolverá el valor actual del atributo
     * `puntosSalud`, permitiendo otras partes del programa para acceder y
     * recuperar los puntos de salud del jugador.
     */
    public int getPuntosSalud() {
        return puntosSalud;
    }

    /**
     * Obtiene los puntos de ataque del jugador.
     * 
     * @param puntosSalud El método `setPuntosSalud(int puntosSalud)` en el
     * La clase `Jugador` es un método de establecimiento que le permite
     * actualizar el atributo de puntos de salud de un objeto de jugador.
     */
    public void setPuntosSalud(int puntosSalud) {
        this.puntosSalud = puntosSalud;
    }

    /**
     * Establece los puntos de ataque del jugador.
     * 
     * @return int Este método es un captador diseñado específicamente para
     * recuperar el valor de los `puntosAtaque` atributo, que representa los
     * puntos de ataque de un jugador en el JRPG juego. Cuando se llama a este
     * método en un objeto `Jugador`, devolverá el valor actual del atributo
     * `puntosAtaque`, permitiendo otros partes del programa para acceder y
     * recuperar los puntos de ataque del jugador.
     */
    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    /**
     * Obtiene los puntos de defensa del jugador.
     * 
     * @param puntosAtaque El método `setPuntosAtaque(int puntosAtaque)` en
     * la clase `Jugador` es un método setter que permite actualizar el atributo
     * de puntos de ataque de un objeto de jugador. Cuando se llama a este
     * método con un valor entero que representa los puntos de ataque como
     * parámetro, establece los puntos de ataque del jugador al valor
     * proporcionado. Este La funcionalidad le permite ajustar dinámicamente el
     * poder de ataque del jugador durante el juego, reflejando cambios en su
     * ofensiva capacidades.
     */
    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    /**
     * @return int Este método es un captador diseñado específicamente para
     * recuperar el valor de los `puntosDefensa` atributo, que representa los
     * puntos de defensa de un jugador en el JRPG juego.
     */
    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    /**
     * Establece los puntos de defensa del jugador.
     * 
     * @param puntosDefensa El método `setPuntosDefensa(int puntosDefensa)`
     * en la clase `Jugador` hay un método setter que permite actualizar el
     * atributo de puntos de defensa de un objeto de jugador. Cuando este método
     * es llamado con un valor entero que representa los puntos de defensa como
     * un parámetro, establece la defensa del jugador apunta al valor
     * proporcionado, cambiar efectivamente las capacidades defensivas del
     * jugador en el juego. Este método ayuda a ajustar dinámicamente las
     * estadísticas de defensa del jugador durante el juego.
     */
    public void setPuntosDefensa(int puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }

    /**
     * Obtiene la cantidad de dinero del jugador.
     * 
     * @return int El método `getDinero()` en la clase `Jugador` es un método
     * getter que devuelve el valor del // atributo `dinero`, que representa la
     * cantidad de dinero que tiene el jugador. Cuando se llama a este método en
     * un objeto `Jugador`, devolverá el valor actual del atributo `dinero`, que
     * permite que otras partes del programa accedan y recuperar la cantidad de
     * dinero del jugador.
     */
    public int getDinero() {
        return dinero;
    }

    /**
     * Establece la cantidad de dinero del jugador.
     * 
     * @param dinero El método `setDinero(int dinero)` en el `Jugador` la
     * clase es un método de establecimiento para actualizar el atributo
     * `dinero` de un objeto del jugador.
     */
    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    /**
     * Devuelve una representación en forma de cadena del jugador.
     * 
     * @return String El método `toString()` en la clase `Jugador` es
     * anulando el método predeterminado `toString()` proporcionado por el
     * `Objeto` clase en Java. Cuando se imprime un objeto de la clase `Jugador`
     * usando `System.out.println(jugador)`, este método se llama para devolver
     * una cadena representación del objeto.
     */
    @Override
    public String toString() {
        return "Jugador{"
                + "nombre='" + nombre + '\''
                + ", nivel=" + nivel
                + ", puntosSalud=" + puntosSalud
                + ", puntosAtaque=" + puntosAtaque
                + ", puntosDefensa=" + puntosDefensa
                + ", dinero=" + dinero
                + '}';
    }

    /**
     * Actualiza los puntos de ataque del jugador.
     * 
     * @param puntos Este método en la clase `Jugador` se llama
     * `actualizarPuntosAtaque(int puntos)` y sirve para actualizar el puntos de
     * ataque del jugador. Cuando este método se llama con un específico número
     * de puntos como parámetro, suma esos puntos al actual puntos de ataque del
     * jugador, efectivamente aumentando su ataque fuerza.
     */
    // Método para actualizar los puntos de ataque del jugador
    public void actualizarPuntosAtaque(int puntos) {
        this.puntosAtaque += puntos;
    }

    /**
     * Actualiza los puntos de vida del jugador.
     * 
     * @param puntos Este método en la clase `Jugador` se llama
     * `actualizarPuntosVida(int puntos)` y se utiliza para actualizar la salud
     * puntos del jugador.
     */
    // Método para actualizar los puntos de vida del jugador
    public void actualizarPuntosVida(int puntos) {
        this.puntosSalud += puntos;
    }

    // Método para calcular la fuerza inicial de forma aleatoria
    public void calcularFuerzaInicial() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            int fuerzaInicial = (int) (Math.random() * 1000) + 10;
            System.out.println("\nTu fuerza inicial es: " + fuerzaInicial);

            System.out.println("¿Estás satisfecho con tu fuerza descomunal? De lo contrario, dale otro intento. (1: Sí, 2: No)");
            opcion = scanner.nextInt();

            if (opcion == 1) {
                if (dinero >= 1) {
                    dinero -= 1;
                    puntosAtaque = fuerzaInicial;
                    System.out.println("¡Has cambiado tu fuerza por 1 oro! Ahora tu fuerza es: " + puntosAtaque);
                    break;
                } else {
                    System.out.println("No tienes suficiente oro para cambiar tu fuerza...");
                }
            } else {
                System.out.println("\n¡Muy bien, intentemoslo de nuevo! A ver que lo restablezca primero a " + puntosAtaque);
                System.out.println("¿Deseas volver a intentarlo? (1: Sí, 2: No)");
                opcion = scanner.nextInt();
            }
        } while (opcion == 1);
    }

    /**
     * Método principal que sirve como punto de entrada para el programa.
     * 
     * @param args Este método sirve como punto de entrada para el programa.
     */
    public static void main(String[] args) {
        Jugador jugador = new Jugador("Nombre");
        jugador.calcularFuerzaInicial();
    }
}
