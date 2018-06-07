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
public class Vertix<V> {
    
    private final V name;
    private boolean visted;
    
    public Vertix(V name){
        this.name = name;
        this.visted = false;
    }
    
    public V getName(){
        return name;
    }
    
    public boolean getVisted(){
        return visted;
    }
    
    public void setVisted(boolean val){
        this.visted = val;
    }
}

