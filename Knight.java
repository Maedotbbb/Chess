package Project;

//Knight.java
public class Knight extends Piece {
 public Knight(boolean isWhite) {
     super(isWhite);
 }

 @Override
 public char getSymbol() {
     return isWhite ? 'N' : 'n';
 }

 @Override
 public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
     int dx = Math.abs(startX - endX), dy = Math.abs(startY - endY);
     if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
         return board[endX][endY] == null || board[endX][endY].isWhite() != isWhite;
     }
     return false;
 }
}