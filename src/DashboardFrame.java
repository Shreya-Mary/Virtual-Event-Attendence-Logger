import javax.swing.*;
import java.awt.*;


public class DashboardFrame extends JFrame {

    private JButton logoutButton;

    // Constructor accepts username to display in welcome label
    public DashboardFrame(String username) {
        setTitle("Dashboard - Virtual Attendance Logger");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Welcome label with username
        JLabel welcomeLabel = new JLabel("Welcome, " + username + "!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(welcomeLabel, BorderLayout.NORTH);

        // Main panel (placeholder for future components)
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        add(mainPanel, BorderLayout.CENTER);

        // Logout button
        logoutButton = new JButton("Logout");
        logoutButton.setBackground(new Color(255, 69, 0)); // Orange-red
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setFont(new Font("Arial", Font.BOLD, 14));
        logoutButton.setFocusPainted(false);
        logoutButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        logoutButton.addActionListener(e -> {
            dispose(); // close dashboard
            new LoginFrame(); // reopen login frame
        });

        // Bottom panel for logout button
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(logoutButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}