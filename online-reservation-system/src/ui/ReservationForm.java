package ui;

import java.util.Scanner;
import java.sql.Date;
import models.Reservation;
import services.ReservationService;

public class ReservationForm {

    private Scanner sc = new Scanner(System.in);

    public void show() {
        try {
            Reservation r = new Reservation();

            System.out.print("Enter your user id (numeric): ");
            r.setUserId(Integer.parseInt(sc.nextLine().trim()));

            System.out.print("Train number: ");
            r.setTrainNumber(sc.nextLine().trim());

            System.out.print("Train name: ");
            r.setTrainName(sc.nextLine().trim());

            System.out.print("Class type: ");
            r.setClassType(sc.nextLine().trim());

            System.out.print("Date of journey (YYYY-MM-DD): ");
            r.setDateOfJourney(Date.valueOf(sc.nextLine().trim()));

            System.out.print("From: ");
            r.setFromPlace(sc.nextLine().trim());

            System.out.print("To: ");
            r.setToPlace(sc.nextLine().trim());

            ReservationService service = new ReservationService();
            int pnr = service.createReservation(r);
            if (pnr > 0) {
                System.out.println("Reservation successful! Your PNR: " + pnr);
            } else {
                System.out.println("Reservation failed.");
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
