package ru;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class Block {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Team team;
    @OneToOne
    private Owner owner;
}
