/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.transferencia;

/**
 *
 * @author Andres
 */
import java.util.*;

// Clase que representa un grafo usando lista de adyacencia con letras
public class Grafo {
    private Map<Character, List<Character>> adjList; // Lista de adyacencia

    // Constructor
    public Grafo() {
        adjList = new HashMap<>();
    }

    // Método para agregar una arista al grafo
    void agregarArista(char v, char w) {
        adjList.putIfAbsent(v, new LinkedList<>());
        adjList.putIfAbsent(w, new LinkedList<>());
        adjList.get(v).add(w); // Agrega w a la lista de v
    }

    // Método para realizar el recorrido en anchura (BFS) desde un vértice fuente
    void BFS(char inicio) {
        // Marca todos los vértices como no visitados
        Set<Character> visitado = new HashSet<>();

        // Crea una cola para el BFS
        LinkedList<Character> cola = new LinkedList<>();

        // Marca el nodo de inicio como visitado y lo agrega a la cola
        visitado.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            // Extrae un vértice de la cola y lo imprime
            inicio = cola.poll();
            System.out.print(inicio + " ");

            // Obtiene todos los vértices adyacentes al vértice extraído
            // Si un vértice adyacente no ha sido visitado, se marca como visitado y se agrega a la cola
            for (char n : adjList.get(inicio)) {
                if (!visitado.contains(n)) {
                    visitado.add(n);
                    cola.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        
        Grafo g = new Grafo();

        
        g.agregarArista('A', 'B');
        g.agregarArista('A', 'C'); 
        g.agregarArista('B', 'D');
        g.agregarArista('B', 'E'); 
        g.agregarArista('C', 'E'); 
        g.agregarArista('D', 'F'); 
        g.agregarArista('E', 'F');

        System.out.println("Recorrido BFS empezando desde el vértice A:");

        // Realiza el BFS desde el vértice A
        g.BFS('A');
    }
}
