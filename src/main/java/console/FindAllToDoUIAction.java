package console;

import core.FindAllToDoService;

public class FindAllToDoUIAction implements UIAction {

    private final FindAllToDoService findAllToDoService;

    public FindAllToDoUIAction(FindAllToDoService findAllToDoService) {
        this.findAllToDoService = findAllToDoService;
    }

    @Override
    public void execute() {
        findAllToDoService.findAll()
                .forEach(System.out::println);
    }

    @Override
    public String getActionName() {
        return "Find All";
    }
}
