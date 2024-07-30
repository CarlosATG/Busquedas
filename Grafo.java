package grafo;

import java.util.*;

public class Grafo {
    private Map<String, List<Arista>> adjVertices;

    public Grafo() {
        adjVertices = new HashMap<>();
    }

    public void agregarVertice(String etiqueta) {
        adjVertices.putIfAbsent(etiqueta, new ArrayList<>());
    }

    public void agregarArista(String etiqueta1, String etiqueta2, int peso) {
        adjVertices.get(etiqueta1).add(new Arista(etiqueta2, peso));
        adjVertices.get(etiqueta2).add(new Arista(etiqueta1, peso));
    }

    public List<Arista> obtenerAdjVertices(String etiqueta) {
        return adjVertices.get(etiqueta);
    }
}
