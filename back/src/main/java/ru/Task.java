package ru;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class Task {

    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @NonNull
    private Chain chain;


}
