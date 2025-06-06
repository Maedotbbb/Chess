package Project;

//Bishop.java
public class Bishop extends Piece {
 public Bishop(boolean isWhite) {
     super(isWhite);
 }

 @Override
 public char getSymbol() {
     return isWhite ? 'B' : 'b';
 }

 @Override
 public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
     int dx = Math.abs(endX - startX), dy = Math.abs(endY - startY);
     if (dx != dy) return false;
     int stepX = Integer.compare(endX, startX);
     int stepY = Integer.compare(endY, startY);
     int x = startX + stepX, y = startY + stepY;
     while (x != endX && y != endY) {
         if (board[x][y] != null) return false;
         x += stepX;
         y += stepY;
     }
     return board[endX][endY] == null || board[endX][endY].isWhite() != isWhite;
 }
}