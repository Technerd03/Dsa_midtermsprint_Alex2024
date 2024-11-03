public class Task {
    private String description;
    private boolean isCompleted;

    // initialize a new task
    public Task(String description) {
        this.description = description;
        this.isCompleted = false; // All tasks start as pending
    }

    // Marks the task as completed
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Returns task description
    public String getDescription() {
        return description;
    }

    // Returns task completion status
    public boolean isCompleted() {
        return isCompleted;
    }

    // Displays task details
    @Override
    public String toString() {
        return description + " - " + (isCompleted ? "Completed" : "Pending");
    }
}