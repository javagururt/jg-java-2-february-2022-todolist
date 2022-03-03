package console;

import java.util.Scanner;

import core.GetToDoByIdService;
import core.UpdateToDoService;
import dto.UpdateToDoRequest;

public class UpdateToDoUIAction implements UIAction {

    private final GetToDoByIdService getToDoByIdService;
    private final UpdateToDoService updateToDoService;

    public UpdateToDoUIAction(GetToDoByIdService getToDoByIdService, UpdateToDoService updateToDoService) {
        this.getToDoByIdService = getToDoByIdService;
        this.updateToDoService = updateToDoService;
    }

    @Override
    public void execute() {
        var scanner = new Scanner(System.in);
        System.out.println("Please enter ToDo id: ");
        var id = Integer.valueOf(scanner.nextLine());
        var foundToDoResponse = getToDoByIdService.getById(id);
        var todo = foundToDoResponse.getTodo();
        var name = scanner.nextLine();
        var description = scanner.nextLine();

        var updateRequest = new UpdateToDoRequest();
        updateRequest.setId(todo.getId());
        var updatedName = getUpdatedValue(name, todo.getName()) ;
        var updatedDescription = getUpdatedValue(description, todo.getDescription());

        updateRequest.setName(updatedName);
        updateRequest.setDescription(updatedDescription);

        updateToDoService.update(updateRequest);
    }

    public String getUpdatedValue(String newValue, String oldValue) {
        return newValue.equals("") ? oldValue : newValue;
    }

    public String getUpdatedValueLegacy(String newValue, String oldValue) {
        if (newValue.equals("")) {
            return oldValue;
        } else {
            return newValue;
        }
    }

    @Override
    public String getActionName() {
        return "Update ToDo";
    }
}
