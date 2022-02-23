package core;

import core.validation.ValidationService;
import domain.ToDoEntity;
import dto.AddToDoRequest;
import dto.AddToDoResponse;
import repository.ToDoRepository;

public class AddToDoService {

    private final ToDoRepository repository;
    private final ValidationService validationService;

    public AddToDoService(ToDoRepository repository,
                          ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public AddToDoResponse add(AddToDoRequest request) {
        System.out.println("Received request: " + request);
        var validationResult = validationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new AddToDoResponse();
            response.setErrors(validationResult);
            return response;
        }
        var entity = convert(request);
        var createdEntity = repository.save(entity);
        System.out.println("Successfully saved: " + createdEntity);
        var response = new AddToDoResponse();
        response.setCreatedToDoId(createdEntity.getId());
        System.out.println("Sending response: " + response);
        return response;
    }

    private ToDoEntity convert(AddToDoRequest request) {
        ToDoEntity entity = new ToDoEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }
}
