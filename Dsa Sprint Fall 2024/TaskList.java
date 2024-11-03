public class TaskList {
    private class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    // Adds a task to the linked list
    public void addTask(String description) {
        Task newTask = new Task(description);
        Node newNode = new Node(newTask);
        
        // Add new task at the end of the list
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task '" + description + "' added to the list.");
    }

    // Marks a task as completed by its description
    public boolean markTaskAsCompleted(String description) {
        Node current = head;
        while (current != null) {
            if (current.task.getDescription().equals(description) && !current.task.isCompleted()) {
                current.task.markAsCompleted();
                System.out.println("Task '" + description + "' marked as completed.");
                return true;
            }
            current = current.next;
        }
        System.out.println("Task '" + description + "' not found or already completed.");
        return false;
    }

    // Displays all tasks in the list with their statuses
    public void printTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }
}