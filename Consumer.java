

// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.sql.*;

// public class Consumer extends JFrame {
//     private JButton homeButton;
//     private JLabel jLabel1;
//     private JPanel jPanel1;
//     private JScrollPane jScrollPane2;
//     private JTable table;
//     private JButton buy;

//     public Consumer() {
//         initComponents();
//         fetchCrops();  // Fetch and populate data when the GUI is initialized
//     }

//     private void initComponents() {
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         jPanel1 = new JPanel();
//         jLabel1 = new JLabel();
//         jScrollPane2 = new JScrollPane();
//         table = new JTable();
//         homeButton = new JButton("Home");
//         buy = new JButton("BUY");

//         jPanel1.setBackground(new Color(1, 78, 189));
//         jLabel1.setFont(new Font("Tahoma", Font.BOLD, 24));
//         jLabel1.setForeground(new Color(255, 204, 51));
//         jLabel1.setText("Available Crops to Purchase");

//         // Set up table model
//         DefaultTableModel model = new DefaultTableModel(
//                 new Object[][]{},
//                 new String[]{
//                         "FARMER_NAME", "CROP_NAME", "QUANTITY", "QUANTITY_UNIT",
//                         "PRICE", "PRICE_PER", "PLACE", "PHONE_NUMBER"
//                 }
//         );
//         table.setModel(model);

//         // Ensure table fills available space and is scrollable
//         table.setPreferredScrollableViewportSize(new Dimension(750, 300));  // Adjust size as needed
//         table.setFillsViewportHeight(true);  // Makes the table fill the viewport

//         jScrollPane2.setViewportView(table);

//         // Button actions
//         homeButton.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 homeButtonActionPerformed(e);
//             }
//         });

//         buy.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 buyActionPerformed(e);
//             }
//         });

//         // Layout setup using GridBagLayout
//         GridBagLayout layout = new GridBagLayout();
//         GridBagConstraints gbc = new GridBagConstraints();
//         jPanel1.setLayout(layout);

//         // Set up GridBagConstraints for components
//         gbc.fill = GridBagConstraints.HORIZONTAL;

//         // Label
//         gbc.gridx = 0;
//         gbc.gridy = 0;
//         gbc.gridwidth = 2;
//         jPanel1.add(jLabel1, gbc);

//         // Table
//         gbc.gridx = 0;
//         gbc.gridy = 1;
//         gbc.gridwidth = 2;
//         jPanel1.add(jScrollPane2, gbc);

//         // Home and Buy buttons
//         gbc.gridx = 0;
//         gbc.gridy = 2;
//         gbc.gridwidth = 1;
//         jPanel1.add(homeButton, gbc);

//         gbc.gridx = 1;
//         gbc.gridy = 2;
//         jPanel1.add(buy, gbc);

//         getContentPane().add(jPanel1, BorderLayout.CENTER);
//         pack();
//     }

//     private void fetchCrops() {
//         try {
//             Class.forName("com.mysql.cj.jdbc.Driver");
//             String url = "jdbc:mysql://localhost/crops1?user=root&password=namitha";
//             Connection con = DriverManager.getConnection(url);

//             String sql = "SELECT * FROM crops1";
//             try (PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
//                 DefaultTableModel model = (DefaultTableModel) table.getModel();
//                 model.setRowCount(0);

//                 while (rs.next()) {
//                     model.addRow(new Object[]{
//                             rs.getString("FARMER_NAME"),
//                             rs.getString("CROP_NAME"),
//                             rs.getFloat("QUANTITY"),
//                             rs.getString("QUANTITY_UNIT"),
//                             rs.getFloat("PRICE"),
//                             rs.getString("PRICE_PER"),
//                             rs.getString("PLACE"),
//                             rs.getString("PHONE_NUMBER")
//                     });
//                 }
//             }
//         } catch (ClassNotFoundException | SQLException e) {
//             e.printStackTrace();
//             JOptionPane.showMessageDialog(this, "Error fetching crop data.");
//         }
//     }

