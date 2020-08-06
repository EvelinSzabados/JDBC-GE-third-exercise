import View.UserInterface;

import javax.sql.DataSource;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserInterface ui = new UserInterface(System.in, System.out);
        new Main(ui).run();
    }

    UserInterface ui;

    Main(UserInterface ui) {
        this.ui = ui;
    }

    private void run() throws SQLException {

        boolean running = true;

        while (running) {
            ui.printTitle("Menü");
            ui.printOption('a', "4.legtöbb felvételt készítő gép");
            ui.printOption('b', "Legzsúfoltabb nap");
            ui.printOption('c', "Átlagos képkészítési idő  képtípusonként");
            ui.printOption('d', "Legmagasabb a diagnosztikai eredményességű adattípus");
            ui.printOption('q', "Kilépés");
            switch (ui.choice("abcdq")) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                    ui.println("Folyamatban...");
                    break;
                case 'q':
                    running = false;
                    break;
            }
        }
    }
    private DataSource connect() throws SQLException {
        //SQL Connection
      return null;
    }
}
