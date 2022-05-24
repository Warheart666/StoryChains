package ru;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.reps.EdgeRep;
import ru.reps.TaskRep;

@RestController
@CrossOrigin
public class Controller {

    @Autowired
    EdgeRep edgeRep;

    @Autowired
    TaskRep taskRep;

    @GetMapping
    public ResponseEntity<Task> getTask() {
//        final List<Chain.Edge> all = edgeRep.findAll();

        return ResponseEntity.ok(taskRep.findAllByOrderById().iterator().next());
    }


}
