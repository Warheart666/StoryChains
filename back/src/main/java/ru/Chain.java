package ru;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@AllArgsConstructor
@Getter
public class Chain {

    final List<Element> blocks;


    @AllArgsConstructor
    @Getter
    public static final class Element {
        final Long blockId;
        final Long prevBlock;
        final List<Long> nextBlock;
    }


}
