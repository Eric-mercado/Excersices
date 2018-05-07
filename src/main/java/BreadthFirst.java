// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.
import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class BreadthFirst
{
    private int Vertices;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    // Constructor
    BreadthFirst(int vertix)
    {
        Vertices = vertix;
        adj = new LinkedList[vertix];
        for (int i=0; i<vertix; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
    }

    // prints BFS traversal from a given sources
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[Vertices];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.println(" ");
            System.out.println(" ");
            System.out.print("Visiting Node " + s);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            System.out.println(" adj  to visit " + adj[s].toString());
            while (i.hasNext())
            {
                int n = i.next();
                System.out.println("Exploring  Adj " + n);
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                    System.out.println("explored  and added to queue");
                } else {
                    System.out.println( "Allready explored, will be skipped");

                }
            }
        }
    }

    // Driver method to
    public static void main(String args[])
    {
        BreadthFirst g = new BreadthFirst(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }
}
// This code is contributed by Aakash Hasija