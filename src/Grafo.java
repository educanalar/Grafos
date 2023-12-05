import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Grafo {
    // Lista adyacente para representar un grafo
    private Map<Vertice, List<Vertice>> listaAdyacente;

    // Constructor del grafo
    public Grafo(){
        this.listaAdyacente = new HashMap<Vertice, List<Vertice>>();
    }

    // Método get para la listaAdyacente
    public Map<Vertice, List<Vertice>> getListaAdyacente() {
        return listaAdyacente;
    }

    // Método set para la listaAdyacente
    public void setListaAdyacente(Map<Vertice, List<Vertice>> listaAdyacente) {
        this.listaAdyacente = listaAdyacente;
    }

    // Agrega un vértice
   public void agregarVertice(String nombre){
        // usa el método putIfAbsent de la clase Map, el cual agrega solo si no existe ya elemento
        listaAdyacente.putIfAbsent(new Vertice(nombre), new ArrayList());
    }

    // Elimina un vértice
    public void eliminarVertice(String nombre){
        Vertice v = new Vertice(nombre);
        // Elimina todas (forEach) las referencias a este elemento
        listaAdyacente.values().stream().forEach(e -> e.remove(v));
        listaAdyacente.remove(new Vertice(nombre));

    }

    // Agrega una arista
   public void agregarArista(String nombre1, String nombre2){
        Vertice v1 = new Vertice(nombre1);
        Vertice v2 = new Vertice(nombre2);
        // Debemos agregar las aristas en las listas correspondientes, es decir, definir que v1 "conoce" a v2 y viceversa, que v2 conoce a v1.
        listaAdyacente.get(v1).add(v2);
        listaAdyacente.get(v2).add(v1);
    }

    // Eliminar arista
    public void eliminarArista(String nombre1, String nombre2){
        Vertice v1 = new Vertice(nombre1);
        Vertice v2 = new Vertice(nombre2);
        List<Vertice> verticesV1 = listaAdyacente.get(v1);
        List<Vertice> verticesV2 = listaAdyacente.get(v2);
        // Al igual que para agregar arista, se debe eliminar la relación de V1 con v2 y de v2 con v1
        if(verticesV1 != null){
            verticesV1.remove(v2);
        }
        if(verticesV2 != null){
            verticesV2.remove(v1);
        }
    }

    // Obtiene la lista de "amigos" de una persona
    List<Vertice> getVerticesAdyacentes(String nombre){
        return listaAdyacente.get(new Vertice(nombre));
    }

    public void imprimirGrafoComoListaAdyacente() {
        String grafo = "";
        List<Vertice> lista = new ArrayList<Vertice>();
        for(Vertice v : listaAdyacente.keySet()){
            grafo += v.nombre;
            grafo += " : ";
            lista = getVerticesAdyacentes(v.nombre);
            for(Vertice v2 : lista){
                grafo += v2.nombre;
                grafo += " , ";
            }
            grafo = grafo.substring(0, grafo.length()-2);
            grafo += "\n";
        }
        System.out.println(grafo);
    }
}