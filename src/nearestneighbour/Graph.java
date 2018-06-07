/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nearestneighbour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author EbonyHope
 */
public class Graph<V> {
    private HashMap<Vertix<V>, List<Node<V>>> adjList;
    
    public Graph(HashMap<Vertix<V>, List<Node<V>>> list){
        adjList = list;
    }
    
    public Set<Vertix<V>> vertices(){
        Set<Vertix<V>> keys = adjList.keySet();
        return keys;
    }
    
    public int numOfVertices(){
        return vertices().size();
    }
    
    public List<Node<V>> adj(Vertix<V> vert){
       List<Node<V>> values = adjList.get(vert); 
       return values;
    }
    
    public void addNode(Vertix<V> vertex, Node<V> node) {
        List<Node<V>> nodes = adj(vertex);
        if (nodes == null || nodes.isEmpty()) { 
            nodes = new ArrayList<Node<V>>();
            nodes.add(node);
        } 
        else {
            nodes.add(node);
        }
        
        adjList.put(vertex, nodes);
    }
    
    public HashMap<Vertix[], Integer> edges(){
        HashMap<Vertix[], Integer> edges = new HashMap<Vertix[], Integer>();
        
        for (Map.Entry<Vertix<V>, List<Node<V>>> entry : adjList.entrySet()) {
            Vertix v1 = entry.getKey();
            for(Node n: entry.getValue()){
                Vertix v2 = n.getVertix();
                int weight = n.getWeight();
                
                Vertix[] v = {v1, v2};
                edges.put(v, weight);
            }
	}
        return edges;
    }
    
    public int numOfEdges(){
        return edges().size();
    }
    
    /*public boolean hasRelationship(V v1, V v2) {
    if (v1 == null && v2 == null)
     return true;
    if (v1 != null && v2 == null)
     return true;
    if (v1 == null && v2 != null)
     return false;

    List<Node<V>> nodes = null;

    if (adjacencyList.containsKey(v1)) {
     nodes = adjacencyList.get(v1);
     if (nodes != null || !nodes.isEmpty()) {
      for (Node<V> v : nodes) {
       if (v.getName().equals(v2))
        return true;
      }
     }
    }
    return false;
   }

   public void print() {
    System.out.println("Graph is --->");
    for (V v : adjacencyList.keySet()){
        System.out.println(v + " --- " + adjacencyList.get(v));
                  }  
   }*/
}
