package CoreJava.Threading.CaseStudy;

public class Hacker1 extends Hacker{


    public Hacker1(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for(int i=0;i<=999;i++){
            if(vault.isCorrect(i)){
                System.out.println("Correct Password "+i+" is guess by thread "+this.getName());
                System.exit(0);
            }
        }
    }
}
