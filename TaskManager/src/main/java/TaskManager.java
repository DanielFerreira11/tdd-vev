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
}