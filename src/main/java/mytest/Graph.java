package mytest;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    List<Node> nodes = new ArrayList<>();

    Graph(int nodes){
        for(int i = 0 ; i < nodes; i++){
            this.nodes.add(new Node("node :" + i ));
        }
    }

    public void addAdjacency(int from, int to){

        this.nodes.get(from).addNodes(this.nodes.get(to));
    }

    public Node get(int index){
        return this.nodes.get(index);
    }

    public void unVisitNodes(){
        for(Node node: this.nodes){
            node.visited = false;
        }
    }
}
