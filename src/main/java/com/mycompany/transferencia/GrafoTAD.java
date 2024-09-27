package com.mycompany.transferencia;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Clase que representa un grafo utilizando una estructura de datos 
 * basada en un mapa que almacena nodos y sus conexiones.
 */
public class GrafoTAD {
    // Mapa que permite almacenar los nodos y sus listas de conexiones (aristas)
    private Map<String, LinkedList<String>> conexiones;

    // Constructor que permite crear un grafo vacío
    public GrafoTAD() {
        this.conexiones = new HashMap<>();
    }

    /**
     * Método para verificar si el grafo está vacío
     * @return true si el grafo no tiene nodos, false en caso que sea lo contrario.
     */
    public boolean estaVacio() {
        return this.conexiones.isEmpty();
    }

    /**
     * Método para insertar un nodo en el grafo
     * @param nodo Nombre del nodo a insertar
     */
    public void insertarNodo(String nodo) {
        // Solo se inserta si el nodo no exite ya
        if (!this.conexiones.containsKey(nodo)) {
            this.conexiones.put(nodo, new LinkedList<>());
            System.out.println("Nodo " + nodo + " insertado.");
        } else {
            System.out.println("El nodo " + nodo + " ya existe.");
        }
    }

    /**
     * Método para insertar una arista entre dos nodos (si no existen, se crean)
     * @param nodoOrigen Nombre del nodo de origen.
     * @param nodoDestino Nombre del nodo de destino.
     */
    public void insertarArista(String nodoOrigen, String nodoDestino) {
        // Se verifica que los dos nodos sean existentes
        if (!this.conexiones.containsKey(nodoOrigen)) {
            insertarNodo(nodoOrigen);
        }
        if (!this.conexiones.containsKey(nodoDestino)) {
            insertarNodo(nodoDestino);
        }
        // Agregar la arista
        this.conexiones.get(nodoOrigen).add(nodoDestino);
        System.out.println("Arista agregada desde " + nodoOrigen + " hasta " + nodoDestino + ".");
    }

    /**
     * Método para buscar un nodo en el grafo
     * @param nodo Nombre del nodo a buscar.
     * @return True si el nodo es existente, false si este no existe.
     */
    public boolean buscarNodo(String nodo) {
        return this.conexiones.containsKey(nodo);
    }

    // Se imprime todos los nodos del grafo y sus respectivas conexiones.
    public void imprimirGrafo() {
        if (estaVacio()) {
            System.out.println("El grafo está vacío.");
        } else {
            for (Map.Entry<String, LinkedList<String>> entry : conexiones.entrySet()) {
                System.out.println("Nodo " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    /**
     * Metodo principal para ejecutar la clase GrafoTAD
     * @param args Son aquellos argumentos de la línea de comandos
     */ 
    public static void main(String[] args) {
        GrafoTAD grafo = new GrafoTAD();

        // Insertar nodos y aristas
        grafo.insertarNodo("A");
        grafo.insertarNodo("B");
        grafo.insertarArista("A", "B");
        grafo.insertarArista("A", "C");
        grafo.insertarArista("C", "D");

        // Imprimir el grafo
        grafo.imprimirGrafo();

        // Buscar un nodo
        System.out.println("Nodo A está en el grafo: " + grafo.buscarNodo("A"));
        System.out.println("Nodo Z está en el grafo: " + grafo.buscarNodo("Z"));

        // Verificar si el grafo está vacío
        System.out.println("¿Está vacío el grafo? " + grafo.estaVacio());
    }
}

