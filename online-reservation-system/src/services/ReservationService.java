package services;

import java.sql.*;
import database.DBConnection;
import models.Reservation;

public class ReservationService {

    // returns generated pnr on success, -1 on failure
    public int createReservation(Reservation r) {
        String query = "INSERT INTO reservations (user_id, train_number, train_name, class_type, date_of_journey, from_place, to_place) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            st.setInt(1, r.getUserId());
            st.setString(2, r.getTrainNumber());
            st.setString(3, r.getTrainName());
            st.setString(4, r.getClassType());
            st.setDate(5, r.getDateOfJourney());
            st.setString(6, r.getFromPlace());
            st.setString(7, r.getToPlace());

            int rows = st.executeUpdate();
            if (rows == 0) return -1;

            try (ResultSet keys = st.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }

            return -1;

        } catch (SQLException e) {
            System.out.println("Reservation error: " + e.getMessage());
            return -1;
        }
    }

    public void printReservation(int pnr) {
        String query = "SELECT r.pnr, r.train_number, r.train_name, r.class_type, r.date_of_journey, r.from_place, r.to_place, u.username " +
                       "FROM reservations r JOIN users u ON r.user_id = u.id WHERE r.pnr = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {

            st.setInt(1, pnr);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                System.out.println("PNR: " + rs.getInt("pnr"));
                System.out.println("User: " + rs.getString("username"));
                System.out.println("Train: " + rs.getString("train_name") + " (" + rs.getString("train_number") + ")");
                System.out.println("Class: " + rs.getString("class_type"));
                System.out.println("Date: " + rs.getDate("date_of_journey"));
                System.out.println("From: " + rs.getString("from_place") + "  To: " + rs.getString("to_place"));
            } else {
                System.out.println("Reservation not found for PNR " + pnr);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching reservation: " + e.getMessage());
        }
    }
}
