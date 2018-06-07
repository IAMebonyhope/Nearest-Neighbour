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

/**
 *
 * @author EbonyHope
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<Vertix, List<Node>> graph = new HashMap<Vertix, List<Node>>();
        
        Vertix v1 = new Vertix("A");
        Vertix v2 = new Vertix("B");
        Vertix v3 = new Vertix("C");
        Vertix v4 = new Vertix("D");
        Vertix v5 = new Vertix("E");
        
        //adjacent nodes of v1
        List<Node> arr1 = new ArrayList<Node>();
        arr1.add(new Node(v2, 9));
        arr1.add(new Node(v3, 13));
        arr1.add(new Node(v4, 9));
        arr1.add(new Node(v5, 20));
        graph.put(v1, arr1);
        
        List<Node> arr2 = new ArrayList<Node>();
        arr2.add(new Node(v1, 9));
        arr2.add(new Node(v3, 10));
        arr2.add(new Node(v4, 8));
        arr2.add(new Node(v5, 3));
        graph.put(v2, arr2);
        
        List<Node> arr3 = new ArrayList<Node>();
        arr3.add(new Node(v1, 13));
        arr3.add(new Node(v2, 10));
        arr3.add(new Node(v4, 7));
        arr3.add(new Node(v5, 8));
        graph.put(v3, arr3);
        
        //
        List<Node> arr4 = new ArrayList<Node>();
        arr4.add(new Node(v1, 9));
        arr4.add(new Node(v2, 8));
        arr4.add(new Node(v3, 7));
        arr4.add(new Node(v5, 5));
        graph.put(v4, arr4);
        
        List<Node> arr5 = new ArrayList<Node>();
        arr5.add(new Node(v1, 20));
        arr5.add(new Node(v2, 3));
        arr5.add(new Node(v3, 8));
        arr5.add(new Node(v4, 5));
        graph.put(v5, arr5);
        
        Graph g = new Graph(graph);
        nearestNeighbour nearN = new nearestNeighbour(g);
        
        if(nearN.isComplete() == true){
            System.out.println("This graph is a complete graph");
            HashMap<List<Vertix>, Integer> hamiltons = nearN.getCircuits();
            
            for (Map.Entry<List<Vertix>, Integer> entry : hamiltons.entrySet()) {
                System.out.print("( ");
                List<Vertix> vertices = entry.getKey();
                int weight = entry.getValue();
                
                for(Vertix v: vertices){
                    System.out.print(v.getName() + ", ");
                }
                System.out.print(") = " + weight);
                System.out.println();
            }
	}
        else{
            System.out.println("This graph is not a complete graph");
        }
    }
    
}
