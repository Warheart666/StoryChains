package ru;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@ToString
public class Task {

    @Id
    private long id;
    private String name;

    @Transient
    private Chain chain;

}