//     private void homeButtonActionPerformed(ActionEvent e) {
//         // Logic to navigate to the Home page
//         // This can be implemented by opening a new JFrame for the home page or performing other relevant actions
//         JOptionPane.showMessageDialog(this, "Navigating to Home Page...");
//         // For example:
//         new Home().setVisible(true);
//         this.dispose(); // Closes the current window
//     }

//     private void buyActionPerformed(ActionEvent e) {
//         // Logic for Buy button
//         JOptionPane.showMessageDialog(this, "Buying functionality not implemented.");
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             new Consumer().setVisible(true);
//         });
//     }
// }

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Consumer extends JFrame {
    private JButton homeButton;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane2;
    private JTable table;
    private JButton buy;

    public Consumer() {
        initComponents();
        fetchCrops();  // Fetch and populate data when the GUI is initialized
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jScrollPane2 = new JScrollPane();
        table = new JTable();
        homeButton = new JButton("Home");
        buy = new JButton("BUY");

        jPanel1.setBackground(new Color(1, 78, 189));
        jLabel1.setFont(new Font("Tahoma", Font.BOLD, 24));
        jLabel1.setForeground(new Color(255, 204, 51));
        jLabel1.setText("Available Crops to Purchase");

        // Set up table model
        DefaultTableModel model = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "FARMER_NAME", "CROP_NAME", "QUANTITY", "QUANTITY_UNIT",
                        "PRICE", "PRICE_PER", "PLACE", "PHONE_NUMBER"
                }
        );
        table.setModel(model);

        // Ensure table fills available space and is scrollable
        table.setPreferredScrollableViewportSize(new Dimension(750, 300));  // Adjust size as needed
        table.setFillsViewportHeight(true);  // Makes the table fill the viewport

        jScrollPane2.setViewportView(table);

        // Button actions
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                homeButtonActionPerformed(e);
            }
        });

        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyActionPerformed(e);
            }
        });

        // Set button properties for equal width, background, and text color
        homeButton.setBackground(new Color(214, 69, 100)); 
        homeButton.setForeground(Color.white);
        buy.setBackground(new Color(214, 69, 100));
        buy.setForeground(Color.white);
        homeButton.setFont(new Font("Arial", Font.BOLD, 15));  // Increase font size
        buy.setFont(new Font("Arial", Font.BOLD, 15)); 
        // Set layout and make the buttons equal width
        homeButton.setPreferredSize(new Dimension(150, 40));  // Set a fixed size for the buttons
        buy.setPreferredSize(new Dimension(150, 40));  // Set a fixed size for the buttons

        // Layout setup using GridBagLayout
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        jPanel1.setLayout(layout);

        // Set up GridBagConstraints for components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        jPanel1.add(jLabel1, gbc);

        // Table
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        jPanel1.add(jScrollPane2, gbc);

        // Home and Buy buttons
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        jPanel1.add(homeButton, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        jPanel1.add(buy, gbc);

        getContentPane().add(jPanel1, BorderLayout.CENTER);
        pack();
    }

    private void fetchCrops() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/crops1?user=root&password=namitha";
            Connection con = DriverManager.getConnection(url);

            String sql = "SELECT * FROM crops1";
            try (PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);

                while (rs.next()) {
                    model.addRow(new Object[]{
                            rs.getString("FARMER_NAME"),
                            rs.getString("CROP_NAME"),
                            rs.getFloat("QUANTITY"),
                            rs.getString("QUANTITY_UNIT"),
                            rs.getFloat("PRICE"),
                            rs.getString("PRICE_PER"),
                            rs.getString("PLACE"),
                            rs.getString("PHONE_NUMBER")
                    });
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching crop data.");
        }
    }

    private void homeButtonActionPerformed(ActionEvent e) {
        // Logic to navigate to the Home page
        JOptionPane.showMessageDialog(this, "Navigating to Home Page...");
        new Home().setVisible(true);
        this.dispose(); // Closes the current window
    }

    private void buyActionPerformed(ActionEvent e) {
        // Logic for Buy button
        JOptionPane.showMessageDialog(this, "Buying functionality not implemented.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Consumer().setVisible(true);
        });
    }
}
