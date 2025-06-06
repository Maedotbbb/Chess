package Project;

//King.java
public class King extends Piece {
 public King(boolean isWhite) {
     super(isWhite);
 }

 @Override
 public char getSymbol() {
     return isWhite ? 'K' : 'k';
 }

 @Override
 public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
     int dx = Math.abs(startX - endX), dy = Math.abs(startY - endY);
     return dx <= 1 && dy <= 1 && (board[endX][endY] == null || board[endX][endY].isWhite() != isWhite);
 }
}