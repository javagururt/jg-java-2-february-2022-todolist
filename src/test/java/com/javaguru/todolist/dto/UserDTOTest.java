package com.javaguru.todolist.dto;

import org.junit.jupiter.api.Test;

class UserDTOTest {


    @Test
    void name() {
        var user = new UserDTO();
        var user2 = new UserDTO("a", "b", 1);
        var userBuilder = UserDTO.builder()
                .name("a")
                .age(3);
        //....
        var name = "a";
        var age = 3;

        String lastName;

        if (user != null) {
            lastName = "b";
            userBuilder.lastname("b");
        } else {
            lastName = "c";
            userBuilder.lastname("c");
        }

        var user3 = userBuilder.build();

        var user4 = new UserDTO(name, lastName, age);
    }
}