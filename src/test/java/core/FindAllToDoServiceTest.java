package core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import domain.ToDoEntity;
import dto.FindAllToDoResponse;
import dto.ToDoDTO;
import repository.ToDoRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FindAllToDoServiceTest {

    @Mock
    private ToDoRepository repository;

    @InjectMocks
    private FindAllToDoService findAllToDoService;

    @Test
    void shouldFindAllToDos() {
        var returnResult = entities();
        when(repository.findAll()).thenReturn(returnResult);

        var result = findAllToDoService.findAll();

        var expectedResult = response();

        assertEquals(expectedResult, result);
    }

    private List<ToDoEntity> entities() {
        var returnEntity = new ToDoEntity();
        returnEntity.setId(1);
        returnEntity.setDescription("Test description");
        returnEntity.setName("Test Name");
        return List.of(returnEntity);
    }

    private FindAllToDoResponse response() {
        var dto = new ToDoDTO(1, "Test Name", "Test description");
        return new FindAllToDoResponse(List.of(dto));
    }
}