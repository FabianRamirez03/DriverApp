package com.example.ramir.driverapp.client;

import com.example.ramir.driverapp.map.Graph;
import com.example.ramir.driverapp.map.MapGenerator;


public class RestClient {

    private static Graph graph = MapGenerator.generateGraph(30);

    private static final String REST_URI = "http://192.168.1.12:9080/CarpoolingServer_war/";

    public static Graph getGraph() {
        return graph;
    }

}
