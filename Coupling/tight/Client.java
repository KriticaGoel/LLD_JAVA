package Coupling.tight;

public class Client {
    public static void main(String[] args) {
        Service service = new Service();
//        System.out.println(service.getUsersfromDB());
        System.out.println(service.getUsersfromWebservice());
    }
}
