/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nearestneighbour;

/**
 *
 * @author EbonyHope
 */
public class Node<V> {
    private Vertix vertix; // Vertex name
    private int weight;
    
    public Node(){
        this.vertix = new Vertix("inf");
        this.weight = 1000;
    }
    
    public Node(Vertix vertix, int weight) {
       super();
       this.vertix = vertix;
       this.weight = weight;
    }

    public Vertix getVertix() {
        return vertix;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.vertix.getName() + ":" + this.weight;
    }
}
