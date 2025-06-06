package Project;

//Rook.java
public class Rook extends Piece {
 public Rook(boolean isWhite) {
     super(isWhite);
 }

 @Override
 public char getSymbol() {
     return isWhite ? 'R' : 'r';
 }

 @Override
 public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
     if (startX != endX && startY != endY) return false; // can only move in direction at a time
     int stepX = Integer.compare(endX, startX); // if endX > startX : stepX =1 || If the opposite: -1 || If equal: 0
     int stepY = Integer.compare(endY, startY);
     int x = startX + stepX, y = startY + stepY;
     while (x != endX || y != endY) {
         if (board[x][y] != null) return false;
         x += stepX;
         y += stepY;
     }
     return board[endX][endY] == null || board[endX][endY].isWhite() != isWhite;
 }
}