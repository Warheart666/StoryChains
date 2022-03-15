package ru;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
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

        final Chain.Element element1 = new Chain.Element(block.id, null, List.of(block2.id));
        final Chain.Element element2 = new Chain.Element(block2.id, block.id, List.of(block3.id));
        final Chain.Element element3 = new Chain.Element(block3.id, null, List.of(block2.id));
        final Chain.Element element4 = new Chain.Element(block2.id, block2.id, List.of(block.id));

        final List<Chain.Element> list = List.of(element1, element2, element3, element4);
        final Chain chain = new Chain(list);

        return ResponseEntity.ok(new Task(0, "Super important task", chain));
    }


}
