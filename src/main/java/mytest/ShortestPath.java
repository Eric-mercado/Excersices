package mytest;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
1.- crear el grafico
2.- crear un array  con posibles caminos
3.- navegar por el grafico  y  buscando el destino
    3.1 al ir navegando ir guadando posibles caminos  en el array
    3.2 al encontrar el camino  guardarlo en el array
    3.3 si no se esncuentra camino  no guardar nada
 4.- ordenar  caminos en base a tamaños
 5 .- imprimirla  en pantalla
 */
public class ShortestPath {

    List<StringBuilder> routes;
    Graph myGraph;
    StringBuilder routeBuilder;
    LinkedList<Node> queue;

    public ShortestPath(){
        routes = new ArrayList<>();
        queue  = new LinkedList<>();
    }

    public static void main(String args[]){



        ShortestPath shortestPath = new ShortestPath();
       Graph thisGraph =  shortestPath.myGraph = new Graph(7);

        thisGraph.addAdjacency(0,1);
        thisGraph.addAdjacency(0,3);
        thisGraph.addAdjacency(1,2);
        thisGraph.addAdjacency(2,5);
        thisGraph.addAdjacency(3,4);
        thisGraph.addAdjacency(4,6);
        thisGraph.addAdjacency(5,1);

        thisGraph.addAdjacency(3,2);
        thisGraph.addAdjacency(2,4);
        shortestPath.shortestP(0,6);


    }

     void shortestP( int from, int to ){

         System.out.println("---------- Begginig navigation -------- ");
         System.out.println("going to node: " + to + " from node: " + from );

        Node fromNode = myGraph.get(from);
        Node destinyNode = myGraph.get(to);

         this.queue.add(fromNode);
         fromNode.visited = true;

         routeBuilder = new StringBuilder();
         routes.add(routeBuilder);

         while(!queue.isEmpty()){

            Node currentNOde = queue.pollLast();
             System.out.println("-- taking new node" + currentNOde.name + " ---");

            for(Node node: currentNOde.getList()){

                keepWalking(node, destinyNode);
            }
        }
    }

    void keepWalking(Node from, Node to){

        // dismiss end of road or nodes with no end
        cleanNodes(from,to);

        System.out.println( "walking on " + from.name);

        // im i on the desired location
        if(from.name ==to.name){
            routeBuilder.append( "-> " + to.name);
            System.out.println("!!! ---- finded  --- !!!");

          //  routeBuilder.append(tempBuilder.toString()); // concat bout builders
            System.out.println(routeBuilder.toString()); // prin route
            routes.add(routeBuilder);                   // add current route to array
            routeBuilder  = new StringBuilder();        //  restarting rote builder
            queue.pollLast();                               // removing last visited node form queue
        }


        // is this a new place
        if(!from.visited){
            routeBuilder.append(" -> "+ from.name + " ");
            queue.add(from);
            from.visited = true;

            for(Node next : from.getList()){
                keepWalking(next,to);
            }

        }else{
            routeBuilder.append(from.name + " allready visited -  no connecting to destination");
            System.out.println(routeBuilder.toString()); // printing the whole route
            routeBuilder = new StringBuilder(); // end of the road restarting to a new path
        //    keepWalking(from,to);
            myGraph.unVisitNodes(); // unvisiting nodes
            queue.pollLast(); // removing last  node from the queue
        }
    }

    void cleanNodes(Node from, Node to){

        if(queue.size() > 0) {
            Node node = queue.peekLast();
            int nodeChilds = node.getList().size();
            boolean hasOnlyVisitedChilds = node.noChildsLeft();


            if (queue.contains(from) || nodeChilds < 0 || hasOnlyVisitedChilds) {
                queue.pollLast();
            }
        }
    }
}

