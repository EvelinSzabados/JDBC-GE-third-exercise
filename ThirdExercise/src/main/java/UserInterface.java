import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    PrintStream out;
    String RESET = "\u001B[0m";
    String GREEN = "\u001B[92m";
    String BLUE = "\u001B[94m";

    public UserInterface(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public void println(Object obj) {
        out.println(GREEN + obj + RESET);
    }

    public void printTitle(String title) {
        out.println(BLUE + "\n -- " + title + " --" + RESET);
    }

    public void printOption(char option, String description) {
        out.println("(" + option + ")" + " " + description);
    }

    public char choice(String options) {
        String line;
        do {
            out.print(BLUE + "Options [" + options + "]: " + RESET);
            line = scanner.nextLine();
        } while (!(line.length() == 1 && options.contains(line)));
        return line.charAt(0);
    }

    private void printPrompt(String prompt, Object defaultValue) {
        System.out.print(prompt + " [" + defaultValue + "]: ");
    }
}
