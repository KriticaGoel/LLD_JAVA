package Coupling.loose;

public class Service {
    private FetchData fetchData;

    Service(FetchData fetchData) {
        this.fetchData = fetchData;
    }

    public String getUserService(){
        return fetchData.getUsers();
    }
}
