package ru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.reps.*;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories
public class App implements CommandLineRunner {

    @Autowired
    BlockRep blockRep;

    @Autowired
    OwnerRep ownerRep;

    @Autowired
    TeamRep teamRep;

    @Autowired
    EdgeRep edgeRep;

    @Autowired
    TaskRep taskRep;

    @Override
    @Transactional
    public void run(String... args) {
        final Owner sham = new Owner("Шамиль");
        final Owner egor = new Owner("Егор");

//        ownerRep.save(sham);
//        ownerRep.save(egor);

        final Team team = new Team("Sbol-PRO");
        final Team team2 = new Team("SCALA");
        final Team team3 = new Team("TEKNA");

//        teamRep.save(team);
//        teamRep.save(team2);
//        teamRep.save(team3);


        final Block block = new Block(team, egor);
        final Block block2 = new Block(team2, sham);
        final Block block3 = new Block(team3, sham);


//        blockRep.save(block);
//        blockRep.save(block2);
//        blockRep.save(block3);


        final Chain.Edge edge1 = new Chain.Edge(block, null, List.of(block2));
        final Chain.Edge edge2 = new Chain.Edge(block2, block, List.of(block3));
        final Chain.Edge edge3 = new Chain.Edge(block3, block2, List.of(block2));
        final Chain.Edge edge4 = new Chain.Edge(block2, block3, List.of(block));


        final List<Chain.Edge> list = List.of(edge1, edge2, edge3, edge4);

//        final Iterable<Chain.Edge> edges = edgeRep.saveAll(list);

        final Task norm_task = new Task("norm task", new Chain(list));
        taskRep.save(norm_task);


    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
