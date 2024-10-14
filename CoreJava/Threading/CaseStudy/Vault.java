package CoreJava.Threading.CaseStudy;

public class Vault {
    public int password;
    public Vault(int password) {
        this.password = password;
    }

    public boolean isCorrect(int password)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.password == password;
    }
}
