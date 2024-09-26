package com.mycompany.transferencia;

import java.io.*;
import java.util.*;

/**
 * Esta clase permite cargar una matriz de adyacencia desde un archivo de texto,
 * y calcular los grados de los nodos en un grafo, tanto para un grafo no dirigido
 * como para un grafo dirigido.
 */
public class MatrizAdyacencia {

    // Constructor de la clase MatrizAdyacencia.
    public MatrizAdyacencia() {
    }

    /**
     * Método que lee una matriz de adyacencia desde un archivo de texto.
     * El archivo debe contener una representación de la matriz donde cada fila
     * es una línea de texto, con los elementos de la fila separados por espacios.
     * 
     * @param archivo Nombre del archivo que contiene la matriz de adyacencia.
     * @return Un arreglo bidimensional (matriz) de enteros que representa la matriz de adyacencia.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public static int[][] leerMatrizAdyacencia(String archivo) throws IOException {
        // Se crea una lista temporal para almacenar las filas de la matriz.
        List<int[]> lista = new ArrayList<>();

        // Se abre el archivo para lectura utilizando BufferedReader.
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;

        // Se lee el archivo línea por línea.
        while ((linea = br.readLine()) != null) {
            // Se dividen los elementos de la línea por espacios y se convierten a enteros.
            String[] partes = linea.trim().split("\\s+");
            int[] fila = Arrays.stream(partes).mapToInt(Integer::parseInt).toArray();
            lista.add(fila);  // Se agrega la fila a la lista.
        }

        // Se cierra el archivo después de leerlo.
        br.close();

        // Se convierte la lista en una matriz bidimensional y se retorna.
        return lista.toArray(new int[0][]);
    }

    /**
     * Calcula y muestra el grado de los nodos para un grafo no dirigido.
     * El grado de un nodo en un grafo no dirigido es la suma de los valores
     * de la fila correspondiente en la matriz de adyacencia.
     * 
     * @param matriz Matriz de adyacencia del grafo.
     */
    public static void calcularGradoNoDirigido(int[][] matriz) {
        // Se recorre cada fila de la matriz (cada nodo).
        for (int i = 0; i < matriz.length; i++) {
            int grado = 0;
            // Se suma cada elemento de la fila para obtener el grado del nodo.
            for (int j = 0; j < matriz[i].length; j++) {
                grado += matriz[i][j];
            }
            // Se imprime el grado del nodo.
            System.out.println("El grado del nodo " + i + " es " + grado);
        }
    }

    /**
     * Calcula y muestra el grado de los nodos para un grafo dirigido.
     * El grado de salida de un nodo es la suma de los valores de su fila en la matriz.
     * El grado de entrada de un nodo es la suma de los valores de su columna.
     * 
     * @param matriz Matriz de adyacencia del grafo.
     */
    public static void calcularGradoDirigido(int[][] matriz) {
        // Se recorre cada fila de la matriz (cada nodo).
        for (int i = 0; i < matriz.length; i++) {
            int gradoSalida = 0;
            int gradoEntrada = 0;

            // Se calcula el grado de salida sumando los elementos de la fila.
            // Se calcula el grado de entrada sumando los elementos de la columna correspondiente.
            for (int j = 0; j < matriz.length; j++) {
                gradoSalida += matriz[i][j]; // Grado de salida (fila).
                gradoEntrada += matriz[j][i]; // Grado de entrada (columna).
            }

            // Se imprime el grado de salida y de entrada para el nodo.
            System.out.println("Nodo " + i + ": Grado de salida = " + gradoSalida + ", Grado de entrada = " + gradoEntrada);
        }
    }
    
    /**
     * Método principal del programa.
     * Lee la matriz de adyacencia desde un archivo y calcula el grado de los nodos
     * tanto para un grafo no dirigido como para un grafo dirigido.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     * @throws IOException Si ocurre un error al leer el archivo de la matriz de adyacencia.
     */
    public static void main(String[] args) throws IOException {
        // Se lee la matriz de adyacencia desde el archivo especificado.
        int[][] matriz = leerMatrizAdyacencia("matrizadyacencia.txt");

        // Se calcula e imprime el grado de los nodos para un grafo no dirigido.
        System.out.println("Grado No Dirigido");
        calcularGradoNoDirigido(matriz);

        // Se calcula e imprime el grado de los nodos para un grafo dirigido.
        System.out.println("Grado Dirigido");
        calcularGradoDirigido(matriz);
    }
}
