package console;

import core.FindAllToDoService;

public class FindAllToDoUIAction implements UIAction {

    private final FindAllToDoService findAllToDoService;

    public FindAllToDoUIAction(FindAllToDoService findAllToDoService) {
        this.findAllToDoService = findAllToDoService;
    }

    @Override
    public void execute() {
        var response = findAllToDoService.findAll();
        System.out.println(response);
    }

    @Override
    public String getActionName() {
        return "Find All";
    }
}
