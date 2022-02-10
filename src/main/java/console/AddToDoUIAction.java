package console;

import java.util.Scanner;

import core.AddToDoService;
import domain.ToDoEntity;

public class AddToDoUIAction implements UIAction {

    private final AddToDoService addTaskService;

    public AddToDoUIAction(AddToDoService addTaskService) {
        this.addTaskService = addTaskService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter todo name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter todo description: ");
        String description = scanner.nextLine();

        ToDoEntity entity = new ToDoEntity();
        entity.setName(name);
        entity.setDescription(description);

        addTaskService.add(entity);
    }

    @Override
    public String getActionName() {
        return "Add ToDo";
    }
}
