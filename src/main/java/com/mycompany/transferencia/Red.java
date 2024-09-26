/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.transferencia;

/**
 *
 * @author Andres
 */

import java.util.*;

// Clase que representa un grafo usando lista de adyacencia con letras
public class Red {
    private Map<Character, List<Character>> adjList; // Lista de adyacencia

    // Constructor
    public Red() {
        adjList = new HashMap<>();
    }

    // Método para agregar una arista a la red
    void agregarConexion(char v, char w) {
        adjList.putIfAbsent(v, new LinkedList<>());
        adjList.putIfAbsent(w, new LinkedList<>());
        adjList.get(v).add(w); // Agrega w a la lista de v
    }

    // Método para realizar el recorrido en profundidad (DFS) desde un vértice fuente
    void DFS(char inicio) {
        // Marca todos los vértices como no visitados
        Set<Character> visitado = new HashSet<>();

        // Llama a la función recursiva DFS
        DFSRecursivo(inicio, visitado);
    }

    // Función recursiva para realizar el DFS
    private void DFSRecursivo(char vertice, Set<Character> visitado) {
        // Marca el vértice actual como visitado y lo imprime
        visitado.add(vertice);
        System.out.print(vertice + " ");

        // Recurre para todos los vértices adyacentes no visitados
        for (char vecino : adjList.get(vertice)) {
            if (!visitado.contains(vecino)) {
                DFSRecursivo(vecino, visitado);
            }
        }
    }

    public static void main(String args[]) {
        
        Red red = new Red();

        // Agrega las conexiones a la red
        red.agregarConexion('A', 'B');
        red.agregarConexion('A', 'C'); 
        red.agregarConexion('B', 'D');
        red.agregarConexion('B', 'E'); 
        red.agregarConexion('C', 'E');
        red.agregarConexion('D', 'F'); 
        red.agregarConexion('E', 'F'); 

        System.out.println("Recorrido DFS empezando desde el vértice A:");

        // Realiza el DFS desde el vértice A
        red.DFS('A');
    }
}

