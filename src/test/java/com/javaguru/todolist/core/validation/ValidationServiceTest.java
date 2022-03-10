package com.javaguru.todolist.core.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import com.javaguru.todolist.dto.AddToDoRequest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ValidationServiceTest {

    @Mock
    private ValidationRule validationRule;

    @Captor
    private ArgumentCaptor<AddToDoRequest> addToDoRequestArgumentCaptor;

    private ValidationService validationService;

    @BeforeEach
    void setUp() {
        validationService = new ValidationService(List.of(validationRule));
    }

    @Test
    void shouldMapErrors() {
        doThrow(new ValidationException("TEST_EXCEPTION")).when(validationRule).validate(any());
        var request = new AddToDoRequest();
        request.setName("TEST_NAME");
        var actual = validationService.validate(request);

//        var requestToValidate = new AddToDoRequest();
//        requestToValidate.setName("TEST_NAME");
//        verify(validationRule).validate(requestToValidate);

        verify(validationRule).validate(addToDoRequestArgumentCaptor.capture());
        var capturedRequest = addToDoRequestArgumentCaptor.getValue();

        assertNotNull(capturedRequest);
        assertEquals("TEST_NAME", capturedRequest.getName());

        assertNotNull(actual);
        assertFalse(actual.isEmpty());
        assertEquals(actual.get(0), new CoreError("TEST_EXCEPTION"));
    }

}