package View;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UserInterface {
    Scanner scanner;
    PrintStream out;

    public UserInterface(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public void println(Object obj) {
        out.println(obj);
    }

    public void printTitle(String title) {
        out.println("\n -- " + title + " --");
    }

    public void printOption(char option, String description) {
        out.println("(" + option + ")" + " " + description);
    }

    public char choice(String options) {
        String line;
        do {
            out.print("Opciók [" + options + "]: ");
            line = scanner.nextLine();
        } while (!(line.length() == 1 && options.contains(line)));
        return line.charAt(0);
    }

    public String readString(String prompt, String defaultValue) {
        printPrompt(prompt, defaultValue);
        String line = scanner.nextLine();
        return line.isEmpty() ? defaultValue : line;
    }

    private void printPrompt(String prompt, Object defaultValue) {
        System.out.print(prompt + " [" + defaultValue + "]: ");
    }
}
