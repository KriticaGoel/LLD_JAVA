package Coupling.loose;

public class Client {

    public static void main(String[] args) {
        // Creating object of database and storing in inteface fetch Data
        FetchData fetchDataFromDB = new DatabaseSql();
        Service service = new Service(fetchDataFromDB);
        System.out.println(service.getUserService());

        FetchData fetchDataWebservice = new WebserviceData();
        Service webService = new Service(fetchDataWebservice);
        System.out.println(webService.getUserService());

        FetchData fetchDataflatFile = new FlatFileData();
        Service flatService = new Service(fetchDataflatFile);
        System.out.println(flatService.getUserService());
    }
}
