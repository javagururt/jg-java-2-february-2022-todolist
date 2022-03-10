package com.javaguru.todolist.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RandomNameGeneratorTest {

    @Spy
    private RandomNameGenerator generator = new RandomNameGenerator();

    @Test
    void shouldReturnGeneratedNumber() {
        when(generator.getNumber()).thenReturn(100);
        var result = generator.generateRandomName();
        assertEquals("100", result);
    }
}