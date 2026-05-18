// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;

// public class Publish extends JFrame {
//     private JTextField t1, t2, t3, t4, t5, t6;
//     private JRadioButton r1, r2, r3, r4, r5, r6;
//     private JButton b1, b2, b3;

//     public Publish() {
//         setTitle("Publish Crop Information");
//         setSize(500, 300);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         JPanel panel = new JPanel(new GridLayout(0, 2));

//         // Initializing text fields
//         t1 = new JTextField();
//         t2 = new JTextField();
//         t3 = new JTextField();
//         t4 = new JTextField();
//         t5 = new JTextField();
//         t6 = new JTextField();

//         // Initializing radio buttons for quantity and price units
//         r1 = new JRadioButton("kg");
//         r2 = new JRadioButton("quintal");
//         r3 = new JRadioButton("gram");
//         r4 = new JRadioButton("kg");
//         r5 = new JRadioButton("quintal");
//         r6 = new JRadioButton("gram");

//         // Initializing buttons
//         b1 = new JButton("Publish");
//         b2 = new JButton("Clear");
//         b3 = new JButton("Back to Home");

//         // Grouping quantity unit radio buttons
//         ButtonGroup quantityGroup = new ButtonGroup();
//         quantityGroup.add(r1);
//         quantityGroup.add(r2);
//         quantityGroup.add(r3);

//         // Grouping price unit radio buttons
//         ButtonGroup priceGroup = new ButtonGroup();
//         priceGroup.add(r4);
//         priceGroup.add(r5);
//         priceGroup.add(r6);

//         // Adding action listeners for buttons
//         b1.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 b1ActionPerformed(e);
//             }
//         });
//         b2.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 b2ActionPerformed(e);
//             }
//         });
//         b3.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 b3ActionPerformed(e);
//             }
//         });

//         // Adding components to panel
//         panel.add(new JLabel("Name:"));
//         panel.add(t1);
//         panel.add(new JLabel("Crop Name:"));
//         panel.add(t2);
//         panel.add(new JLabel("Quantity:"));
//         panel.add(t3);
//         panel.add(new JLabel("Quantity Unit:"));
//         panel.add(r1);
//         panel.add(r2);
//         panel.add(r3);
//         panel.add(new JLabel("Price:"));
//         panel.add(t4);
//         panel.add(new JLabel("Price Unit:"));
//         panel.add(r4);
//         panel.add(r5);
//         panel.add(r6);
//         panel.add(new JLabel("Place:"));
//         panel.add(t5);
//         panel.add(new JLabel("Phone Number:"));
//         panel.add(t6);
//         panel.add(b1);
//         panel.add(b2);
//         panel.add(b3);

//         // Setting layout and adding panel
//         setLayout(new BorderLayout());
//         add(panel, BorderLayout.CENTER);
//         setVisible(true);
//     }

//     private void b1ActionPerformed(ActionEvent e) {
//         String name = t1.getText();
//         String crop_n = t2.getText();
//         float qua;
//         String q = "";
//         float pri;
//         String p = "";
//         String place = t5.getText();
//         String pn = t6.getText();

//         try {
//             qua = Float.parseFloat(t3.getText());
//             pri = Float.parseFloat(t4.getText());

//             // Determining selected units
//             if (r1.isSelected()) {
//                 q = "kg";
//             } else if (r2.isSelected()) {
//                 q = "quintal";
//             } else if (r3.isSelected()) {
//                 q = "gram";
//             }
//             if (r4.isSelected()) {
//                 p = "kg";
//             } else if (r5.isSelected()) {
//                 p = "quintal";
//             } else if (r6.isSelected()) {
//                 p = "gram";
//             }

//             // Database connection and insertion
//             String url = "jdbc:mysql://localhost/crops1?user=root&password=namitha";
//             Connection con = DriverManager.getConnection(url);
//             System.out.println("Connected to the database");

//             String sql = "INSERT INTO crops1(FARMER_NAME, CROP_NAME, QUANTITY,QUANTITY_UNIT, PRICE, PRICE_PER, PLACE, PHONE_NUMBER) VALUES(?, ?, ?, ?, ?, ?, ?)";
//             PreparedStatement pst = con.prepareStatement(sql);
//             pst.setString(1, name);
//             pst.setString(2, crop_n);
//             pst.setFloat(3, qua);
//             pst.setFloat(4, qua);
//             pst.setFloat(5, pri);
//             pst.setString(6, p);
//             pst.setString(7, place);
//             pst.setString(8, pn);

