package core;

import java.util.List;

import domain.ToDoEntity;
import repository.ToDoRepository;

public class FindAllToDoService {

    private final ToDoRepository repository;

    public FindAllToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public List<ToDoEntity> findAll() {
        return repository.findAll();
    }
}
