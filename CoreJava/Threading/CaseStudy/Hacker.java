package CoreJava.Threading.CaseStudy;

public abstract class Hacker extends Thread {
    Vault vault;
    public Hacker(Vault vault) {
        this.vault = vault;
        this.setName(this.getClass().getSimpleName());
        this.setPriority(Thread.MAX_PRIORITY);
    }

    @Override
    public void start() {
        System.out.println(this.getName()+ " thread started");
        super.start();
    }
}
