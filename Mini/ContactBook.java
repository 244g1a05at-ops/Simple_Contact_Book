import java.util.*;

// Contact class
class Contact {
    String name;
    String phone;

    Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    void display() {
        System.out.println("Name: " + name + ", Phone: " + phone);
    }
}

// Main class
public class ContactBook {
    static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Contact Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting Contact Book...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void addContact() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Phone: ");
        String phone = sc.nextLine();

        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully!");
    }

    static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found!");
            return;
        }

        System.out.println("\n--- Contact List ---");
        for (Contact c : contacts) {
            c.display();
        }
    }

    static void searchContact() {
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();

        boolean found = false;

        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                c.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found!");
        }
    }

    static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine();

        Iterator<Contact> it = contacts.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Contact c = it.next();
            if (c.name.equalsIgnoreCase(name)) {
                it.remove();
                System.out.println("Contact deleted!");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Contact not found!");
        }
    }
}
