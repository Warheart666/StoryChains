package ru;

import lombok.AllArgsConstructor;

import java.util.List;


@AllArgsConstructor
public class Chain {

    final List<Element> blocks;


    @AllArgsConstructor
    public static final class Element {
        final Long blockId;
        final Long prevBlock;
        final List<Long> nextBlock;
    }


}
