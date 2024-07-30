package grafo;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        String[] ciudades = {"Arad", "Zerind", "Oradea", "Sibiu", "Timisoara", "Lugoj", "Mehadia", "Dobreta", 
                             "Craiova", "Rimnicu Vilcea", "Pitesti", "Fagaras", "Bucarest", "Giurgiu", "Urziceni", 
                             "Hirsova", "Eforie", "Vaslui", "Iasi", "Neamt"};
        for (String ciudad : ciudades) {
            grafo.agregarVertice(ciudad);
        }
        grafo.agregarArista("Arad", "Zerind", 75);
        grafo.agregarArista("Arad", "Timisoara", 118);
        grafo.agregarArista("Arad", "Sibiu", 140);
        grafo.agregarArista("Zerind", "Oradea", 71);
        grafo.agregarArista("Oradea", "Sibiu", 151);
        grafo.agregarArista("Timisoara", "Lugoj", 111);
        grafo.agregarArista("Lugoj", "Mehadia", 70);
        grafo.agregarArista("Mehadia", "Dobreta", 75);
        grafo.agregarArista("Dobreta", "Craiova", 120);
        grafo.agregarArista("Craiova", "Rimnicu Vilcea", 146);
        grafo.agregarArista("Craiova", "Pitesti", 138);
        grafo.agregarArista("Rimnicu Vilcea", "Sibiu", 80);
        grafo.agregarArista("Rimnicu Vilcea", "Pitesti", 97);
        grafo.agregarArista("Sibiu", "Fagaras", 99);
        grafo.agregarArista("Fagaras", "Bucarest", 211);
        grafo.agregarArista("Pitesti", "Bucarest", 101);
        grafo.agregarArista("Bucarest", "Giurgiu", 90);
        grafo.agregarArista("Bucarest", "Urziceni", 85);
        grafo.agregarArista("Urziceni", "Hirsova", 98);
        grafo.agregarArista("Hirsova", "Eforie", 86);
        grafo.agregarArista("Urziceni", "Vaslui", 142);
        grafo.agregarArista("Vaslui", "Iasi", 92);
        grafo.agregarArista("Iasi", "Neamt", 87);

        System.out.println("Búsqueda en Profundidad (DFS) comenzando desde Arad:");
        dfs(grafo, "Arad");

        System.out.println("\nBúsqueda en Anchura (BFS) comenzando desde Arad:");
        bfs(grafo, "Arad");
    }

    public static void dfs(Grafo grafo, String inicio) {
        Set<String> visitados = new HashSet<>();
        Stack<String> pila = new Stack<>();
        pila.push(inicio);

        while (!pila.isEmpty()) {
            String vertice = pila.pop();
            if (!visitados.contains(vertice)) {
                visitados.add(vertice);
                System.out.print(vertice + " ");
                for (Arista arista : grafo.obtenerAdjVertices(vertice)) {
                    if (!visitados.contains(arista.destino)) {
                        pila.push(arista.destino);
                    }
                }
            }
        }
    }

    public static void bfs(Grafo grafo, String inicio) {
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();
        cola.add(inicio);
        visitados.add(inicio);

        while (!cola.isEmpty()) {
            String vertice = cola.poll();
            System.out.print(vertice + " ");
            for (Arista arista : grafo.obtenerAdjVertices(vertice)) {
                if (!visitados.contains(arista.destino)) {
                    visitados.add(arista.destino);
                    cola.add(arista.destino);
                }
            }
        }
    }
}
