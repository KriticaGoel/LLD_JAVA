package CoreJava.Threading.CaseStudy;

public class Police extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
        System.out.println("Game over for you.");
        System.exit(0);
    }
}
