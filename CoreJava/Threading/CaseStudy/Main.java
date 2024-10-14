package CoreJava.Threading.CaseStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Vault vault = new Vault(random.nextInt(999));

        List<Thread> threads = new ArrayList<>();
        threads.add(new Hacker1(vault));
        threads.add(new Hacker2(vault));
        threads.add(new Police());

        for(Thread thread : threads) {
          //  System.out.println(thread.getName()+"going to start");
            thread.start();
        }

    }
}
