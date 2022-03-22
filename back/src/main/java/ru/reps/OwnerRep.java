package ru.reps;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.Owner;

@Repository
public interface OwnerRep extends CrudRepository<Owner, Long> {
}