//             pst.execute();
//             JOptionPane.showMessageDialog(this, "Crop information published successfully");

//             // Clearing the input fields
//             clearFields();

//         } catch (NumberFormatException ex) {
//             JOptionPane.showMessageDialog(this, "Invalid quantity or price");
//         } catch (SQLException ex) {
//             System.out.println(ex);
//             JOptionPane.showMessageDialog(this, "Error: Failed to publish crop information");
//         }
//     }

//     private void b2ActionPerformed(ActionEvent e) {
//         clearFields();
//     }

//     private void b3ActionPerformed(ActionEvent e) {
//         new Home().setVisible(true);
//         setVisible(false);
//         dispose();
//     }

//     private void clearFields() {
//         t1.setText("");
//         t2.setText("");
//         t3.setText("");
//         t4.setText("");
//         t5.setText("");
//         t6.setText("");
//         r1.setSelected(false);
//         r2.setSelected(false);
//         r3.setSelected(false);
//         r4.setSelected(false);
//         r5.setSelected(false);
//         r6.setSelected(false);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             new Publish();
//         });
//     }
// }

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.PreparedStatement;
// import java.sql.SQLException;

// public class Publish extends JFrame {
//     private JTextField t1, t2, t3, t4, t5, t6;
//     private JRadioButton r1, r2, r3, r4, r5, r6;
//     private JButton b1, b2, b3;

//     public Publish() {
//         setTitle("Publish Crop Information");
//         setSize(700, 400);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         // Main panel with BorderLayout
//         JPanel mainPanel = new JPanel(new BorderLayout());
//         mainPanel.setBackground(new Color(252, 177, 247));  // Set background color for main panel

//         // Panel for form components
//         JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
//         formPanel.setBackground(new Color(252, 177, 247));  // Set background color

//         // Initializing text fields
//         t1 = new JTextField();
//         t2 = new JTextField();
//         t3 = new JTextField();
//         t4 = new JTextField();
//         t5 = new JTextField();
//         t6 = new JTextField();

//         // Initializing radio buttons for quantity and price units
//         r1 = new JRadioButton("kg");
//         r2 = new JRadioButton("quintal");
//         r3 = new JRadioButton("gram");
//         r4 = new JRadioButton("kg");
//         r5 = new JRadioButton("quintal");
//         r6 = new JRadioButton("gram");

//         // Initializing buttons
//         b1 = new JButton("Publish");
//         b2 = new JButton("Clear");
//         b3 = new JButton("Back to Home");

//         // Grouping quantity unit radio buttons
//         ButtonGroup quantityGroup = new ButtonGroup();
//         quantityGroup.add(r1);
//         quantityGroup.add(r2);
//         quantityGroup.add(r3);

//         // Grouping price unit radio buttons
//         ButtonGroup priceGroup = new ButtonGroup();
//         priceGroup.add(r4);
//         priceGroup.add(r5);
//         priceGroup.add(r6);

//         // Adding action listeners for buttons
//         b1.addActionListener(this::b1ActionPerformed);
//         b2.addActionListener(this::b2ActionPerformed);
//         b3.addActionListener(this::b3ActionPerformed);

//         // Adding components to the form panel
//         formPanel.add(new JLabel("Name:"));
//         formPanel.add(t1);
//         formPanel.add(new JLabel("Crop Name:"));
//         formPanel.add(t2);
//         formPanel.add(new JLabel("Quantity:"));
//         formPanel.add(t3);
//         formPanel.add(new JLabel("Quantity Unit:"));
//         formPanel.add(r1);
//         formPanel.add(r2);
//         formPanel.add(r3);
//         formPanel.add(new JLabel("Price:"));
//         formPanel.add(t4);
//         formPanel.add(new JLabel("Price Unit:"));
//         formPanel.add(r4);
//         formPanel.add(r5);
//         formPanel.add(r6);
//         formPanel.add(new JLabel("Place:"));
//         formPanel.add(t5);
//         formPanel.add(new JLabel("Phone Number:"));
//         formPanel.add(t6);
//         formPanel.add(b1);
//         formPanel.add(b2);
//         formPanel.add(b3);

