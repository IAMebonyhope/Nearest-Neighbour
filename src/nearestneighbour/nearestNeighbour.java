/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nearestneighbour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author EbonyHope
 */
public class nearestNeighbour<V> {
    
    private HashMap<List<Vertix<V>>, Integer> circuits;
    private Graph graph;
    
    public nearestNeighbour(Graph graph){
        circuits = new HashMap<List<Vertix<V>>, Integer>();
        this.graph = graph;
        if(this.isComplete() == true){
            this.computeCircuits();
        }
    }
    
    public HashMap<List<Vertix<V>>, Integer> getCircuits(){
        return this.circuits;
    }
    
    public boolean isComplete(){
        int n = graph.numOfVertices();
        boolean isCom = true;
        Set<Vertix<V>> vertices = graph.vertices();
        for (Vertix v: vertices) {
            int edg = graph.adj(v).size();
            if(edg != (n-1)){
                isCom = false;
                break;
            }
        }
        return isCom;
    }
    
    private boolean isAllVisited(){
        Set<Vertix<V>> vertices = graph.vertices();
        boolean allVisited = true;
        for (Vertix v: vertices) {
            if(v.getVisted() == false){
                allVisited = false;
                break;
            }
        }
        return allVisited;
    }
    
    private Node<V> getNearestNode(Vertix v){
        List<Node<V>> nodes = graph.adj(v);
        Node node = new Node();
        int smallest = node.getWeight();
        for(Node n: nodes){
            if((n.getVertix().getVisted() == false) && (n.getWeight() <= smallest)){
                smallest = n.getWeight();
                node = n;
            }
        }
        return node;
    }
    
    private void clearAllVertices(){
        Set<Vertix<V>> vertices = graph.vertices();
        for(Vertix v: vertices){
            v.setVisted(false);
        }
    }
    
    private int getEdgeDistance(Vertix v1, Vertix v2){
        int dist = 1000;
        List<Node<V>> nodes = graph.adj(v1);
        for(Node n: nodes){
            if(n.getVertix().getName() == v2.getName()){
                dist = n.getWeight();
                break;
            }
        }
        return dist;
    }
    
    private void computeCircuits(){
        Set<Vertix<V>> vertices = graph.vertices();
        for (Vertix v: vertices) {
            this.clearAllVertices();
            int weight = 0;
            List<Vertix<V>> arr = new ArrayList<Vertix<V>>();
            arr.add(v);
            v.setVisted(true);
            
            Node nod = this.getNearestNode(v);
            if(nod.getVertix().getName() != "inf"){
                Vertix vert = nod.getVertix();
                arr.add(vert);
                vert.setVisted(true);
                weight += nod.getWeight();
                while(this.isAllVisited() == false){
                    nod = this.getNearestNode(vert);
                    if(nod.getVertix().getName() != "inf"){
                        vert = nod.getVertix();
                        arr.add(vert);
                        vert.setVisted(true);
                        weight += nod.getWeight();
                    }                   
                }
            }
            weight += this.getEdgeDistance(nod.getVertix(), v);
            arr.add(v);
            if(!arr.isEmpty()){
                circuits.put(arr, weight);
            }
        }
    }
}
