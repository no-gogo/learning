import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        String[][] board = new String[8][8];
        stillRed(board); 
    }

    public static boolean stillRed(String[][] board) {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                if (board[r][c] != null && board[r][c].equals("red")) {
                    return true;
                }
            }
        }
        return false;
    }
}