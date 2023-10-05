import java.util.List;

public class ToDoListView {
    public void displayTasks(List<String> tasks) {
        System.out.println("To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}