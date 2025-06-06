package Project;

import javax.swing.*;
import java.awt.*;

public class ChessBoardGUI {
    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Chess Board");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 600);

            JPanel boardPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
            JButton[][] squares = new JButton[BOARD_SIZE][BOARD_SIZE];

            for (int row = 0; row < BOARD_SIZE; row++) {
                for (int col = 0; col < BOARD_SIZE; col++) {
                    JButton square = new JButton();
                    square.setPreferredSize(new Dimension(75, 75));

                    // Set square color
                    if ((row + col) % 2 == 0) {
                        square.setBackground(Color.WHITE);
                    } else {
                        square.setBackground(Color.DARK_GRAY);
                    }

                    squares[row][col] = square;
                    boardPanel.add(square);
                }
            }

            // Load and set a sample piece icon (e.g., white king at [0][4])
            ImageIcon pieceIcon = new ImageIcon("D:\\Eclipse java projects\\src\\Project\\Images\\pieces\\white\\king.png"); // Make sure this file exists in the same directory
            Image scaledImage = pieceIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
            pieceIcon = new ImageIcon(scaledImage);
            squares[0][4].setIcon(pieceIcon);

            frame.add(boardPanel);
            frame.setVisible(true);
        });
    }
}
