public class User {
    private String name;
    private TaskList taskList;

    // Constructor to initialize a user with a name and an empty task list
    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    // Returns user's name
    public String getName() {
        return name;
    }

    // Adds a task to user's to-do list
    public void addTask(String description) {
        taskList.addTask(description);
    }

    // Marks a task as completed in the user's to-do list
    public void markTaskAsCompleted(String description) {
        taskList.markTaskAsCompleted(description);
    }

    // Prints all tasks in user's to-do list
    public void printTasks() {
        System.out.println("Tasks for " + name + ":");
        taskList.printTasks();
    }
}
