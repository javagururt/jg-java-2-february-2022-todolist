package lv.javaguru.java2.library.console_ui;

import java.util.Scanner;

import lv.javaguru.java2.library.core.requests.AddBookRequest;
import lv.javaguru.java2.library.core.responses.AddBookResponse;
import lv.javaguru.java2.library.core.services.AddBookService;
import lv.javaguru.java2.library.dependency_injection.DIComponent;
import lv.javaguru.java2.library.dependency_injection.DIDependency;

@DIComponent
public class AddBookUIAction implements UIAction {

	@DIDependency private AddBookService addBookService;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter book title: ");
		String bookTitle = scanner.nextLine();
		System.out.println("Enter book author: ");
		String bookAuthor = scanner.nextLine();
		AddBookRequest request = new AddBookRequest(bookTitle, bookAuthor);
		AddBookResponse response = addBookService.execute(request);

		if (response.hasErrors()) {
			response.getErrors().forEach(coreError ->
				System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
			);
		} else {
			System.out.println("New book id was: " + response.getNewBook().getId());
			System.out.println("Your book was added to list.");
		}
	}

}