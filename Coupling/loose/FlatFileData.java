package Coupling.loose;

public class FlatFileData implements FetchData{

    @Override
    public String getUsers() {
        return "Data from flat file";
    }
}
