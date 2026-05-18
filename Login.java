import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {
    private JTextField t1;
    private JPasswordField t2;

    public Login() {
        setTitle("Login");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Full-screen mode
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background color to yellow
        getContentPane().setBackground(new Color(255, 204, 0));

        // Create a panel with GridBagLayout for better responsiveness
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 204, 0)); // Yellow background

        // Title Label
        JLabel title = new JLabel("Welcome to Farmers Trade with Organization");
        title.setFont(new Font("SansSerif", Font.BOLD, 24));
        title.setForeground(Color.BLUE);

        JLabel subtitle = new JLabel("Login Page");
        subtitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        subtitle.setForeground(new Color(0, 128, 0));

        // Create text fields and buttons
        t1 = new JTextField(20);
        t2 = new JPasswordField(20);

        // Buttons with custom styles


        // Adding actions to buttons
        JButton signInButton = new JButton("Sign In");
        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signActionPerformed(e);
            }
        });
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerActionPerformed(e);
            }
        });
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetActionPerformed(e);
            }
        });

        // Configure GridBagLayout constraints for responsiveness
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding between components
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER; // Center all components

        // Add components to the panel
        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        // Subtitle
        gbc.gridy = 1;
        panel.add(subtitle, gbc);

        // Username Label
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        JLabel userLabel = new JLabel("Username");
        userLabel.setIcon(new ImageIcon("user.png")); // Assuming you have an icon
        panel.add(userLabel, gbc);

        // Username TextField
        gbc.gridx = 1;
        panel.add(t1, gbc);

        // Password Label
        gbc.gridx = 0;
        gbc.gridy = 3;
        JLabel passLabel = new JLabel("Password");
        passLabel.setIcon(new ImageIcon("lock.png")); // Assuming you have an icon
        panel.add(passLabel, gbc);

        // Password TextField
        gbc.gridx = 1;
        panel.add(t2, gbc);

        // Sign In Button
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(signInButton, gbc);

        // Register Button
        gbc.gridy = 5;
        panel.add(registerButton, gbc);

        // Reset Button
        gbc.gridy = 6;
        panel.add(resetButton, gbc);

        // Add panel to the frame
        add(panel, BorderLayout.CENTER);
        
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void signActionPerformed(ActionEvent e) {
        String user = t1.getText();
        char[] p = t2.getPassword();
        String password = new String(p);

        try {
            // Connect to the database
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmer_registration", "root", "namitha");
            String sql = "SELECT * FROM farmer_registration";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            boolean flag = false;

            if (user.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(this, "ALL FIELDS ARE MANDATORY");
            } else {
                while (rs.next()) {
                    if (user.equals(rs.getString(1)) && password.equals(rs.getString(2))) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    JOptionPane.showMessageDialog(this, "SIGN IN SUCCESSFULLY");
                    new Home().setVisible(true);  // Open main application screen
                    dispose();  // Close login screen
                } else {
                    JOptionPane.showMessageDialog(this, "INVALID CREDENTIALS");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void registerActionPerformed(ActionEvent e) {
        new Registration().setVisible(true);
        dispose();  // Close login screen and open registration screen
    }

    private void resetActionPerformed(ActionEvent e) {
        t1.setText(null);
        t2.setText(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Login());
    }
}