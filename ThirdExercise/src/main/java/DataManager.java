import java.sql.Connection;

public class DataManager {

    private Connection conn;


    public DataManager(Connection conn){
        this.conn = conn;
    }

    public String get4thBusiestMachine(){
        return "Busiest machine is: ";
    }

    public String getBusiestDay(){
        return "Busiest day is: ";
    }
    public String getAverageSeriesDurationPerSeriesType(){
        return "Average series duration:";
    }

    public String getDataTypeWithHighestDiagnostic(){
        return "Data type with highest diagnostic: ";
    }

}
