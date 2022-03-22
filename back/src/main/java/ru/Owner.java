package ru;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
@EqualsAndHashCode
public class Owner {

    @Id
    private long id;
    private String name;
}
