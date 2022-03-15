package ru;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Block {

    final long id;
    final Team team;
    final Owner owner;
//    Task task; //todo тут подумать.
}
