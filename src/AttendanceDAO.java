import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AttendanceDAO {

    // Method to view all attendance records
    public static void viewRecords() {
        try {
            // Get DB connection
            Connection conn = DatabaseConnection.getConnection();
            
            // Create statement
            Statement stmt = conn.createStatement();
            
            // Execute query to get all records
            ResultSet rs = stmt.executeQuery("SELECT * FROM attendance");
            
            System.out.println("ID | Student Name | Date | Status");
            System.out.println("-----------------------------------");

            // Loop through results and print
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("student_name");
                String date = rs.getString("date");
                String status = rs.getString("status");

                System.out.println(id + " | " + name + " | " + date + " | " + status);
            }

            // Close resources
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Error fetching attendance records:");
            e.printStackTrace();
        }
    }
}
