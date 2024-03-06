import java.util.Date;

public class Task {
	String title;
	String description;
	Date expirationDate;
	Integer priority;
	
	public Task (String title, String description, Date expirationDate, Integer priority	) {
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
	
	public Integer getPriority() {
		return this.priority;
	}
}
