package com.javaguru.todolist.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import com.javaguru.todolist.core.validation.CoreError;
import com.javaguru.todolist.core.validation.ValidationService;
import com.javaguru.todolist.domain.ToDoEntity;
import com.javaguru.todolist.dto.AddToDoResponse;
import com.javaguru.todolist.repository.HibernateRepository;

import static com.javaguru.todolist.core.TestDtoFactory.createRequest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddToDoServiceTest {


    @Mock
    private HibernateRepository repository;

    @Mock
    private ValidationService validationService;


    @InjectMocks
    private AddToDoService addToDoService;


    @Test
    void shouldSuccessfullySaveToDo() {
        var request = createRequest();
        when(validationService.validate(request)).thenReturn(List.of());
        when(repository.save(entity(null))).thenReturn(entity(1001));

        var result = addToDoService.add(request);

        verify(repository).save(any());
        verify(validationService).validate(any());

        var expected = new AddToDoResponse();
        expected.setErrors(null);
        expected.setCreatedToDoId(1001);

        assertEquals(expected, result);
    }

    @Test
    void shouldReturnErrors() {
        var request = createRequest();
        when(validationService.validate(request)).thenReturn(List.of(new CoreError("TEST ERROR")));

        var result = addToDoService.add(request);

        verify(validationService).validate(any());
        verifyNoInteractions(repository);

        var expected = new AddToDoResponse();
        expected.setErrors(List.of(new CoreError("TEST ERROR")));
        expected.setCreatedToDoId(null);

        assertEquals(expected, result);
    }

    private ToDoEntity entity(Integer id) {
        var entity =  new ToDoEntity();
        entity.setId(id);
        entity.setName("TEST_NAME");
        entity.setDescription("TEST_DESCRIPTION");
        return entity;
    }
}