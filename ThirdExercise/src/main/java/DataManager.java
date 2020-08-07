import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManager {

    private Connection conn;

    public DataManager(Connection conn) {
        this.conn = conn;
    }

    public String get4thBusiestMachine() throws SQLException {

        String query = "SELECT device.name, COUNT(*) AS count FROM device " +
                "INNER JOIN study ON study.ae_key = device.id " +
                "GROUP BY device.name " +
                "ORDER BY count DESC " +
                "LIMIT 3,1;";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.first();

        return rs.getString("name");
    }

    public String getBusiestDay() throws SQLException {

        String query = "SELECT DATE_FORMAT(study_datetime,'%Y-%m-%d') as day," +
                "COUNT(*) as count FROM study ORDER BY count DESC LIMIT 1;";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.first();
        return rs.getDate("day").toString();
    }

    public String getAverageSeriesDurationPerSeriesType() throws SQLException {

        String query = "SELECT series_type, " +
                "TRUNCATE(AVG(series_duration),2) AS average " +
                "FROM serie " +
                "GROUP BY series_type;";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        StringBuilder result = new StringBuilder();

        while (rs.next()) {
            result.append(rs.getString("series_type"))
                    .append(": ").append(rs.getDouble("average")).append("\n");
        }
        return result.toString();
    }

    public String getDataTypeWithHighestDiagnostic() throws SQLException {
        String query = "SELECT device.data_type, COUNT(*) AS count FROM device " +
                "INNER JOIN study ON study.ae_key = device.id " +
                "INNER JOIN serie ON study.id = serie.study_key " +
                "WHERE serie.diagnostic = 'Y' " +
                "GROUP BY device.data_type " +
                "ORDER BY count DESC LIMIT 1;";

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.first();

        return rs.getString("data_type") + ": " + rs.getInt("count");
    }

}
