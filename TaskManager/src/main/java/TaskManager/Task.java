package TaskManager;
import java.util.Date;

public class Task {
	private String title;
	private String description;
	private Date expirationDate;
	private Priority priority;
	
	public Task (String title, String description, Date expirationDate, Priority priority) {
		this.title = title;
		this.description = description;
		this.expirationDate = expirationDate;
		this.priority = priority;	
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Date getExpirationDate() {
		return this.expirationDate;
	}
	
	public Priority getPriority() {
		return this.priority;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
}