//         // Image panel
//         JLabel imageLabel = new JLabel();
//         ImageIcon imageIcon = new ImageIcon("veggies.jpg");  // Load image from uploaded file path
//         Image img = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);  // Resize image
//         imageLabel.setIcon(new ImageIcon(img));

//         JPanel imagePanel = new JPanel();
//         imagePanel.setBackground(new Color(252, 177, 247));  // Set background color for image panel
//         imagePanel.add(imageLabel);

//         // Add panels to main panel
//         mainPanel.add(formPanel, BorderLayout.WEST);
//         mainPanel.add(imagePanel, BorderLayout.EAST);

//         // Add main panel to frame
//         add(mainPanel);
//         setLocationRelativeTo(null);  // Center the frame
//         setVisible(true);
//     }

//     private void b1ActionPerformed(ActionEvent e) {
//         String name = t1.getText();
//         String crop_n = t2.getText();
//         float qua;
//         String q = "";
//         float pri;
//         String p = "";
//         String place = t5.getText();
//         String pn = t6.getText();

//         try {
//             qua = Float.parseFloat(t3.getText());
//             pri = Float.parseFloat(t4.getText());

//             // Determining selected units
//             if (r1.isSelected()) q = "kg";
//             else if (r2.isSelected()) q = "quintal";
//             else if (r3.isSelected()) q = "gram";

//             if (r4.isSelected()) p = "kg";
//             else if (r5.isSelected()) p = "quintal";
//             else if (r6.isSelected()) p = "gram";

//             // Database connection and insertion
//             String url = "jdbc:mysql://localhost/crops1?user=root&password=namitha";
//             Connection con = DriverManager.getConnection(url);
//             System.out.println("Connected to the database");

//             String sql = "INSERT INTO crops1(FARMER_NAME, CROP_NAME, QUANTITY, QUANTITY_UNIT, PRICE, PRICE_PER, PLACE, PHONE_NUMBER) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
//             PreparedStatement pst = con.prepareStatement(sql);
//             pst.setString(1, name);
//             pst.setString(2, crop_n);
//             pst.setFloat(3, qua);
//             pst.setString(4, q);
//             pst.setFloat(5, pri);
//             pst.setString(6, p);
//             pst.setString(7, place);
//             pst.setString(8, pn);

//             pst.execute();
//             JOptionPane.showMessageDialog(this, "Crop information published successfully");

//             // Clearing the input fields
//             clearFields();

//         } catch (NumberFormatException ex) {
//             JOptionPane.showMessageDialog(this, "Invalid quantity or price");
//         } catch (SQLException ex) {
//             System.out.println(ex);
//             JOptionPane.showMessageDialog(this, "Error: Failed to publish crop information");
//         }
//     }

//     private void b2ActionPerformed(ActionEvent e) {
//         clearFields();
//     }

//     private void b3ActionPerformed(ActionEvent e) {
//         new Home().setVisible(true);
//         setVisible(false);
//         dispose();
//     }

