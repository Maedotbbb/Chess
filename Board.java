package Project2;

//Board.java
public class Board {
 public Piece[][] board;

 public Board() {
     board = new Piece[8][8];
     initializeBoard();
 }

 public void initializeBoard() {
     for (int i = 0; i < 8; i++) {
         board[1][i] = new Pawn(false);
         board[6][i] = new Pawn(true);
     }
     board[0][0] = new Rook(false); board[0][7] = new Rook(false);
     board[7][0] = new Rook(true); board[7][7] = new Rook(true);
     board[0][1] = new Knight(false); board[0][6] = new Knight(false);
     board[7][1] = new Knight(true); board[7][6] = new Knight(true);
     board[0][2] = new Bishop(false); board[0][5] = new Bishop(false);
     board[7][2] = new Bishop(true); board[7][5] = new Bishop(true);
     board[0][3] = new Queen(false); board[0][4] = new King(false);
     board[7][3] = new Queen(true); board[7][4] = new King(true);
 }
}