package com.example.ramir.driverapp.map;

import com.example.ramir.driverapp.util.DoubleArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private List<Node<String>> vertices = new ArrayList<>();
    private Integer[][] distances;  // Matrix with shorter distance between nodes
    private Node<String>[][] predecessors;  // Matrix with predecessors of the nodes
    private HashMap<Node<String>, DoubleArray<Integer, Node<String>>> matrix = new HashMap<>();  // Node, [Distance, Predecessor]


    public Graph() {
    }

    /**
     * Constructor that automatically calculates the shorter distance between all nodes
     *
     * @param vertices the list of nodes that will form the graph
     */
    public Graph(List<Node<String>> vertices) {
        this.vertices = vertices;
        floyd_warshall();
    }

    /**
     * Calculates the shorter path between two nodes
     *
     * @param node1 initial node
     * @param node2 final node
     * @return a list of nodes from the initial to the final
     */
    public final List<Node<String>> path(Node<String> node1, Node<String> node2) {
        List<Node<String>> nodes = new ArrayList<>();
        int i = vertices.indexOf(node1);
        int j = vertices.indexOf(node2);
        nodes.add(node2);

        Node<String> node = null;
        while (node != node1) {
            node = predecessors[i][j];
            if (node == null){
                nodes = null;
                break;
            }
            nodes.add(node);
            j = vertices.indexOf(node);
        }

        Collections.reverse(nodes);
        return nodes;
    }

    /**
     * Calculates the shorter distance between one node to all others
     *
     * @param node the reference node to calculate distance
     * @return a Map with the node as the key and a double array of the [distance, predecessor] as the value
     */
    public final HashMap<Node<String>, DoubleArray<Integer, Node<String>>> dijkstra(Node<String> node) {
        List<Node<String>> V = new ArrayList<>();
        List<Node<String>> NV = new ArrayList<>();

        // Sets the matrix with magnitudes -1 and predecessors null
        matrix.clear();
        for (Node<String> n : vertices) {
            DoubleArray<Integer, Node<String>> array = new DoubleArray<>(-1, null);
            matrix.put(n, array);
        }

        // Enters a loop that set the nodes minimum distances
        dijkstra(node, node, V, NV);
        for (int i = 0; i < NV.size(); i++) {
            dijkstra(node, NV.get(i), V, NV);
        }
        return matrix;
    }

    private void dijkstra(Node<String> node, Node<String> current, List<Node<String>> V, List<Node<String>> NV) {
        // Manages the lists
        V.add(current);

        // Process the node
        if (current.equals(node)) matrix.get(current).setFirst(0);
        int last_distance = matrix.get(current).getFirst();

        current.getAdjacent().forEach((k, v) -> {
            int distance = matrix.get(k).getFirst();
            if (distance == -1 || (v + last_distance) < distance) {
                matrix.get(k).setFirst(v + last_distance);
                matrix.get(k).setSecond(current);
            }

            if (!V.contains(k) && !NV.contains(k)) NV.add(k);
        });
    }

    /**
     * Generates adjacency matrix with weight that has the shorter path between any node in the vertices
     */
    public final void floyd_warshall() {
        int len = vertices.size();
        distances = new Integer[len][len];
        predecessors = new Node[len][len];

        int i = 0;
        for (Node<String> node : vertices) {
            HashMap<Node<String>, DoubleArray<Integer, Node<String>>> matrix = dijkstra(node);
            for (int j = 0; j < matrix.size(); j++) {
                DoubleArray<Integer, Node<String>> v = matrix.get(vertices.get(j));
                if (i == j) {
                    distances[i][j] = 0;
                    predecessors[i][j] = null;
                } else {
                    distances[i][j] = v.getFirst();
                    predecessors[i][j] = v.getSecond();
                }
            }
            i++;
        }
    }


    /**
     * Getters and Setters
     **/

    public List<Node<String>> getVertices() {
        return vertices;
    }

    public void setVertices(List<Node<String>> vertices) {
        this.vertices = vertices;
    }

    public Integer[][] getDistances() {
        return distances;
    }

    public void setDistances(Integer[][] distances) {
        this.distances = distances;
    }

    public Node<String>[][] getPredecessors() {
        return predecessors;
    }

    public void setPredecessors(Node<String>[][] predecessors) {
        this.predecessors = predecessors;
    }
}
