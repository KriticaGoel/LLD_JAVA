package Coupling.loose;

public class DatabaseSql implements FetchData {
    @Override
    public String getUsers() {
        return "Data fetch from Sql";
    }
}
