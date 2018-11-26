package com.example.ramir.driverapp.map;

import java.util.HashMap;

public class Node<T> {

    private T element = null;
    private HashMap<Node<T>, Integer> adjacent = new HashMap<>();  // Connections and their magnitudes with this Node

    public Node() {
    }

    public Node(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public HashMap<Node<T>, Integer> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(HashMap<Node<T>, Integer> adjacent) {
        this.adjacent = adjacent;
    }
}
