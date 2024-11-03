import java.util.Scanner;

public class Main {
    private static final int MAX_USERS = 10; // Maximum number of users
    private static User[] users = new User[MAX_USERS];
    private static int userCount = 0;

    // Adds a new user to the system, ensuring unique user names
    public static void addUser(String name) {
        // throw error if user already exists
        if (isUserExists(name)) {
            System.out.println("Error: A user with the name '" + name + "' already exists.");
            return;
        }

        // Check if there's room to add a new user
        if (userCount < MAX_USERS) {
            users[userCount++] = new User(name);
            System.out.println("User '" + name + "' added.");
        } else {
            System.out.println("User limit reached. Cannot add more users.");
        }
    }

    // Checks if a user with the given name already exists
    public static boolean isUserExists(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    // Finds a user by name
    public static User findUser(String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(name)) {
                return users[i];
            }
        }
        System.out.println("User '" + name + "' not found.");
        return null;
    }

    // Main selection menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;

        System.out.println("Welcome to the To-Do List Manager!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add User");
            System.out.println("2. Add Task");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    addUser(userName);
                    break;
                case "2":
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    User user = findUser(userName);
                    if (user != null) {
                        System.out.print("Enter task description: ");
                        String taskDescription = scanner.nextLine();
                        user.addTask(taskDescription);
                    }
                    break;
                case "3":
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    user = findUser(userName);
                    if (user != null) {
                        System.out.print("Enter task description to mark as completed: ");
                        String taskDescription = scanner.nextLine();
                        user.markTaskAsCompleted(taskDescription);
                    }
                    break;
                case "4":
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    user = findUser(userName);
                    if (user != null) {
                        user.printTasks();
                    }
                    break;
                case "5":
                    System.out.println("Exiting To-Do List Manager. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}