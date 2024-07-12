package app;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int Vertex;
    private LinkedList<Integer> adj[];

    Graph(int vertex) {
        Vertex = vertex;
        adj = new LinkedList[vertex];
        for (int i = 0; i < vertex; ++i)
            adj[i] = new LinkedList();

    }

    @Override
    public String toString() {
        return Arrays.toString(adj);
    }

    void addEdge(int source, int destination) {
        adj[source].add(destination);
    }

    void hasVertex(int vertex) {

        boolean visited[] = new boolean[Vertex];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[vertex] = true;
        queue.add(vertex);

        while (queue.size() != 0) {

            vertex = queue.poll();
            System.out.print(vertex + " ");

            Iterator<Integer> i = adj[vertex].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph graph = new Graph(4);

        graph.addEdge(1, 3);
        graph.addEdge(1, 1);
        graph.addEdge(0, 0);
        graph.addEdge(3, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 0);

        System.out.println("Graph\n" + graph);
        System.out.println();
        System.out.println("HasVertex починаючи з вершини 2:");
        graph.hasVertex(2);
    }
}


