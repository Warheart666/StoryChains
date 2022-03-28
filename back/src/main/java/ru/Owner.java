package ru;

import lombok.*;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class Owner {

    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private String name;


}
