import java.util.ArrayList;
import java.util.List;

public class toDoList {
    private List<String> tasks;

    public toDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public List<String> getTasks() {
        return tasks;
    }
}