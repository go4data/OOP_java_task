import java.util.ArrayList;
import java.util.Scanner;

// User Class
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Admin Class (Inheritance)
class Admin extends User {
    public Admin(String name) {
        super(name);
    }
}

// Message Class
class Message {
    private User sender;
    private User receiver;
    private String content;

    public Message(User sender, User receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public String getSenderName() {
        return sender.getName();
    }
}

// Chat System Class
class ChatSystem {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Message> messages = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n1. Create User");
            System.out.println("2. Send Message");
            System.out.println("3. View Messages");
            System.out.println("4. Broadcast Message (Admin only)");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    sendMessage();
                    break;
                case 3:
                    viewMessages();
                    break;
                case 4:
                    broadcastMessage();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void createUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Is Admin? (y/n): ");
        String isAdmin = scanner.nextLine();

        if (isAdmin.equalsIgnoreCase("y")) {
            users.add(new Admin(name));
        } else {
            users.add(new User(name));
        }

        System.out.println("User created!");
    }

    private User chooseUser() {
        if (users.isEmpty()) {
            System.out.println("No users available!");
            return null;
        }

        for (int i = 0; i < users.size(); i++) {
            System.out.println(i + " - " + users.get(i).getName());
        }

        int index = scanner.nextInt();
        scanner.nextLine();

        if (index < 0 || index >= users.size()) {
            System.out.println("Invalid choice!");
            return null;
        }

        return users.get(index);
    }

    private void sendMessage() {
        System.out.println("Choose sender:");
        User sender = chooseUser();
        if (sender == null) return;

        System.out.println("Choose receiver:");
        User receiver = chooseUser();
        if (receiver == null) return;

        System.out.print("Enter message: ");
        String content = scanner.nextLine();

        messages.add(new Message(sender, receiver, content));
        System.out.println("Message sent!");
    }

    private void viewMessages() {
        System.out.println("Choose user:");
        User user = chooseUser();
        if (user == null) return;

        System.out.println(user.getName() + " received:");

        boolean found = false;
        for (Message m : messages) {
            if (m.getReceiver() == user) {
                System.out.println("From " + m.getSenderName() + ": " + m.getContent());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No messages.");
        }
    }

    private void broadcastMessage() {
        System.out.println("Choose admin:");
        User sender = chooseUser();
        if (sender == null) return;

        if (!(sender instanceof Admin)) {
            System.out.println("Only admin can broadcast!");
            return;
        }

        System.out.print("Enter message: ");
        String content = scanner.nextLine();

        for (User u : users) {
            if (u != sender) {
                messages.add(new Message(sender, u, content));
            }
        }

        System.out.println("Broadcast sent!");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        ChatSystem system = new ChatSystem();
        system.start();
    }
}