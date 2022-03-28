package ru;


import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode
@RequiredArgsConstructor
public class Block {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @NonNull
    private Team team;
    @OneToOne(cascade = CascadeType.ALL)
    @NonNull
    private Owner owner;
}
