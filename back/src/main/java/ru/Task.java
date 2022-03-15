package ru;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Task {

    final long id;
    final String name;
    final Chain chain;

}
