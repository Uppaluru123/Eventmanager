import java.sql.*;

public class Eventmanager {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/EventManagementDB";
    private static final String JDBC_USER = "root"; // Replace with your MySQL username
    private static final String JDBC_PASSWORD = "Admin"; // Replace with your MySQL password

    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Add events with details for Anantapur, Andhra Pradesh
            addEvent(connection, "Tech Conference 2024", "A conference to discuss the latest in technology.", "2024-08-15", "Anantapur", 500);
            addEvent(connection, "Cultural Festival", "A festival showcasing the culture and traditions of Andhra Pradesh.", "2024-09-10", "Anantapur", 1000);
            addEvent(connection, "Music Concert", "A live music concert featuring popular artists.", "2024-10-05", "Anantapur", 800);
            addEvent(connection, "Food Expo", "An exhibition of local and international cuisine.", "2024-11-12", "Anantapur", 600);
            addEvent(connection, "Art Exhibition", "An art show featuring contemporary and traditional works.", "2024-12-01", "Anantapur", 400);
            addEvent(connection, "Sports Meet", "A series of sports events for all ages.", "2024-07-22", "Anantapur", 750);
            addEvent(connection, "Literature Workshop", "A workshop on creative writing and literature.", "2024-08-25", "Anantapur", 200);
            addEvent(connection, "Startup Summit", "A summit to discuss new startup trends and innovations.", "2024-09-20", "Anantapur", 350);
            addEvent(connection, "Charity Gala", "A charity event to raise funds for local causes.", "2024-10-18", "Anantapur", 500);
            addEvent(connection, "Tech Workshop", "A hands-on workshop for technology enthusiasts.", "2024-11-08", "Anantapur", 300);

            System.out.println("Events added successfully.");

            // Close resources
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void addEvent(Connection connection, String title, String description, String eventDate, String venue, int capacity) throws SQLException {
        String sql = "INSERT INTO Events (title, description, event_date, venue, capacity) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setDate(3, Date.valueOf(eventDate));
            stmt.setString(4, venue);
            stmt.setInt(5, capacity);
            stmt.executeUpdate();
        }
    }
}
