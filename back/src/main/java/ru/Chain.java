package ru;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class Chain {

    final List<Edge> blocks;


    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    @ToString
    @EqualsAndHashCode
    public static final class Edge {
        @Id
        private long id;
        @OneToOne
        private Block sourceBlock;
        @OneToOne
        private Block prevBlock;
        @ManyToMany
        private List<Block> targetBlocks;
    }


}
