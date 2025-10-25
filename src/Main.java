import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        // Launch the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Open the login frame
                new LoginFrame();
            }
        });

        // If you want to view attendance records in console
        // (Optional: can be removed if using GUI only)
        AttendanceDAO.viewRecords();
    }
}
