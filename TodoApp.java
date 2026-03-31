import java.util.*;

class Task {
    int id;
    String title;

    Task(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public String toString() {
        return id + ": " + title;
    }
}

public class TodoApp {
    static List<Task> tasks = new ArrayList<>();
    static int counter = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- TODO APP ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String title = sc.nextLine();
                    tasks.add(new Task(counter++, title));
                    System.out.println("Task added!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        for (Task t : tasks)
                            System.out.println(t);
                    }
                    break;

                case 3:
                    System.out.print("Enter task ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    boolean found = false;

                    for (Task t : tasks) {
                        if (t.id == uid) {
                            System.out.print("Enter new task: ");
                            t.title = sc.nextLine();
                            System.out.println("Task updated!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Task not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int did = sc.nextInt();

                    boolean removed = tasks.removeIf(t -> t.id == did);

                    if (removed) {
                        System.out.println("Task deleted!");
                    } else {
                        System.out.println("Task not found!");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}