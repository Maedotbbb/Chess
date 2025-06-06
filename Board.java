package Project;

//Board.java

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

 public void printBoard() {
     for (int i = 0; i < 8; i++) {
         System.out.print(8 - i + " ");
         for (int j = 0; j < 8; j++) {
             if (board[i][j] == null)
                 System.out.print(". ");
             else
                 System.out.print(board[i][j].getSymbol() + " ");
         }
         System.out.println();
     }
     System.out.println("  a b c d e f g h");
 }
}




/*
public class Board {
 public Piece[][] board;

 public Board() {
     board = new Piece[8][8];
     initializeBoard();
 }

 public void initializeBoard() {
     for (int i = 0; i < 8; i++) {
         board[1][i] = new Pawn(true);
         board[6][i] = new Pawn(false);
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

 public void printBoard() {
     for (int i = 0; i < 8; i++) {
         System.out.print(8 - i + " ");
         for (int j = 0; j < 8; j++) {
             if (board[i][j] == null)
                 System.out.print(". ");
             else
            	//ImageIcon image = new ImageIcon("D:\\Eclipse java projects\\src\\FirstProject\\logo.png"); // not working
         		//f.setIconImage(image.getImage());
            	 ///temp= board[i][j].getSymbol();
             	//ImageIcon image = new ImageIcon(temp);
                 System.out.print(board[i][j].getSymbol() + " ");
         }
         System.out.println();
     }
     System.out.println("  a b c d e f g h");
 }
}*/