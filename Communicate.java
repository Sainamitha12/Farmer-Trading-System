// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// public class Communicate extends JFrame {
//     private JTextField nameField;
//     private JTextField emailField;
//     private JTextArea messageArea;
//     private JButton sendButton;
//     private JButton jButton1;
//     public Communicate() {
//         initComponents();
//     }
//     private void initComponents() {
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setTitle("Communicate with Farmer");
//         setLayout(new FlowLayout());
//         JLabel nameLabel = new JLabel("Name: ");
//         nameField = new JTextField(20);
//         JLabel emailLabel = new JLabel("Email: ");
//         emailField = new JTextField(20);
//         JLabel messageLabel = new JLabel("Message: ");
//         messageArea = new JTextArea(5, 20);
//         JScrollPane messageScrollPane = new JScrollPane(messageArea);
//         sendButton = new JButton("Send Request");
//         jButton1 = new JButton("back to home"); 
//         add(nameLabel);
//         add(nameField);
//         add(emailLabel);
//         add(emailField);
//         add(messageLabel);
//         add(messageScrollPane);
//         add(sendButton);
//         add(jButton1); 
//         jButton1.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 jButton1ActionPerformed(e);
//             }
//         });
//         sendButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 String name = nameField.getText();
//                 String email = emailField.getText();
//                 String message = messageArea.getText();
//                 JOptionPane.showMessageDialog(null, "Name: " + name + "\nEmail: " + email + "\nMessage:\n" + message);
//                 nameField.setText("");
//                 emailField.setText("");
//                 messageArea.setText("");
//             }
//         });
//         pack();
//         setLocationRelativeTo(null); 
//     }
//     private void jButton1ActionPerformed(ActionEvent e) {
//         new Home().setVisible(true);
//         setVisible(false);
//         dispose();
//     }
//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             new Communicate().setVisible(true);
//         });
//     }
// }
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Communicate extends JFrame {
    private JTextField nameField;
    private JTextArea messageArea;
    private JButton submitButton, resetButton;
    private JRadioButton farmerRadioButton, traderRadioButton;

    public Communicate() {
        initComponents();
    }

    private void initComponents() {
        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Communicate here");
        setSize(400, 300);
        setLayout(null);

        // Set background color
        getContentPane().setBackground(new Color(167, 230, 235));

        // Title label
        JLabel titleLabel = new JLabel("Communicate here");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
        titleLabel.setBounds(140, 10, 200, 30);
        add(titleLabel);

        // Radio buttons for "write to"
        JLabel writeToLabel = new JLabel("write to :");
        writeToLabel.setBounds(30, 60, 70, 20);
        add(writeToLabel);

        farmerRadioButton = new JRadioButton("Farmer");
        traderRadioButton = new JRadioButton("Trader");
        farmerRadioButton.setBounds(100, 60, 80, 20);
        traderRadioButton.setBounds(180, 60, 80, 20);

        // Group radio buttons
        ButtonGroup group = new ButtonGroup();
        group.add(farmerRadioButton);
        group.add(traderRadioButton);

        add(farmerRadioButton);
        add(traderRadioButton);

        // Name input
        JLabel nameLabel = new JLabel("choose name :");
        nameLabel.setBounds(30, 90, 100, 20);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(130, 90, 150, 20);
        add(nameField);

        // Message area
        messageArea = new JTextArea();
        messageArea.setBounds(30, 120, 320, 80);
        messageArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        add(messageArea);

        // Submit and Reset buttons
        submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(144, 238, 144));
        submitButton.setBounds(80, 220, 80, 25);
        add(submitButton);

        resetButton = new JButton("Reset");
        resetButton.setBackground(new Color(173, 216, 230));
        resetButton.setBounds(180, 220, 80, 25);
        add(resetButton);

        // Action listeners for buttons
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String message = messageArea.getText();
                String recipient = farmerRadioButton.isSelected() ? "Farmer" : "Trader";
                JOptionPane.showMessageDialog(null, "To: " + recipient + "\nName: " + name + "\nMessage:\n" + message);
                nameField.setText("");
                messageArea.setText("");
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameField.setText("");
                messageArea.setText("");
                group.clearSelection();
            }
        });

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Communicate().setVisible(true);
        });
    }
}
