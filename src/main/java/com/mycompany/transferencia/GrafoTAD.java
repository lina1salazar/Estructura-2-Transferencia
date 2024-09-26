/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transferencia;

/**
 *
 * @author Andres
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GrafoTAD {
    // Mapa para almacenar los nodos y sus listas de conexiones (aristas)
    private Map<String, LinkedList<String>> conexiones;

    // Constructor para crear un grafo vacío
    public GrafoTAD() {
        this.conexiones = new HashMap<>();
    }

    // Método para verificar si el grafo está vacío
    public boolean estaVacio() {
        return this.conexiones.isEmpty();
    }

    // Método para insertar un nodo en el grafo
    public void insertarNodo(String nodo) {
        if (!this.conexiones.containsKey(nodo)) {
            this.conexiones.put(nodo, new LinkedList<>());
            System.out.println("Nodo " + nodo + " insertado.");
        } else {
            System.out.println("El nodo " + nodo + " ya existe.");
        }
    }

    // Método para insertar una arista entre dos nodos (si no existen, se crean)
    public void insertarArista(String nodoOrigen, String nodoDestino) {
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

    // Método para buscar un nodo en el grafo
    public boolean buscarNodo(String nodo) {
        return this.conexiones.containsKey(nodo);
    }

    // Método para imprimir el grafo
    public void imprimirGrafo() {
        if (estaVacio()) {
            System.out.println("El grafo está vacío.");
        } else {
            for (Map.Entry<String, LinkedList<String>> entry : conexiones.entrySet()) {
                System.out.println("Nodo " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }

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

