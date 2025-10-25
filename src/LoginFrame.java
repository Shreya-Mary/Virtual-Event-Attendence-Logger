import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginFrame extends JFrame {
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginFrame() {
        setTitle("Login");
        setSize(350, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Username label and field
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 30, 100, 25);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(140, 30, 160, 25);
        add(txtUsername);

        // Password label and field
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 70, 100, 25);
        add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(140, 70, 160, 25);
        add(txtPassword);

        // Login button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(120, 120, 100, 30);
        add(btnLogin);

        // Action listener for login button
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        setVisible(true);
    }

    private void login() {
        // Trim inputs to remove spaces
        String username = txtUsername.getText().trim();
        String password = new String(txtPassword.getPassword()).trim();

        // Debug prints
        System.out.println("Attempting login with Username: '" + username + "' Password: '" + password + "'");

        try (Connection con = DatabaseConnection.getConnection()) {
            if (con == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed!");
                return;
            }

            // Use prepared statement to safely query DB
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                // Open next frame (Dashboard)
                // new DashboardFrame().setVisible(true);
                this.dispose(); // Close login frame
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}
