import java.util.Arrays;

import console.AddToDoUIAction;
import console.FindAllToDoUIAction;
import console.UIMenu;
import core.AddToDoService;
import core.FindAllToDoService;
import repository.ArrayListToDoRepository;
import repository.FileToDoRepository;

public class TodoListApplication {

    public static void main(String[] args) {
        var repository = new FileToDoRepository();

        var addService = new AddToDoService(repository);
        var findAllService = new FindAllToDoService(repository);

        var actions = Arrays.asList(
                new AddToDoUIAction(addService),
                new FindAllToDoUIAction(findAllService)
        );

        var uiMenu = new UIMenu(actions);
        uiMenu.startUI();
    }
}
