package ru.reps;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.Block;

@Repository
public interface BlockRep extends CrudRepository<Block, Long> {
}
