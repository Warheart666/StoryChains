package ru.reps;

import org.springframework.data.repository.CrudRepository;
import ru.Chain;

public interface EdgeRep extends CrudRepository<Chain.Edge, Long> {
}
