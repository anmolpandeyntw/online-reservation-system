package services;

import java.sql.*;
import database.DBConnection;

public class CancellationService {

    public boolean cancelReservation(int pnr) {
        String query = "DELETE FROM reservations WHERE pnr=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {

            st.setInt(1, pnr);
            int r = st.executeUpdate();
            return r > 0;

        } catch (SQLException e) {
            System.out.println("Cancellation error: " + e.getMessage());
            return false;
        }
    }
}
