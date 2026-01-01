package Project2;

//ChessGUI.java
import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ChessGUI extends JFrame {
 private Game game;
 private JButton[][] squares;
 private int[] selectedSquare = null;
 private Map<String, ImageIcon> pieceImages;

 public ChessGUI(Game game) {
     this.game = game;
     loadPieceImages();

     setTitle("Java Chess");
     setSize(720, 720);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setLayout(new GridLayout(8, 8));

     squares = new JButton[8][8];

     for (int row = 0; row < 8; row++) {
         for (int col = 0; col < 8; col++) {
             JButton button = new JButton();
             button.setBackground((row + col) % 2 == 0 ? new Color(240, 217, 181) : new Color(181, 136, 99));
             button.setOpaque(true);
             button.setBorderPainted(false);
             final int r = row, c = col;
             button.addActionListener(e -> handleSquareClick(r, c));
             squares[row][col] = button;
             add(button);
         }
     }

     renderBoard();
 }

 private void loadPieceImages() {
     pieceImages = new HashMap<>();
     pieceImages.put("P", new ImageIcon(getClass().getResource("pieces/white/pawn.png")));
     pieceImages.put("p", new ImageIcon(getClass().getResource("pieces\\black\\pawn.png")));
     pieceImages.put("R", new ImageIcon(getClass().getResource("pieces\\white\\rook.png")));
     pieceImages.put("r", new ImageIcon(getClass().getResource("pieces\\black\\rook.png")));
     pieceImages.put("N", new ImageIcon(getClass().getResource("pieces\\white\\knight.png")));
     pieceImages.put("n", new ImageIcon(getClass().getResource("pieces\\black\\knight.png")));
     pieceImages.put("B", new ImageIcon(getClass().getResource("pieces\\white\\bishop.png")));
     pieceImages.put("b", new ImageIcon(getClass().getResource("pieces\\black\\bishop.png")));
     pieceImages.put("Q", new ImageIcon(getClass().getResource("pieces\\white\\queen.png")));
     pieceImages.put("q", new ImageIcon(getClass().getResource("pieces\\black\\queen.png")));
     pieceImages.put("K", new ImageIcon(getClass().getResource("pieces\\white\\king.png")));
     pieceImages.put("k", new ImageIcon(getClass().getResource("pieces\\black\\king.png")));
 }

 private void renderBoard() {
     for (int row = 0; row < 8; row++) {
         for (int col = 0; col < 8; col++) {
             JButton button = squares[row][col];
             Piece piece = game.getPiece(row, col);

             if (piece != null) {
                 String key = String.valueOf(piece.getSymbol());
                 button.setIcon(pieceImages.get(key));
             } else {
                 button.setIcon(null);
             }

             button.setBackground((row + col) % 2 == 0 ? new Color(240, 217, 181) : new Color(181, 136, 99));
         }
     }
 }

 private void handleSquareClick(int row, int col) {
     if (selectedSquare == null) {
         Piece selected = game.getPiece(row, col);
         if (selected != null && selected.isWhite() == game.isWhiteTurn()) {
             selectedSquare = new int[] { row, col };
             highlightPossibleMoves(row, col);
         }
     } 
     else {
         int startX = selectedSquare[0];
         int startY = selectedSquare[1];

         boolean moved = game.tryMove(startX, startY, row, col);
         selectedSquare = null;
         clearHighlights();

         if (!moved) {
             JOptionPane.showMessageDialog(this, "Invalid move");
         }
         renderBoard();
     }
 }

 private void highlightPossibleMoves(int row, int col) {
     Piece selected = game.getPiece(row, col);
     if (selected == null) return;

     List<int[]> moves = selected.getAllValidMoves(row, col, game.board.board);

     for (int[] move : moves) {
         int x = move[0], y = move[1];
         squares[x][y].setBackground(Color.GREEN);
     }
 }

 private void clearHighlights() {
     for (int row = 0; row < 8; row++) {
         for (int col = 0; col < 8; col++) {
             squares[row][col].setBackground((row + col) % 2 == 0 ? new Color(240, 217, 181) : new Color(181, 136, 99));
         }
     }
 }


}
