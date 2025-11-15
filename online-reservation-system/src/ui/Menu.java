package ui;

import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);

    public void show() {
        while (true) {
            System.out.println("1. Make Reservation");
            System.out.println("2. Cancel Reservation");
            System.out.println("3. View Reservation by PNR");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            int ch = Integer.parseInt(sc.nextLine().trim());
            switch (ch) {
                case 1 -> new ReservationForm().show();
                case 2 -> new CancellationForm().show();
                case 3 -> {
                    System.out.print("Enter PNR: ");
                    int pnr = Integer.parseInt(sc.nextLine().trim());
                    new services.ReservationService().printReservation(pnr);
                }
                case 4 -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }
}
