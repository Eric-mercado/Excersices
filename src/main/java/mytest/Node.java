package mytest;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private List<Node> adjacencies ;
    public boolean visited = false;
    String name;

    public Node(String name){
        this.name = name;
        adjacencies = new ArrayList<>();
    }

    public void addNodes(Node node){
        adjacencies.add(node);
    }

    List<Node> getList(){
        return this.adjacencies;
    }

    public boolean noChildsLeft(){
        boolean noChildLeft = false;
        for(Node node: adjacencies ){
            if(!node.visited){
                noChildLeft = true;
                break;
            }
        }


        return noChildLeft;
    }
}
