package ui;

import java.util.Scanner;
import services.CancellationService;

public class CancellationForm {

    private Scanner sc = new Scanner(System.in);

    public void show() {
        try {
            System.out.print("Enter PNR to cancel: ");
            int pnr = Integer.parseInt(sc.nextLine().trim());
            CancellationService svc = new CancellationService();
            boolean ok = svc.cancelReservation(pnr);
            if (ok) System.out.println("Cancellation successful for PNR: " + pnr);
            else System.out.println("PNR not found: " + pnr);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
