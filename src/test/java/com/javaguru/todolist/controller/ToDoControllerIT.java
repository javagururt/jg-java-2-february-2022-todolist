package com.javaguru.todolist.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ToDoControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateToDo() throws Exception {
        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createToDoJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.createdToDoId").value("1"));
    }

    @Test
    void shouldGetById() throws Exception {
        mockMvc.perform(post("/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createToDoJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.createdToDoId").value("1"));

        mockMvc.perform(get("/todos/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(createToDoJSON()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.todo.id").value("1"))
                .andExpect(jsonPath("$.todo.name").value("test name"))
                .andExpect(jsonPath("$.todo.description").value("test description"));
    }

    private String createToDoJSON() throws JSONException {
        return new JSONObject()
                .put("name", "test name")
                .put("description", "test description")
                .toString();
    }
    /*
    {
    "name" : "test name",
    "description : "test description"
    }
     */
}