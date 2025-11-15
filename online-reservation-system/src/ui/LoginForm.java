package ui;

import java.util.Scanner;
import services.AuthService;

public class LoginForm {

    private Scanner sc = new Scanner(System.in);

    public void show() {
        System.out.println("==== ONLINE RESERVATION SYSTEM ====");
        System.out.print("Enter username: ");
        String user = sc.nextLine().trim();

        System.out.print("Enter password: ");
        String pass = sc.nextLine().trim();

        AuthService auth = new AuthService();
        if (auth.login(user, pass)) {
            System.out.println("\nLogin Successful!\n");
            new Menu().show();
        } else {
            System.out.println("\nInvalid credentials! Exiting.");
        }
    }
}
