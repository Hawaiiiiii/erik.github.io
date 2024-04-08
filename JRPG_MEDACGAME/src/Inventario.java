/**
 * Descripción de la clase: La clase `Inventario` es una clase Java que representa un sistema de inventario para un juego, permitiendo
 * jugadores para agregar objetos que brindan bonificaciones de ataque o salud, ver el inventario, usar objetos y
 * gestionar las estadísticas del jugador.
 *
 * @version 1.1
 * @author Erik /
 *
 * /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt
 * to change this license Click
 * nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this
 * template
 */
package JRPG_MEDACGAME.src;

import java.util.ArrayList;

/**
 * Clase que representa el inventario del jugador.
 */
public class Inventario {

    // Declaración de ArrayLists
    private ArrayList<String> objetos;
    private ArrayList<Integer> puntosBonusAtaque;
    private ArrayList<Integer> puntosBonusVida;

    // Jugador asociado al inventario
    private Jugador jugador;

    // Constructor por defecto
    /**
     *
     * @param jugador Descripción del parámetro jugador
     */
    public Inventario(Jugador jugador) {
        objetos = new ArrayList<String>();
        puntosBonusAtaque = new ArrayList<Integer>();
        puntosBonusVida = new ArrayList<Integer>();
        this.jugador = jugador;
    }

    /**
     *
     * @param nombreObjeto Descripción del parámetro nombreObjeto
     * @param puntosAtaque Descripción del parámetro puntosAtaque
     *
     * // Método para agregar un objeto que da puntos de ataque
     */
    public void agregarObjetoAtaque(String nombreObjeto, int puntosAtaque) {
        objetos.add(nombreObjeto);
        puntosBonusAtaque.add(puntosAtaque);
        puntosBonusVida.add(0); // Añadir 0 para mantener consistencia
    }

    /**
     *
     *
     * @param nombreObjeto Descripción del parámetro nombreObjeto
     * @param puntosVida Descripción del parámetro puntosVida // Método para agregar un objeto que da puntos de vida
     */
    public void agregarObjetoVida(String nombreObjeto, int puntosVida) {
        objetos.add(nombreObjeto);
        puntosBonusAtaque.add(0); // Añadir 0 para mantener consistencia
        puntosBonusVida.add(puntosVida);
    }

    /**
     * // Método para mostrar el inventario
     */
    public void mostrarInventario() {
        System.out.println("\nMochila mágica mística:");
        for (int i = 0; i < objetos.size(); i++) {
            String objeto = objetos.get(i);
            int ataque = puntosBonusAtaque.get(i);
            int vida = puntosBonusVida.get(i);
            // Mostrar el índice de posición junto al nombre del objeto
            System.out.println((i + 1) + ". " + objeto + " - Ataque: " + ataque + ", Vida: " + vida);
        }
        // Opción para salir del inventario
        System.out.println("0. Salir del inventario");
    }

    /**
     *
     * @param indiceObjeto Descripción del parámetro indiceObjeto
     * @param jugador Descripción del parámetro jugador // Método para usar un objeto del inventario
     */
    public void usarObjeto(int indiceObjeto, Jugador jugador) {
        // Verificar si se selecciona una opción válida
        if (indiceObjeto < 1 || indiceObjeto > objetos.size()) {
            //System.out.println("Opción inválida. Por favor, seleccione un objeto válido.");
            return;
        }
        // Comprobar si el objeto da ataque o vida
        int puntosAtaque = puntosBonusAtaque.get(indiceObjeto - 1);
        int puntosVida = puntosBonusVida.get(indiceObjeto - 1);

        // Actualizar los puntos del jugador
        if (puntosAtaque > 10) {
            jugador.actualizarPuntosAtaque(puntosAtaque);
        }
        if (puntosVida > 10) {
            jugador.actualizarPuntosVida(puntosVida);
        }

        // Eliminar el objeto del inventario
        objetos.remove(indiceObjeto - 1);
        puntosBonusAtaque.remove(indiceObjeto - 1);
        puntosBonusVida.remove(indiceObjeto - 1);
    }

    /**
     *
     * @return // Método para obtener la cantidad de objetos en el inventario
     */
    public int obtenerCantidadObjetos() {
        return objetos.size();
    }

    /**
     *
     * @return // Método para obtener el jugador asociado
     */
    public Jugador getJugador() {
        return jugador;
    }
}