//     private void clearFields() {
//         t1.setText("");
//         t2.setText("");
//         t3.setText("");
//         t4.setText("");
//         t5.setText("");
//         t6.setText("");
//         r1.setSelected(false);
//         r2.setSelected(false);
//         r3.setSelected(false);
//         r4.setSelected(false);
//         r5.setSelected(false);
//         r6.setSelected(false);
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             new Publish();
//         });
//     }
// }

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Publish extends JFrame {
    private JTextField t1, t2, t3, t4, t5, t6;
    private JRadioButton r1, r2, r3, r4, r5, r6;
    private JButton b1, b2, b3;

    public Publish() {
        setTitle("Publish Crop Information");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(252, 177, 247));  // Set background color for main panel

        // Panel for form components
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        formPanel.setBackground(new Color(252, 177, 247));  // Set background color

        // Initializing text fields
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();

        // Initializing radio buttons for quantity and price units
        r1 = new JRadioButton("kg");
        r2 = new JRadioButton("quintal");
        r3 = new JRadioButton("gram");
        r4 = new JRadioButton("kg");
        r5 = new JRadioButton("quintal");
        r6 = new JRadioButton("gram");

        // Initializing buttons
        b1 = new JButton("Publish");
        b2 = new JButton("Clear");
        b3 = new JButton("Back to Home");

        // Grouping quantity unit radio buttons
        ButtonGroup quantityGroup = new ButtonGroup();
        quantityGroup.add(r1);
        quantityGroup.add(r2);
        quantityGroup.add(r3);

        // Grouping price unit radio buttons
        ButtonGroup priceGroup = new ButtonGroup();
        priceGroup.add(r4);
        priceGroup.add(r5);
        priceGroup.add(r6);

        // Adding action listeners for buttons
        b1.addActionListener(this::b1ActionPerformed);
        b2.addActionListener(this::b2ActionPerformed);
        b3.addActionListener(this::b3ActionPerformed);

        // Adding components to the form panel
        formPanel.add(new JLabel("Name:"));
        formPanel.add(t1);
        formPanel.add(new JLabel("Crop Name:"));
        formPanel.add(t2);
        formPanel.add(new JLabel("Quantity:"));
        formPanel.add(t3);
        formPanel.add(new JLabel("Quantity Unit:"));
        formPanel.add(r1);
        formPanel.add(r2);
        formPanel.add(r3);
        formPanel.add(new JLabel("Price:"));
        formPanel.add(t4);
        formPanel.add(new JLabel("Price Unit:"));
        formPanel.add(r4);
        formPanel.add(r5);
        formPanel.add(r6);
        formPanel.add(new JLabel("Place:"));
        formPanel.add(t5);
        formPanel.add(new JLabel("Phone Number:"));
        formPanel.add(t6);
        formPanel.add(b1);
        formPanel.add(b2);
        formPanel.add(b3);

        // Image panel
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("veggies.jpg");  // Load image from uploaded file path
        Image img = imageIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);  // Resize image
        imageLabel.setIcon(new ImageIcon(img));

        // Add padding above the image to move it down slightly
        imageLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));  // Adds 20px padding at the top

        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(new Color(252, 177, 247));  // Set background color for image panel
        imagePanel.add(imageLabel);

        // Add panels to main panel
        mainPanel.add(formPanel, BorderLayout.WEST);
        mainPanel.add(imagePanel, BorderLayout.EAST);

        // Add main panel to frame
        add(mainPanel);
        setLocationRelativeTo(null);  // Center the frame
        setVisible(true);
    }

    private void b1ActionPerformed(ActionEvent e) {
        String name = t1.getText();
        String crop_n = t2.getText();
        float qua;
        String q = "";
        float pri;
        String p = "";
        String place = t5.getText();
        String pn = t6.getText();

        try {
            qua = Float.parseFloat(t3.getText());
            pri = Float.parseFloat(t4.getText());

            // Determining selected units
            if (r1.isSelected()) q = "kg";
            else if (r2.isSelected()) q = "quintal";
            else if (r3.isSelected()) q = "gram";

            if (r4.isSelected()) p = "kg";
            else if (r5.isSelected()) p = "quintal";
            else if (r6.isSelected()) p = "gram";

            // Database connection and insertion
            String url = "jdbc:mysql://localhost/crops1?user=root&password=namitha";
            Connection con = DriverManager.getConnection(url);
            System.out.println("Connected to the database");

            String sql = "INSERT INTO crops1(FARMER_NAME, CROP_NAME, QUANTITY, QUANTITY_UNIT, PRICE, PRICE_PER, PLACE, PHONE_NUMBER) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, crop_n);
            pst.setFloat(3, qua);
            pst.setString(4, q);
            pst.setFloat(5, pri);
            pst.setString(6, p);
            pst.setString(7, place);
            pst.setString(8, pn);

            pst.execute();
            JOptionPane.showMessageDialog(this, "Crop information published successfully");

            // Clearing the input fields
            clearFields();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid quantity or price");
        } catch (SQLException ex) {
            System.out.println(ex);
            JOptionPane.showMessageDialog(this, "Error: Failed to publish crop information");
        }
    }

    private void b2ActionPerformed(ActionEvent e) {
        clearFields();
    }

    private void b3ActionPerformed(ActionEvent e) {
        new Home().setVisible(true);
        setVisible(false);
        dispose();
    }

    private void clearFields() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        r1.setSelected(false);
        r2.setSelected(false);
        r3.setSelected(false);
        r4.setSelected(false);
        r5.setSelected(false);
        r6.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Publish();
        });
    }
}
