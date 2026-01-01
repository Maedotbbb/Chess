package Project2;

//import java.util.HashMap;
import java.util.Scanner;

//Game.java
public class Game {
 public Board board;
 private boolean whiteTurn;
 //HashMap<String, String> moveCount = new HashMap<String, String>();
 
 public Game() {
     board = new Board();
     whiteTurn = true;
 }

 public Piece getPiece(int row, int col) {
     return board.board[row][col];
 }

 public boolean isWhiteTurn() {
     return whiteTurn;
 }

 public boolean tryMove(int startX, int startY, int endX, int endY) {
	    Piece selected = board.board[startX][startY];
	    if (selected == null || selected.isWhite() != whiteTurn) return false;
	    if (!selected.isValidMove(startX, startY, endX, endY, board.board)) return false;

	    // Move the piece
	    board.board[endX][endY] = selected;
	    board.board[startX][startY] = null;

	    // Pawn promotion
	    if (selected instanceof Pawn) {
	        if ((selected.isWhite() && endX == 0) || (!selected.isWhite() && endX == 7)) {
	            promotePawn(endX, endY);
	        }
	    }

	    whiteTurn = !whiteTurn;
	    return true;
	}
 private void promotePawn(int x, int y) {
	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Pawn promotion! Choose [Q]ueen, [R]ook, [B]ishop, or [N]ight:");
	    char choice = scanner.next().charAt(0);
	    boolean isWhite = board.board[x][y].isWhite();

	    switch (choice) {
	        case 'Q':
	            board.board[x][y] = new Queen(isWhite);
	            break;
	        case 'R':
	            board.board[x][y] = new Rook(isWhite);
	            break;
	        case 'B':
	            board.board[x][y] = new Bishop(isWhite);
	            break;
	        case 'N':
	            board.board[x][y] = new Knight(isWhite);
	            break;
	        default:
	            System.out.println("Invalid choice. Defaulting to Queen.");
	            board.board[x][y] = new Queen(isWhite);
	            break;
	    }
	    scanner.close();
	}
}