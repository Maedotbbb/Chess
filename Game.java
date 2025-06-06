package Project;

//Game.java
import java.util.Scanner;

public class Game {
 private Board board;
 private boolean whiteTurn;

 public Game() {
     board = new Board();
     whiteTurn = true;
 }

 public void start() {
     Scanner scanner = new Scanner(System.in);
     while (true) {
         board.printBoard();
         System.out.println((whiteTurn ? "White" : "Black") + "'s move (e.g. e2 e4):");
         String move = scanner.nextLine();
         if (move.equals("exit")) break;

         String[] parts = move.split(" ");
         if (parts.length != 2) {
             System.out.println("Invalid input. Try again.");
             continue;
         }

         int startX = 8 - Character.getNumericValue(parts[0].charAt(1));
         int startY = parts[0].charAt(0) - 'a';
         int endX = 8 - Character.getNumericValue(parts[1].charAt(1));
         int endY = parts[1].charAt(0) - 'a';

         if (startX < 0 || startY < 0 || endX < 0 || endY < 0 ||
             startX > 7 || startY > 7 || endX > 7 || endY > 7) {
             System.out.println("Move out of bounds. Try again.");
             continue;
         }

         Piece selected = board.board[startX][startY];
         if (selected == null || selected.isWhite() != whiteTurn) {
             System.out.println("Invalid piece selection.");
             continue;
         }

         if (selected.isValidMove(startX, startY, endX, endY, board.board)) {
             board.board[endX][endY] = selected;
             board.board[startX][startY] = null;
             whiteTurn = !whiteTurn;
         } else {
             System.out.println("Invalid move.");
         }
     }
 }
}









/*



 // Game.java
import java.util.Scanner;

public class Game {
    private Board board;
    private boolean whiteTurn;

    public Game() {
        board = new Board();
        whiteTurn = true;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            board.printBoard();
            System.out.println((whiteTurn ? "White" : "Black") + "'s move (e.g. e2 e4):");
            String move = scanner.nextLine();
            if (move.equals("exit")) break;
            
            // move with a word
            String[] parts = move.split(" "); // example: parts[0]=e2 , parts[1]=e4
            if (parts.length != 2) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            int startX = 8 - Character.getNumericValue(parts[0].charAt(1)); // here we can't use (int) because it will gets the asciiValue
            int startY = parts[0].charAt(0) - 'a'; // e - a = 4 which is correct bc e==5 and we start from 0
            int endX = 8 - Character.getNumericValue(parts[1].charAt(1)); // we're converting from character number to an int, not from a char like 'd'
            int endY = Character.getNumericValue(parts[1].charAt(0))-1; 

            if (!isValidCoordinate(startX, startY) || !isValidCoordinate(endX, endY)) {
                System.out.println("Move out of bounds. Try again.");
                continue;
            }

            Piece selected = board.board[startX][startY];
            if (selected == null || selected.isWhite() != whiteTurn) {
                System.out.println("Invalid piece selection.");
                continue;
            }

            if (selected.isValidMove(startX, startY, endX, endY, board.board)) {
                board.board[endX][endY] = selected;
                board.board[startX][startY] = null;
                whiteTurn = !whiteTurn;
            } else {
                System.out.println("Invalid move.");
            }
        }
        scanner.close();
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}

*/
