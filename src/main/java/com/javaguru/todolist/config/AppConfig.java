package com.javaguru.todolist.config;

import com.javaguru.todolist.console.UIAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.javaguru")
public class AppConfig {

    @Autowired
    private UIAction addToDoUIAction;

    @Autowired
    private UIAction exitAction;

    @Autowired
    private UIAction findAllToDoUIAction;

    @Bean(name = "actionsWithoutUpdate")
    public List<UIAction> uiActions() {
        return List.of(
                exitAction,
                findAllToDoUIAction,
                addToDoUIAction
        );
    }
}
