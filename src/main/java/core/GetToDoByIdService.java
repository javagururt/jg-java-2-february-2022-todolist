package core;

import dto.GetByIdToDoResponse;
import repository.ToDoRepository;

public class GetToDoByIdService {

    private final ToDoRepository toDoRepository;

    public GetToDoByIdService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public GetByIdToDoResponse getById(Integer id) {
        //find by id
        throw new UnsupportedOperationException("Not implemented");
    }
}
