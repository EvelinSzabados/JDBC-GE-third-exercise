import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        UserInterface ui = new UserInterface(System.in, System.out);
        Connection conn = connect();
        DataManager dataManager = new DataManager(conn);
        new Main(ui, dataManager).run();

    }

    UserInterface ui;
    DataManager dataManager;

    Main(UserInterface ui, DataManager dataManager) throws SQLException {
        this.ui = ui;
        this.dataManager = dataManager;
    }

    private void run() throws SQLException {

        boolean running = true;

        while (running) {
            ui.printTitle("Menu");
            ui.printOption('a', "Get the 4th busiest machine");
            ui.printOption('b', "Get the busiest day");
            ui.printOption('c', "Get average series duration/series type");
            ui.printOption('d', "Get data type w/ highest diagnostic value");
            ui.printOption('q', "Exit");
            switch (ui.choice("abcdq")) {
                case 'a':
                    ui.println(dataManager.get4thBusiestMachine());
                    break;
                case 'b':
                    ui.println(dataManager.getBusiestDay());
                    break;
                case 'c':
                    ui.println(dataManager.getAverageSeriesDurationPerSeriesType());
                    break;
                case 'd':
                    ui.println(dataManager.getDataTypeWithHighestDiagnostic());
                    break;
                case 'q':
                    running = false;
                    ui.println("See you next time!");
                    break;
            }
        }
    }

    private static Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mariadb://localhost/dwh", "evelin", "password");
    }
}
