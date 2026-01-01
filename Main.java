package Project2;

//Main.java
public class Main {
 public static void main(String[] args) {
     javax.swing.SwingUtilities.invokeLater(() -> {
         ChessGUI gui = new ChessGUI(new Game());
         gui.setVisible(true);
     });
 }
}
