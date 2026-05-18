import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Home extends javax.swing.JFrame {
    public Home() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);  // Set a preferred size for the frame

        // Load and scale the background image
        ImageIcon originalIcon = new ImageIcon("green11.jpeg");  // Replace with your image path
        Image scaledImage = originalIcon.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        ImageIcon backgroundIcon = new ImageIcon(scaledImage);

        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setLayout(new GridBagLayout());  // Center components in the label
        setContentPane(backgroundLabel);

        // Create buttons
        JButton jButton1 = new JButton("Publish");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JButton jButton2 = new JButton("Consumer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        JButton jButton3 = new JButton("Communicate Frame");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        JButton jButton4 = new JButton("Recommendations");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        // Panel for buttons with transparent background
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new GridLayout(2, 2, 20, 20)); // 2x2 grid with padding between buttons
        buttonPanel.add(jButton1);
        buttonPanel.add(jButton2);
        buttonPanel.add(jButton3);
        buttonPanel.add(jButton4);

        // Add button panel to the center of the background label
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundLabel.add(buttonPanel, gbc);

        pack();
        setLocationRelativeTo(null);  // Center the frame on the screen
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        Publish publishFrame = new Publish();
        publishFrame.setVisible(true);
        dispose();
    }

    private void jButton2ActionPerformed(ActionEvent evt) {
        Consumer consumerFrame = new Consumer();
        consumerFrame.setVisible(true);
        dispose();
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        Communicate communicateFrame = new Communicate();
        communicateFrame.setVisible(true);
        dispose();
    }

    private void jButton4ActionPerformed(ActionEvent evt) {
        Recommendations recommendationsFrame = new Recommendations();
        recommendationsFrame.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }
}
