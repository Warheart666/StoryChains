package ru;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@ToString
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@RequiredArgsConstructor
public class Team {

    @Id
    @GeneratedValue
    long id;

    @NonNull
    String name;
}
