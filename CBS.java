import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Broadcast {
    private String title;
    private String time;

    public Broadcast(String title, String time) {
        this.title = title;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Time: " + time;
    }
}

public class CBS {
    private List<Broadcast> schedule;

    public CBS() {
        this.schedule = new ArrayList<>();
    }

    public void addBroadcast(String title, String time) {
        Broadcast broadcast = new Broadcast(title, time);
        schedule.add(broadcast);
        System.out.println("Broadcast added successfully.");
    }

    public void displaySchedule() {
        if (schedule.isEmpty()) {
            System.out.println("No broadcasts scheduled.");
        } else {
            System.out.println("Current Broadcast Schedule:");
            for (Broadcast broadcast : schedule) {
                System.out.println(broadcast);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CBS cbs = new CBS();

        while (true) {
            System.out.println("\nCentral Broadcasting System (CBS) Menu:");
            System.out.println("1. Add Broadcast");
            System.out.println("2. Display Schedule");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter broadcast title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter broadcast time (e.g., 10:00 AM): ");
                    String time = scanner.nextLine();
                    cbs.addBroadcast(title, time);
                    break;
                case 2:
                    cbs.displaySchedule();
                    break;
                case 3:
                    System.out.println("Exiting CBS...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
