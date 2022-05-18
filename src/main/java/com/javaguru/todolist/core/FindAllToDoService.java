package com.javaguru.todolist.core;

import com.javaguru.todolist.domain.ToDoEntity;
import com.javaguru.todolist.dto.SearchToDoRequest;
import com.javaguru.todolist.dto.ToDoDTO;
import com.javaguru.todolist.repository.ToDoRepository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class FindAllToDoService {

    private final ToDoRepository repository;

    public List<ToDoDTO> findAllBy(SearchToDoRequest request) {
        var specifications = getSearchSpecifications(request);
//        var specific = specifications.get(0).and(specifications.get(1).and(specifications.get(2));
        var entities = specifications.stream()
                .reduce(Specification::and)
                .map(repository::findAll)
                .orElseGet(repository::findAll);

        return entities.stream()
                .map(this::convert)
                .toList();
    }

    private List<Specification<ToDoEntity>> getSearchSpecifications(SearchToDoRequest request) {
        var specifications = new ArrayList<Specification<ToDoEntity>>();
        var name = request.getName();
        var description = request.getDescription();
        var userId = request.getUserId();
        if (name != null) {
            Specification<ToDoEntity> specification = (root, query, builder) -> builder.equal(root.get("name"), name);
            var specification2 = new SearchToDoByNameSpecification(name);
            specifications.add(specification2);
        }
        if (description != null) {
            specifications.add(new SearchToDoByDescriptionSpecification(description));
        }
        if (userId != null) {
            specifications.add(new SearchToDoByUserIdSpecification(userId));
        }
        return specifications;
    }

    public List<ToDoDTO> findAll() {
        return repository.findAll().stream()
                .map(this::convert)
                .toList();
    }

    public List<ToDoDTO> findAllByUserName(String username) {
        return repository.findAllByUserName(username).stream()
                .map(this::convert)
                .toList();
    }

    private ToDoDTO convert(ToDoEntity entity) {
        return new ToDoDTO(entity.getId(), entity.getName(), entity.getDescription());
    }
}
