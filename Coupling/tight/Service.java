package Coupling.tight;

public class Service {

    //DatabaseSql sql = new DatabaseSql();
WebserviceData web = new WebserviceData();
//    public String getUsersfromDB(){
//        return sql.getUsers();
//    }

    public String getUsersfromWebservice(){
        return web.getWBUsers();
    }
}
