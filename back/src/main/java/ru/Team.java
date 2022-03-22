package ru;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@ToString
@Entity
@EqualsAndHashCode
@NoArgsConstructor
public class Team {

    @Id
    long id;
    String name;
}
