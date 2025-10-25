package src;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AttendanceLogger {

    private static final String FILE_NAME = "attendance_records.txt";

    public static void markAttendance(String username) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = now.format(formatter);
            writer.write(username + " marked attendance at " + timestamp + "\n");
            System.out.println("Attendance marked successfully!");
        } catch (IOException e) {
            System.out.println("Error while writing attendance: " + e.getMessage());
        }
    }
}
