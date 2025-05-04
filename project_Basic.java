import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class project_Basic {
    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }

    static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        System.out.println("\nContact List:");
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    static void updateContact() {
        viewContacts();
        System.out.print("Enter row number to update: ");
        int index = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (index <= 0 || index > contacts.size()) {
            System.out.println("Invalid contact number!");
            return;
        }

        System.out.print("Enter New Name: ");
        String newName = sc.nextLine();
        System.out.print("Enter New Phone: ");
        String newPhone = sc.nextLine();
        System.out.print("Enter New Email: ");
        String newEmail = sc.nextLine();

        contacts.set(index - 1, new Contact(newName, newPhone, newEmail));
        System.out.println("Contact updated successfully!");
    }

    static void deleteContact() {
        viewContacts();
        System.out.print("Enter row1 number to delete: ");
        int index = sc.nextInt();
        sc.nextLine(); // Consume newline

        if (index <= 0 || index > contacts.size()) {
            System.out.println("Invalid contact number!");
            return;
        }

        contacts.remove(index - 1);
        System.out.println("Contact deleted successfully!");
    }
}
