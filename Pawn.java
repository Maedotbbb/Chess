package Project;

//import javax.swing.ImageIcon;
//Pawn.java
public class Pawn extends Piece {
 public Pawn(boolean isWhite) {
     super(isWhite);
 }

 @Override
 public char getSymbol() {
	 //ImageIcon image = new ImageIcon("D:\\Eclipse java projects\\src\\FirstProject\\logo.png"); // not working
		//f.setIconImage(image.getImage());
	 //String whitePawn="D:\\\\Eclipse java projects\\\\src\\\\FirstProject\\\\logo.png\";
     return isWhite ? 'P' : 'p';
 }


  @Override
  public boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board) {
      int dir = isWhite ? -1 : 1;
      if (startX + dir == endX && startY == endY && board[endX][endY] == null) {
          return true;
      }
      if (startX + dir == endX && Math.abs(startY - endY) == 1 && board[endX][endY] != null && board[endX][endY].isWhite() != isWhite) {
          return true;
      }
      return false;
  }
}
