import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginSystemWithContacts {
    private static Map<String, Data> p = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Register");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
            }
        }
    }
    private static void login() {
        System.out.print("Enter your username: ");
        String username = sc.nextLine();

        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        if (ver(username, password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
            showContacts(username);
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void register() {
        System.out.print("Enter a new username: ");
        String username = sc.nextLine();

        if (p.containsKey(username)) {
            System.out.println("Username already exists. Please choose another one.");
            return;
        }

        System.out.print("Enter a password: ");
        String password = sc.nextLine();

        System.out.print("Enter your full name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = sc.nextLine();

        Contact contact = new Contact(fullName, phoneNumber);

        p.put(username, new Data(password, contact));

        System.out.println("Registration done !");
    }

    private static boolean ver(String username, String password) {
        return p.containsKey(username) && p.get(username).getPassword().equals(password);
    }
    private static void showContacts(String username) {
        Data Data = p.get(username);
        Contact contact = Data.getContact();

        System.out.println("Contact Information:");
        System.out.println("Name: " + contact.getFullName());
        System.out.println("Phone Number: " + contact.getPhoneNumber());
    }

    private static class Contact {
        private String fullName;
        private String phoneNumber;

        public Contact(String fullName, String phoneNumber) {
            this.fullName = fullName;
            this.phoneNumber = phoneNumber;
        }

        public String getFullName() {
            return fullName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }

    private static class Data {
        private String password;
        private Contact contact;

        public Data(String password, Contact contact) {
            this.password = password;
            this.contact = contact;
        }
        public String getPassword() {
            return password;
        }
        public Contact getContact() {
            return contact;
        }
    }
}