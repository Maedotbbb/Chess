package Project;


//Piece.java
public abstract class Piece {
	protected boolean isWhite;

	public Piece(boolean isWhite) {
     this.isWhite = isWhite;
	}

	public boolean isWhite() {
     return isWhite;
	}
	
	 public abstract char getSymbol(); // e.g., 'P' for pawn, 'R' for rook, etc.
	 //public abstract Char getSymbol();
	 public abstract boolean isValidMove(int startX, int startY, int endX, int endY, Piece[][] board);
}
