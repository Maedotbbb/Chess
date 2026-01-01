package Project2;

//Piece.java
import java.util.*;

public abstract class Piece {
 protected boolean isWhite;

 public Piece(boolean isWhite) {
     this.isWhite = isWhite;
 }

 public boolean isWhite() {
     return isWhite;
 }

 public abstract char getSymbol();

 public abstract boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board);

 public List<int[]> getAllValidMoves(int startX, int startY, Piece[][] board) {
     List<int[]> moves = new ArrayList<>();
     for (int x = 0; x < 8; x++) {
         for (int y = 0; y < 8; y++) {
             if (isValidMove(startX, startY, x, y, board)) {
                 moves.add(new int[]{x, y});
             }
         }
     }
     return moves;
 }
}