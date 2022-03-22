package ru.reps;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.Team;

@Repository
public interface TeamRep extends CrudRepository<Team, Long> {
}
