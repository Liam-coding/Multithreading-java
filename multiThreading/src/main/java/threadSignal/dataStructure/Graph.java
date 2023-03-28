package threadSignal.dataStructure;

import java.util.ArrayList;
import java.util.List;

// A simple representation of a graph using an adjacency list
public class Graph {
    // A class to represent an edge
    static class Edge {
        int src; // source vertex
        int dest; // destination vertex

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // A list of lists to store the adjacency list
    List<List<Integer>> adjList;

    // A constructor to create a graph from a given array of edges
    Graph(Edge[] edges, int n) {
        // Initialize the adjacency list with an empty list for each vertex
        adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add each edge to the adjacency list by adding the destination vertex
        // to the source vertex's list
        for (Edge edge : edges) {
            adjList.get(edge.src).add(edge.dest);
        }
    }

    // A utility method to print the adjacency list representation of the graph
    void printGraph() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Graph.Edge edge1 = new Edge(0,1);
        Graph.Edge edge2 = new Edge(0,2);
        Graph.Edge edge3 = new Edge(1,2);
        Graph.Edge edge4 = new Edge(2,1);
        Graph.Edge edge5 = new Edge(2,3);
        Graph.Edge edge6 = new Edge(4,5);
        Graph.Edge edge7 = new Edge(4,0);
        Edge[] edges = new Edge[7];
        edges[0] =edge1;
        edges[1] =edge2;
        edges[2] =edge3;
        edges[3] =edge4;
        edges[4] =edge5;
        edges[5] =edge6;
        edges[6] =edge7;

        Graph graph = new Graph(edges,6);
        graph.printGraph();
    }
}
