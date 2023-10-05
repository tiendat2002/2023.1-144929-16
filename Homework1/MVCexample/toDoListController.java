import java.util.List;
import java.util.Scanner;

public class ToDoListController {
    private ToDoList model;
    private ToDoListView view;
    private Scanner scanner;

    public ToDoListController(ToDoList model, ToDoListView view) {
        this.model = model;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            view.displayTasks(model.getTasks());

            System.out.println("Options:");
            System.out.println("1. Add Task");
            System.out.println("2. Quit");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter your choice: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void addTask() {
        System.out.print("Enter a task: ");
        scanner.nextLine();  // Consume the newline character
        String task = scanner.nextLine();
        model.addTask(task);
    }

    public static void main(String[] args) {
        ToDoList model = new ToDoList();
        ToDoListView view = new ToDoListView();
        ToDoListController controller = new ToDoListController(model, view);
        controller.run();
    }
}
