package TaskManager;
import java.util.*;

public class TaskManager {
	private final List<Task> tasks;
	
	public TaskManager () {
		this.tasks = new ArrayList<>();
	}
	
	public List<Task> getTasks() {
		return this.tasks;
	}
	
	public void addTask(Task task) {
		this.tasks.add(task);
	}
	
	public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            this.tasks.remove(index);
        } else {
            System.out.println("Índice inválido. A tarefa não foi removida.");
        }
    }
	
	public void updateTask(int index, Task updatedTask) {
        if (index >= 0 && index < tasks.size()) {
            this.tasks.set(index, updatedTask);
        } else {
            System.out.println("Índice inválido. A tarefa não foi atualizada.");
        }
    }
	
	public void sortByDueDateAndPriority() {
        Collections.sort(tasks, Comparator.comparing(Task::getExpirationDate)
                                           .thenComparing(Task::getPriority));
    }
}