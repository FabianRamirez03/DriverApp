package com.example.ramir.driverapp.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.example.ramir.driverapp.util.Math;

public class MapGenerator {

    private static int[] connections = new int[]{1, 3};  // Min and max connection between nodes
    private static int[] magnitude = new int[]{1, 10};  // Min and max magnitudes between nodes

    /**
     * Generates a Graph with Nodes that have random names and connections with random nodes in random magnitudes
     *
     * @param size the amount of Nodes in the Graph
     * @return the random Graph
     */
    public static Graph generateGraph(int size) {
        List<Node<String>> nodes = new ArrayList<>();
        String[] names = generateNames(size);

        // Creates the nodes that will be in vertices list
        for (int i = 0; i < size; i++) {
            String name = names[i];
            Node<String> node = new Node<>(name);
            nodes.add(node);
        }

        // Set randomly the adjacent nodes and magnitudes of every node
        for (Node<String> node : nodes) {
            HashMap<Node<String>, Integer> connections = generateConnections(nodes);
            node.setAdjacent(connections);
        }

        return new Graph(nodes);
    }

    private static String[] generateNames(int size) {
        String[] names = new String[size];
        names[0] = "B0";

        for (int i = 1; i < size; i++) {
            double rand = java.lang.Math.random();
            if (rand < 0.3) names[i] = "B" + i;
            if (rand >= 0.3) names[i] = "C" + i;
        }

        return names;
    }

    private static HashMap<Node<String>, Integer> generateConnections(List<Node<String>> nodes) {
        HashMap<Node<String>, Integer> map = new HashMap<>();

        int maxConnections = Math.getRandomNumberInRange(connections[0], connections[1]);
        for (int i = 0; i < maxConnections; i++) {
            int duration = Math.getRandomNumberInRange(magnitude[0], magnitude[1]);
            int nodeIndex = Math.getRandomNumberInRange(0, nodes.size() - 1);
            Node<String> node = nodes.get(nodeIndex);
            map.put(node, duration);
        }

        return map;
    }
}
