package services;

import java.sql.*;
import database.DBConnection;

public class AuthService {

    public boolean login(String user, String pass) {
        String query = "SELECT id FROM users WHERE username=? AND password=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement st = conn.prepareStatement(query)) {

            st.setString(1, user);
            st.setString(2, pass);

            ResultSet rs = st.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Login error: " + e.getMessage());
            return false;
        }
    }
}
