package core;

import domain.ToDoEntity;
import repository.ToDoRepository;

public class AddToDoService {

    private final ToDoRepository repository;

    public AddToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public void add(ToDoEntity entity) {
        repository.save(entity);
    }
}
