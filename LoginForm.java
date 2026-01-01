package Project2;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class LoginForm {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("Chess Game");
        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        // Title
        JLabel titleLabel = new JLabel("Chess game");
        titleLabel.setFont(new Font("Serif", Font.BOLD, 20));
        titleLabel.setBounds(120, 10, 150, 30);
        frame.add(titleLabel);

        // Text
        JLabel userLabel = new JLabel("A 2 player game design to teach you chess");
        userLabel.setBounds(50, 60, 800, 20);
        frame.add(userLabel);



        //Register Buttons
        JButton registerButton = new JButton("Start New Game");
        registerButton.setBounds(70, 150, 200, 25);
        registerButton.setBackground(Color.YELLOW);
        frame.add(registerButton);

        
     // register to display Registration
        registerButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
//            	RegistrationForm r = new RegistrationForm();
            	javax.swing.SwingUtilities.invokeLater(() -> {
                    ChessGUI gui = new ChessGUI(new Game());
                    gui.setVisible(true);
                });
            }
        });
        

        // Set frame visible
        frame.setVisible(true);
    }
}
