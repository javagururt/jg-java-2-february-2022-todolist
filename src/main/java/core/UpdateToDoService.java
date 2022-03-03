package core;

import dto.UpdateToDoRequest;
import repository.ToDoRepository;

public class UpdateToDoService {

    private final ToDoRepository repository;

    public UpdateToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public void update(UpdateToDoRequest request) {
        // find by id
        // update

    }
}
