import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {
    private JPanel p;
    private JLabel l, l1, l2;
    private JPanel p1;
    private JButton b, b1;
    private JLabel l4;

    public MyFrame() {
        // Main Panel
        p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("farming.jpg"); // Your image
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        p.setLayout(null);
        p.setBounds(0, 0, 1000, 800);

        // Labels for the text "FARMER'S TRADE WITH ORGANIZATION"
        l = new JLabel("FARMER'S");
        l.setFont(new Font("Tahoma", Font.BOLD, 36));
        l.setForeground(Color.BLUE);
        l.setBounds(270, 100, 580, 55);
        p.add(l);

        l1 = new JLabel("TRADE WITH ORGANIZATION");
        l1.setFont(new Font("Tahoma", Font.BOLD, 36));
        l1.setForeground(Color.BLUE);
        l1.setBounds(100, 165, 600, 55);
        p.add(l1);

        // Placeholder for additional image or content
        l2 = new JLabel();
        l2.setBounds(0, 0, 1000, 800);
        p.add(l2);

        // Side Panel for Buttons
        p1 = new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(700, 0, 900, 800);
        p1.setLayout(null);

        // Registration Button
        b = new JButton("Registration");
        b.setFont(new Font("Arial", Font.BOLD, 22));
        b.setForeground(Color.WHITE);
        b.setBackground(Color.RED);
        b.setBounds(400, 300, 170, 35);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerActionPerformed(e);
            }
        });
        p1.add(b);

        // Login Button
        b1 = new JButton("Login");
        b1.setFont(new Font("Arial", Font.BOLD, 22));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.magenta);
        b1.setBounds(400, 370, 170, 35);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginActionPerformed(e);
            }
        });
        p1.add(b1);

        // Icon placeholder
        l4 = new JLabel(new ImageIcon("groupicon.png")); // Your image
        l4.setBounds(340, 50, 300, 200);
        p1.add(l4);

        // Main Frame setup
        setLayout(null);
        setSize(1500, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(p);
        add(p1);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private void registerActionPerformed(ActionEvent e) {
        new Registration().setVisible(true);
        setVisible(false);
    }

    private void loginActionPerformed(ActionEvent e) {
        new Login().setVisible(true);
        setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame());
    }
}
