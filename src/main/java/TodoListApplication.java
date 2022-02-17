import java.util.Arrays;
import java.util.List;

import console.AddToDoUIAction;
import console.FindAllToDoUIAction;
import console.UIMenu;
import core.AddToDoService;
import core.FindAllToDoService;
import core.validation.ToDoDescriptionMaxLengthValidationRule;
import core.validation.ToDoDescriptionNullValidationRule;
import core.validation.ToDoNameMaxLengthValidationRule;
import core.validation.ToDoNameMinLengthValidationRule;
import core.validation.ToDoNameNullValidationRule;
import core.validation.ValidationService;
import repository.ArrayListToDoRepository;

public class TodoListApplication {

    public static void main(String[] args) {
        var repository = new ArrayListToDoRepository();
        var validationRules = List.of(
                new ToDoNameNullValidationRule(),
                new ToDoNameMinLengthValidationRule(),
                new ToDoNameMaxLengthValidationRule(),
                new ToDoDescriptionNullValidationRule(),
                new ToDoDescriptionMaxLengthValidationRule()
        );
        var validationService = new ValidationService(validationRules);

        var addService = new AddToDoService(repository, validationService);
        var findAllService = new FindAllToDoService(repository);

        var actions = Arrays.asList(
                new AddToDoUIAction(addService),
                new FindAllToDoUIAction(findAllService)
        );

        var uiMenu = new UIMenu(actions);
        uiMenu.startUI();
    }
}
