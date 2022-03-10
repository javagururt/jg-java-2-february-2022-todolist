package com.javaguru.todolist.core;

import com.javaguru.todolist.dto.AddToDoRequest;

class TestDtoFactory {

    public static AddToDoRequest createRequest() {
        var request = new AddToDoRequest();
        request.setName("TEST_NAME");
        request.setDescription("TEST_DESCRIPTION");
        return request;
    }

    public static AddToDoRequest createRequestWithoutName() {
        var request = new AddToDoRequest();
        request.setDescription("TEST_DESCRIPTION");
        return request;
    }

    public static AddToDoRequest createRequestWithoutDescription() {
        var request = new AddToDoRequest();
        request.setName("TEST_NAME");
        return request;
    }
}
