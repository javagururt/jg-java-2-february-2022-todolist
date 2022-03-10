package com.javaguru.todolist;

import com.javaguru.todolist.config.AppConfig;
import com.javaguru.todolist.console.UIMenu;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TodoListApplication {

    public static void main(String[] args) {
        try {
            var context = new AnnotationConfigApplicationContext(AppConfig.class);
            var uiMenu = context.getBean(UIMenu.class);
            uiMenu.startUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
