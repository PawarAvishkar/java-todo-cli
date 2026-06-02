import java.util.ArrayList;
import java.util.Scanner;

public class NotepadTodoList {
    private static ArrayList<String> notepad = new ArrayList<>();
    private static ArrayList<Task> todoList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static class Task {
        private String description;
        private boolean isCompleted;

        public Task(String description) {
            this.description = description;
            this.isCompleted = false;
        }

        public String getDescription() {
            return description;
        }

        public boolean isCompleted() {
            return isCompleted;
        }

        public void setCompleted(boolean completed) {
            isCompleted = completed;
        }

        @Override
        public String toString() {
            return (isCompleted ? "[X] " : "[ ] ") + description;
        }
    }

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n=== Notepad & To-Do List ===");
            System.out.println("1. Notepad (Notes/Pages)");
            System.out.println("2. To-Do List");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    notepadMenu();
                    break;
                case "2":
                    todoMenu();
                    break;
                case "3":
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void notepadMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Notepad ---");
            System.out.println("1. Add Page (Note)");
            System.out.println("2. View Pages");
            System.out.println("3. Delete Page");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter note content: ");
                    String note = scanner.nextLine();
                    notepad.add(note);
                    System.out.println("Note added successfully!");
                    break;
                case "2":
                    if (notepad.isEmpty()) {
                        System.out.println("Notepad is empty.");
                    } else {
                        System.out.println("\n--- Pages ---");
                        for (int i = 0; i < notepad.size(); i++) {
                            System.out.println((i + 1) + ". " + notepad.get(i));
                        }
                    }
                    break;
                case "3":
                    if (notepad.isEmpty()) {
                        System.out.println("Notepad is empty. Nothing to delete.");
                    } else {
                        System.out.println("\n--- Pages ---");
                        for (int i = 0; i < notepad.size(); i++) {
                            System.out.println((i + 1) + ". " + notepad.get(i));
                        }
                        System.out.print("Enter page number to delete: ");
                        try {
                            int num = Integer.parseInt(scanner.nextLine());
                            if (num > 0 && num <= notepad.size()) {
                                notepad.remove(num - 1);
                                System.out.println("Page deleted.");
                            } else {
                                System.out.println("Invalid page number.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                    }
                    break;
                case "4":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void todoMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- To-Do List ---");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. View Completed Tasks");
            System.out.println("4. View Remaining Tasks");
            System.out.println("5. Complete Task");
            System.out.println("6. Delete Task");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter task: ");
                    String taskDesc = scanner.nextLine();
                    todoList.add(new Task(taskDesc));
                    System.out.println("Task added successfully!");
                    break;
                case "2":
                    if (todoList.isEmpty()) {
                        System.out.println("To-Do List is empty.");
                    } else {
                        System.out.println("\n--- All Tasks ---");
                        for (int i = 0; i < todoList.size(); i++) {
                            System.out.println((i + 1) + ". " + todoList.get(i));
                        }
                    }
                    break;
                case "3":
                    boolean hasCompleted = false;
                    System.out.println("\n--- Completed Tasks ---");
                    for (int i = 0; i < todoList.size(); i++) {
                        if (todoList.get(i).isCompleted()) {
                            System.out.println((i + 1) + ". " + todoList.get(i));
                            hasCompleted = true;
                        }
                    }
                    if (!hasCompleted) {
                        System.out.println("No completed tasks.");
                    }
                    break;
                case "4":
                    boolean hasRemaining = false;
                    System.out.println("\n--- Remaining Tasks ---");
                    for (int i = 0; i < todoList.size(); i++) {
                        if (!todoList.get(i).isCompleted()) {
                            System.out.println((i + 1) + ". " + todoList.get(i));
                            hasRemaining = true;
                        }
                    }
                    if (!hasRemaining) {
                        System.out.println("No remaining tasks.");
                    }
                    break;
                case "5":
                    if (todoList.isEmpty()) {
                        System.out.println("To-Do List is empty. Nothing to complete.");
                    } else {
                        System.out.println("\n--- Tasks ---");
                        for (int i = 0; i < todoList.size(); i++) {
                            System.out.println((i + 1) + ". " + todoList.get(i));
                        }
                        System.out.print("Enter task number to mark as completed: ");
                        try {
                            int num = Integer.parseInt(scanner.nextLine());
                            if (num > 0 && num <= todoList.size()) {
                                todoList.get(num - 1).setCompleted(true);
                                System.out.println("Task marked as completed!");
                            } else {
                                System.out.println("Invalid task number.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                    }
                    break;
                case "6":
                    if (todoList.isEmpty()) {
                        System.out.println("To-Do List is empty. Nothing to delete.");
                    } else {
                        System.out.println("\n--- Tasks ---");
                        for (int i = 0; i < todoList.size(); i++) {
                            System.out.println((i + 1) + ". " + todoList.get(i));
                        }
                        System.out.print("Enter task number to delete: ");
                        try {
                            int num = Integer.parseInt(scanner.nextLine());
                            if (num > 0 && num <= todoList.size()) {
                                todoList.remove(num - 1);
                                System.out.println("Task deleted.");
                            } else {
                                System.out.println("Invalid task number.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                    }
                    break;
                case "7":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
