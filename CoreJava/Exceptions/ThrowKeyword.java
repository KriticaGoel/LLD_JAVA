package CoreJava.Exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThrowKeyword {
    public static void main(String[] args) {
        getPlayerScore(new String());
        try {
            getPlayerScores("abcd");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getPlayerScore(String playerFile) {
        if (playerFile == null || playerFile.isEmpty()) {
            //throwing custom exception
            //throw new IllegalArgumentException("Player file cannot be null");
            throw new MyException("Player file cannot be null");
        }
        System.out.println(playerFile);
    }

    public static int getPlayerScores(String playerFile) throws FileNotFoundException {
        Scanner contents = new Scanner(new File(playerFile));
        return Integer.parseInt(contents.nextLine());
    }
}
