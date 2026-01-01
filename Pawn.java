package Project2;

//Pawn.java
public class Pawn extends Piece {
 public Pawn(boolean isWhite) {
     super(isWhite);
 }

 @Override
 public char getSymbol() {
     return isWhite ? 'P' : 'p';
 }

 @Override
 public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
     int dir = isWhite ? -1 : 1;
     int firstDir = isWhite ? -2 : 2;
     if (startX + dir == endX && startY == endY && board[endX][endY] == null) {//forward
         return true;
     }
     if (startX + dir == endX && Math.abs(startY - endY) == 1 && board[endX][endY] != null && board[endX][endY].isWhite() != isWhite) {
         return true;
     }
     if (startX + firstDir == endX && startY == endY && board[endX][endY] == null && (endX==3 || endX == 4) && (startX==1 || startX==6)) { // first move can be double
         return true;
     }
     return false;
 }
}