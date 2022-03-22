package ru;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {

    @GetMapping
    public ResponseEntity<Task> getTask() {
        final Owner sham = new Owner(0, "Шамиль");
        final Owner egor = new Owner(1, "Егор");

        final Team team = new Team(0, "Sbol-PRO");
        final Team team2 = new Team(1, "SCALA");
        final Team team3 = new Team(2, "TEKNA");


        final Block block = new Block(0, team, egor);
        final Block block2 = new Block(1, team2, sham);
        final Block block3 = new Block(2, team3, sham);

        final Chain.Edge edge1 = new Chain.Edge(0, block, null, List.of(block2));
        final Chain.Edge edge2 = new Chain.Edge(1, block2, block, List.of(block3));
        final Chain.Edge edge3 = new Chain.Edge(2, block3, null, List.of(block2));
        final Chain.Edge edge4 = new Chain.Edge(3, block2, block2, List.of(block));


        final List<Chain.Edge> list = List.of(edge1, edge2, edge3, edge4);
        final Chain chain = new Chain(list);


        return ResponseEntity.ok(new Task(0, "Super important task", chain));
    }


}
