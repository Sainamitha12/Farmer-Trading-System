// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;

// public class Recommendations extends JFrame {
//     private JPanel jPanel1;
//     private JLabel jLabel1, jLabel3, jLabel2;
//     private JButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6;

//     public Recommendations() {
//         initComponents();
//     }

//     private void initComponents() {
//         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//         setTitle("Recommendations");
//         setSize(800, 600);
//         setLocationRelativeTo(null);

//         // Main panel setup with new background color
//         jPanel1 = new JPanel();
//         jPanel1.setBackground(new Color(203, 255, 196)); // Set background color
//         jPanel1.setLayout(null);

//         // Labels
//         jLabel1 = new JLabel("Recommended");
//         jLabel1.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 24));
//         jLabel1.setForeground(new Color(255, 51, 0));
//         jLabel1.setBounds(50, 20, 200, 30);

//         jLabel3 = new JLabel("for better farming");
//         jLabel3.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 24));
//         jLabel3.setForeground(new Color(255, 0, 0));
//         jLabel3.setBounds(50, 60, 250, 30);

//         // Buttons without background color (except "Home" button)
//         jButton1 = createButton("Pesticide Watch", 50, 120);
//         jButton2 = createButton("Agriculture and Farmers Welfare", 50, 170);
//         jButton3 = createButton("Wiki Farming", 50, 220);
//         jButton4 = createButton("Food and Agriculture", 50, 270);
//         jButton5 = createButton("Soil and Land", 50, 320);

//         // Home button with background color
//         jButton6 = new JButton("Home");
//         jButton6.setFont(new Font("Tahoma", Font.BOLD, 14));
//         jButton6.setBackground(new Color(255, 204, 0)); // Background color for Home button
//         jButton6.setBounds(50, 380, 100, 30);
//         jButton6.addActionListener(e -> goToHome());

//         // Add image label for the logo, move image slightly left
//         jLabel2 = new JLabel(new ImageIcon("farm.jpg")); // Replace with the correct image path
//         jLabel2.setBounds(380, 40, 430, 430); // Adjusted to move the image slightly left

//         // Add components to panel
//         jPanel1.add(jLabel1);
//         jPanel1.add(jLabel3);
//         jPanel1.add(jButton1);
//         jPanel1.add(jButton2);
//         jPanel1.add(jButton3);
//         jPanel1.add(jButton4);
//         jPanel1.add(jButton5);
//         jPanel1.add(jButton6);
//         jPanel1.add(jLabel2);

//         // Add panel to frame
//         getContentPane().add(jPanel1);
//     }

//     private JButton createButton(String text, int x, int y) {
//         JButton button = new JButton(text);
//         button.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 14));
//         // Removed button background color
//         button.setBounds(x, y, 250, 40);
//         return button;
//     }

//     private void goToHome() {
//         new Home().setVisible(true); // Make sure you have a "Home" class
//         setVisible(false);
//         dispose();
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             new Recommendations().setVisible(true);
//         });
//     }
// }

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Recommendations extends JFrame {
    private JPanel jPanel1;
    private JLabel jLabel1, jLabel3, jLabel2;
    private JButton jButton1, jButton2, jButton3, jButton4, jButton5, jButton6;

    public Recommendations() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recommendations");
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Main panel setup with new background color
        jPanel1 = new JPanel();
        jPanel1.setBackground(new Color(203, 255, 196)); // Set background color
        jPanel1.setLayout(null);

        // Labels
        jLabel1 = new JLabel("Recommended");
        jLabel1.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 24));
        jLabel1.setForeground(new Color(255, 51, 0));
        jLabel1.setBounds(50, 20, 200, 30);

        jLabel3 = new JLabel("for better farming");
        jLabel3.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 24));
        jLabel3.setForeground(new Color(255, 0, 0));
        jLabel3.setBounds(50, 60, 250, 30);

        // Buttons without background color (except "Home" button)
        jButton1 = createButton("Pesticide Watch", 50, 120);
        jButton2 = createButton("Agriculture Welfare", 50, 170);
        jButton3 = createButton("Wiki Farming", 50, 220);
        jButton4 = createButton("Food and Agriculture", 50, 270);
        jButton5 = createButton("Soil and Land", 50, 320);

        // Home button with background color
        jButton6 = new JButton("Home");
        jButton6.setFont(new Font("Tahoma", Font.BOLD, 14));
        jButton6.setBackground(new Color(255, 204, 0)); // Background color for Home button
        jButton6.setBounds(50, 380, 100, 30);
        jButton6.addActionListener(e -> goToHome());

        // Add image label for the logo, move image slightly left
        jLabel2 = new JLabel(new ImageIcon("farm.jpg")); // Replace with the correct image path
        jLabel2.setBounds(380, 40, 430, 430); // Adjusted to move the image slightly left

        // Add components to panel
        jPanel1.add(jLabel1);
        jPanel1.add(jLabel3);
        jPanel1.add(jButton1);
        jPanel1.add(jButton2);
        jPanel1.add(jButton3);
        jPanel1.add(jButton4);
        jPanel1.add(jButton5);
        jPanel1.add(jButton6);
        jPanel1.add(jLabel2);

        // Add panel to frame
        getContentPane().add(jPanel1);

        // Adding action listeners to buttons (except home button)
        jButton1.addActionListener(e -> openLink("https://www.india.gov.in/topics/agriculture/fertilizers-pesticides"));
        jButton2.addActionListener(e -> openLink("https://www.india.gov.in/website-ministry-agriculture-farmers-welfare"));
        jButton3.addActionListener(e -> openLink("https://wikifarmer.com/"));
        jButton4.addActionListener(e -> openLink("https://www.india.gov.in/topics/agriculture"));
        jButton5.addActionListener(e -> openLink("https://www.india.gov.in/website-soil-and-land-use-survey-india"));
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setFont(new Font("Tahoma", Font.ITALIC | Font.BOLD, 14));
        // Removed button background color
        button.setBounds(x, y, 250, 40);
        return button;
    }

    private void goToHome() {
        new Home().setVisible(true); // Make sure you have a "Home" class
        setVisible(false);
        dispose();
    }

    // Function to open a link in the default browser (or Chrome if specified)
    private void openLink(String url) {
        try {
            // To open in the default browser
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            }
            // Alternatively, to open in Chrome explicitly:
            // Uncomment the line below if Chrome is installed on the system and available in the PATH
            // Runtime.getRuntime().exec("chrome " + url); 
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace(); // Handle any exceptions
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Recommendations().setVisible(true);
        });
    }
}
