package ru;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedGraph;

import java.util.List;

public class GrapTet {


    public static void main(String[] args) {

        final Owner sham = new Owner(0, "Шамиль");
        final Owner egor = new Owner(0, "Егор");

        final Team team = new Team(0, "Sbol-PRO");
        final Team team2 = new Team(1, "SCALA");
        final Team team3 = new Team(2, "TEKNA");


        final Block block = new Block(0, team, egor);
        final Block block2 = new Block(1, team, sham);
        final Block block3 = new Block(2, team, sham);

        final Chain.Element element1 = new Chain.Element(block.id, null, List.of(block2.id));

        final List<Chain.Element> list = List.of(element1);
        final Chain chain = new Chain(list);

        final Task task = new Task(0, "Super important task", chain);


        SimpleDirectedGraph<String, DefaultEdge> directedGraph
                = new SimpleDirectedGraph<>(DefaultEdge.class);
//        directedGraph.addVertex("v1");
//        directedGraph.addVertex("v2");
//        directedGraph.addVertex("v3");
//        directedGraph.addEdge("v1", "v2");

    }
}
