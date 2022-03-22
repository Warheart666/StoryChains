package ru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.reps.BlockRep;
import ru.reps.EdgeRep;
import ru.reps.OwnerRep;
import ru.reps.TeamRep;

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

    @Override
    @Transactional
    public void run(String... args) {
        final Owner sham = new Owner(0, "Шамиль");
        final Owner egor = new Owner(1, "Егор");

        ownerRep.save(sham);
        ownerRep.save(egor);

        final Team team = new Team(0, "Sbol-PRO");
        final Team team2 = new Team(1, "SCALA");
        final Team team3 = new Team(2, "TEKNA");

        teamRep.save(team);
        teamRep.save(team2);
        teamRep.save(team3);


        final Block block = new Block(0, team, egor);
        final Block block2 = new Block(1, team2, sham);
        final Block block3 = new Block(2, team3, sham);


        blockRep.save(block);
        blockRep.save(block2);
        blockRep.save(block3);


        final Chain.Edge edge1 = new Chain.Edge(0, block, null, List.of(block2));
        final Chain.Edge edge2 = new Chain.Edge(1, block2, block, List.of(block3));
        final Chain.Edge edge3 = new Chain.Edge(2, block3, null, List.of(block2));
        final Chain.Edge edge4 = new Chain.Edge(3, block2, block3, List.of(block));


        final List<Chain.Edge> list = List.of(edge1, edge2);

        edgeRep.saveAll(list);

    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
