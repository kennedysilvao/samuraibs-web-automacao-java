package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    public static void main(String[] args) throws SQLException {
        Database database = new Database();
        database.deleteUser("kennedy@automacao.com");
    }

    public Connection connect() throws SQLException {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://jelani.db.elephantsql.com/zvbqdrth", "zvbqdrth", "qFi45T3ZaSwXaQL7o3OmDEVH0v82Ec-9");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
        return c;
    }

    public int deleteUser(String email) throws SQLException {
        String SQL = "DELETE FROM public.users WHERE email = ?";

        int affectedRows = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, email);
            affectedRows = pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedRows;

    }

}
