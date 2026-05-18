import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame {
    private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    private JTextField t1, t4, t5, t6, c, state, district;
    private JPasswordField t2, t3;
    private JButton b1, b2, b3;
    private JRadioButton male, female;
    private JLabel backgroundLabel;

    // Database connection parameters
    private Connection conn;
    private PreparedStatement pst;

    public Registration() {
        setTitle("Registration Form");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load background image and set up background label
        ImageIcon backgroundImage = new ImageIcon("green..jpg");
        backgroundLabel = new JLabel();
        backgroundLabel.setLayout(null);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        backgroundLabel.setIcon(new ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));

        // Set up the thick border (3 pixels) for fields and buttons
        LineBorder thickBorder = new LineBorder(Color.BLACK, 3);

        // Font for side headings (labels)
        Font labelFont = new Font("Arial", Font.BOLD, 18);  // Increased font size

        // Title Label
        l1 = new JLabel("Registration Form");
        l1.setFont(new Font("Serif", Font.BOLD, 35));
        l1.setBounds(250, 30, 400, 30);
        backgroundLabel.add(l1);

        // Side Headings with Increased Font Size
        l2 = new JLabel("Username:");
        l2.setBounds(80, 70, 200, 30);
        l2.setFont(labelFont);  // Increased font size
        backgroundLabel.add(l2);

        t1 = new JTextField();
        t1.setBounds(300, 70, 200, 30);
        t1.setBorder(thickBorder);
        backgroundLabel.add(t1);

        l3 = new JLabel("Password:");
        l3.setBounds(80, 110, 200, 30);
        l3.setFont(labelFont);  // Increased font size
        backgroundLabel.add(l3);

        t2 = new JPasswordField();
        t2.setBounds(300, 110, 200, 30);
        t2.setBorder(thickBorder);
        backgroundLabel.add(t2);

        l4 = new JLabel("Confirm Password:");
        l4.setBounds(80, 150, 200, 30);
        l4.setFont(labelFont);  // Increased font size
        backgroundLabel.add(l4);

        t3 = new JPasswordField();
        t3.setBounds(300, 150, 200, 30);
        t3.setBorder(thickBorder);
        backgroundLabel.add(t3);

        l5 = new JLabel("First Name:");
        l5.setBounds(80, 190, 200, 30);
        l5.setFont(labelFont);  // Increased font size
        backgroundLabel.add(l5);

        t4 = new JTextField();
        t4.setBounds(300, 190, 200, 30);
        t4.setBorder(thickBorder);
        backgroundLabel.add(t4);

        l6 = new JLabel("Last Name:");
        l6.setBounds(80, 230, 200, 30);
        l6.setFont(labelFont);  // Increased font size
        backgroundLabel.add(l6);

        t5 = new JTextField();
        t5.setBounds(300, 230, 200, 30);
        t5.setBorder(thickBorder);
        backgroundLabel.add(t5);

        l7 = new JLabel("Phone Number:");
        l7.setBounds(80, 270, 200, 30);
        l7.setFont(labelFont);  // Increased font size
        backgroundLabel.add(l7);

        t6 = new JTextField();
        t6.setBounds(300, 270, 200, 30);
        t6.setBorder(thickBorder);
        backgroundLabel.add(t6);

        l8 = new JLabel("Country:");
        l8.setBounds(80, 310, 200, 30);
        l8.setFont(labelFont);  // Increased font size
        backgroundLabel.add(l8);

        c = new JTextField();
        c.setBounds(300, 310, 200, 30);
        c.setBorder(thickBorder);
        backgroundLabel.add(c);

        l9 = new JLabel("State:");
        l9.setBounds(80, 350, 200, 30);
        l9.setFont(labelFont);  // Increased font size
        backgroundLabel.add(l9);

        state = new JTextField();
        state.setBounds(300, 350, 200, 30);
        state.setBorder(thickBorder);
        backgroundLabel.add(state);

        l10 = new JLabel("District:");
        l10.setBounds(80, 390, 200, 30);
        l10.setFont(labelFont);  // Increased font size
        backgroundLabel.add(l10);

        district = new JTextField();
        district.setBounds(300, 390, 200, 30);
        district.setBorder(thickBorder);
        backgroundLabel.add(district);

        male = new JRadioButton("Male");
        male.setBounds(300, 430, 100, 30);
        backgroundLabel.add(male);

        female = new JRadioButton("Female");
        female.setBounds(400, 430, 100, 30);
        backgroundLabel.add(female);

        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);

        b1 = new JButton("Register");
        b1.setBounds(150, 500, 100, 30);
        b1.setBorder(thickBorder);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerActionPerformed(e);
            }
        });
        backgroundLabel.add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(300, 500, 100, 30);
        b2.setBorder(thickBorder);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        backgroundLabel.add(b2);

        b3 = new JButton("Back");
        b3.setBounds(450, 500, 100, 30);
        b3.setBorder(thickBorder);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b3ActionPerformed(e);
            }
        });
        backgroundLabel.add(b3);

        // Add background label
        add(backgroundLabel);

        // Resize the background image to fit the screen
        backgroundLabel.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                backgroundLabel.setIcon(new ImageIcon(backgroundImage.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
            }
        });

        // Set layout and visibility
        setLayout(new BorderLayout());
        setLocationRelativeTo(null); // Center the window
        setVisible(true);

        // Initialize JDBC connection
        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            // Load the JDBC driver (for MySQL, for example)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection (replace with your database credentials)
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmer_registration", "root", "namitha");

            System.out.println("Database connected successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection failed!");
        }
    }

    private void registerActionPerformed(ActionEvent a) {
        String username = t1.getText();
        String password = new String(t2.getPassword());
        String confirmPassword = new String(t3.getPassword());
        String firstName = t4.getText();
        String lastName = t5.getText();
        String phoneNumber = t6.getText();
        String country = c.getText();
        String stateText = state.getText();
        String districtText = district.getText();
        String gender = male.isSelected() ? "Male" : "Female";

        // Check if password and confirm password match
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!");
            return;
        }

        // Insert data into the database
        try {
            String sql = "INSERT INTO farmer_registration (USER_NAME, PASSWORDS, FIRST_NAME, LAST_NAME, MOBILE_NUMBER, COUNTRY, STATE, DISTRICT, GENDER) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.setString(3, firstName);
            pst.setString(4, lastName);
            pst.setString(5, phoneNumber);
            pst.setString(6, country);
            pst.setString(7, stateText);
            pst.setString(8, districtText);
            pst.setString(9, gender);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Registration successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error occurred.");
        }
    }

    private void b3ActionPerformed(ActionEvent e) {
        new MyFrame().setVisible(true);
        setVisible(false);
        dispose();
    }

    public static void main(String[] args) {
        new Registration();
    }
}


