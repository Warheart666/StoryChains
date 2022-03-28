package ru;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
public class Chain {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Edge> blocks;


    public Chain(List<Edge> blocks) {
        this.blocks = blocks;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    @ToString
    @EqualsAndHashCode
    public static final class Edge {
        @Id
        @GeneratedValue
        private long id;
        @OneToOne(cascade = CascadeType.ALL)
        @NonNull
        private Block sourceBlock;

        @OneToOne(cascade = CascadeType.ALL)
        private Block prevBlock;

        @ManyToMany(cascade = CascadeType.ALL)
        @NonNull
        private List<Block> targetBlocks;


        public Edge(@NonNull Block sourceBlock, Block prevBlock, @NonNull List<Block> targetBlocks) {
            this.sourceBlock = sourceBlock;
            this.prevBlock = prevBlock;
            this.targetBlocks = targetBlocks;
        }
    }


}
