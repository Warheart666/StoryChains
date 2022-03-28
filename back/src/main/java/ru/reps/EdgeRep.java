package ru.reps;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import ru.Chain;

import java.util.List;

public interface EdgeRep extends CrudRepository<Chain.Edge, Long> {

    @Override
    @NonNull
    List<Chain.Edge> findAll();

}
