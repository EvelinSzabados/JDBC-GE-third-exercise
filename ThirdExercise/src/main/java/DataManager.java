import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private Connection conn;

    public DataManager(Connection conn) {
        this.conn = conn;
    }

    public String get4thBusiestMachine() throws SQLException {

        String query = "SELECT device.name, COUNT(*) AS count FROM device " +
                "INNER JOIN study ON study.ae_key = device.device_key " +
                "GROUP BY device.name " +
                "ORDER BY count DESC " +
                "LIMIT 4;";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        List<String> busiestMachines = new ArrayList<String>();
        while (rs.next()) {
            busiestMachines.add(rs.getString("name"));
        }

        return busiestMachines.get(3);
    }

    public String getBusiestDay() {
        return "Busiest day is: ";
    }

    public String getAverageSeriesDurationPerSeriesType() {
        return "Average series duration:";
    }

    public String getDataTypeWithHighestDiagnostic() {
        return "Data type with highest diagnostic: ";
    }

}
