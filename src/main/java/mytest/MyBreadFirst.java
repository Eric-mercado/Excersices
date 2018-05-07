package mytest;

import java.util.LinkedList;
import java.util.List;

public class MyBreadFirst {

    public static void main(String args[]){
    Graph myGraph = new Graph(4);

    myGraph.addAdjacency(0,1);
    myGraph.addAdjacency(0,2);
    myGraph.addAdjacency(1,2);
    myGraph.addAdjacency(2,0);
    myGraph.addAdjacency(2,3);
    myGraph.addAdjacency(3,3);

    navigate(myGraph);
    }


    static void navigate(Graph myGraph){

        LinkedList<Node> queue = new LinkedList<>();

        queue.add(myGraph.get(0));
        myGraph.get(0).visited = true;
        System.out.println( "visiting : node:0");

        while(!queue.isEmpty()){
            Node nodeNo = queue.poll();

            for(Node node: nodeNo.getList()){

                if(!node.visited){
                    System.out.println( "visiting : " + node.name);
                    queue.add(node);
                    node.visited = true;

                } else {
                    System.out.println("Node  allready visited:" + node.name);
                }

            }
        }
    }



}
