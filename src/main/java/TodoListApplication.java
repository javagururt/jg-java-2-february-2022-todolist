import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TodoListApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to ToDo List!");
        System.out.println("Please make a choice:");

        int todoSequenceId = 0;
        Map<Integer, ToDoEntity> repository = new HashMap<>();

        while (true) {
            try {
                var scanner = new Scanner(System.in);
                System.out.println("1. Add");
                System.out.println("2. Get All");
                System.out.println("3. Delete");

                var userInput = Integer.parseInt(scanner.nextLine());

                if (userInput == 1) {
                    System.out.println("Please enter todo name:");
                    var name = scanner.nextLine();
                    System.out.println("Please enter todo description:");
                    var description = scanner.nextLine();
                    var todo = new ToDoEntity();
                    todo.setName(name);
                    todo.setDescription(description);

                    todo.setId(todoSequenceId);
                    todoSequenceId++;

                    repository.put(todo.getId(), todo);
                } else if (userInput == 2) {
                    repository.entrySet().stream()
                            .map(Map.Entry::getValue)
                            .forEach(System.out::println);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
