package ru.reps;

import org.springframework.data.repository.CrudRepository;
import ru.Task;

public interface TaskRep extends CrudRepository<Task, Long> {
}
