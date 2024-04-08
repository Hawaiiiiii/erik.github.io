/**
 * Descripción de la clase: La clase "Enemigo" representa enemigos en un juego JRPG con atributos como nombre, nivel, ataque.
 * puntos, puntos de defensa y métodos para aumentar el nivel y la fuerza según la experiencia de combate.
 *
 * @version 1.1
 * @author Erik
 *
 * /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
 * template
 */
package JRPG_MEDACGAME.src;

import java.util.Random;

public class Enemigo {

    private final String nombre;
    private int nivel;
    private int puntosAtaque;
    private int puntosDefensa;
    private int contadorCombates; // Contador de combates para aumentar nivel y fuerza exponencialmente

    /**
     *
     * @param nombre La clase "Enemigo" representa enemigos en un juego JRPG con atributos como nombre, nivel, ataque.
     * puntos, puntos de defensa y métodos para aumentar el nivel y la fuerza según la experiencia de combate.
     * 
     */
    public Enemigo(String nombre) {
        this.nombre = nombre;
        this.nivel = 1; // Nivel inicial
        this.puntosAtaque = nivel * 10; // Los enemigos más poderosos tienen más ataque
        this.puntosDefensa = nivel; // Los enemigos más poderosos tienen más defensa
        this.contadorCombates = 5; // Inicializar el contador de combates
    }

    // Getters y setters
    /**
     *
     * @return Return del Nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return Return de los Niveles
     */
    public int getNivel() {
        return nivel + (5 * contadorCombates);
    }

    /**
     *
     * @param nivel
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * @return Return de los Puntos de Ataque
     */
    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    /**
     * @param puntosAtaque // El método `setPuntosAtaque(int puntosAtaque)` en
     * la clase `Enemigo` es un método de establecimiento que permite // otras
     * partes del programa para establecer el valor del atributo `puntosAtaque`
     * para una instancia de la // clase `Enemigo`. Cuando se llama a este
     * método con un nuevo valor para `puntosAtaque`, actualiza el // atributo
     * `puntosAtaque` del Objeto `Enemigo` al valor proporcionado. Este método
     * se utiliza para // modificar los puntos de ataque del enemigo durante el
     * juego.
     */
    public void setPuntosAtaque(int puntosAtaque) {
        this.puntosAtaque = puntosAtaque;
    }

    /**
     * @return // El método `getPuntosDefensa()` en la clase `Enemigo` es un
     * método getter que devuelve el valor del atributo `puntosDefensa`. Este
     * método permite que otras partes del programa accedan al actual valor
     * de la variable `puntosDefensa` para una instancia del `Enemigo` clase. No
     * modifica el estado del objeto; simplemente proporciona acceso de
     * lectura al atributo `puntosDefensa`, permitiendo otras partes de el
     * programa para recuperar los puntos de defensa del enemigo.
     */
    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    /**
     * @param puntosDefensa El método `setPuntosDefensa(int puntosDefensa)`
     * en la clase `Enemigo` hay un método de establecimiento que // permite
     * otras partes de el programa para establecer el valor del atributo
     * `puntosDefensa` para un instancia de la clase `Enemigo`. Cuando se
     * llama a este método con un nuevo valor para `puntosDefensa`, actualiza
     * el atributo `puntosDefensa` de el objeto `Enemigo` al valor
     * proporcionado. Este método se utiliza para modificar los puntos de
     * defensa del enemigo durante el juego.
     */
    public void setPuntosDefensa(int puntosDefensa) {
        this.puntosDefensa = puntosDefensa;
    }

    /**
     * @return El método `getContadorCombates()` en la clase `Enemigo` es un
     * método getter que devuelve el valor // del `contadorCombates` atributo.
     * Permite que otras partes del programa accedan al actual valor de la
     * variable `contadorCombates` para una instancia del `Enemigo` clase. Este
     * método no modifica el estado del objeto, simplemente proporciona
     * acceso de lectura al atributo `contadorCombates`.
     */
    public int getContadorCombates() {
        return contadorCombates;
    }

    /**
     * El método `aumentarNivel()` en la clase `Enemigo` es responsable para
     * aumentar el nivel del enemigo y la fuerza en función del combate
     * experiencia. Aquí hay un desglose de lo que hace:
     */
    public void aumentarNivel() {
        this.contadorCombates++; // Incrementar el contador de combates
        // Incrementar el nivel de 5 en 5
        this.nivel = 2 + (contadorCombates / 5);
    }

    /**
     * El método `aumentarFuerza()` en la clase `Enemigo` es el responsable
     * para aumentar la fuerza de ataque del enemigo exponencialmente en
     * función de su nivel y experiencia de combate.
     */
    public void aumentarFuerza() {
        // Aumentar la fuerza exponencialmente
        this.puntosAtaque = (int) (nivel * Math.pow(5, contadorCombates));
    }
}
