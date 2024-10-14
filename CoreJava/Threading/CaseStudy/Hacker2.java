package CoreJava.Threading.CaseStudy;

public class Hacker2 extends Hacker{

    public Hacker2(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for(int i=999;i>=0;i--){
            if(vault.isCorrect(i)){
                System.out.println("Correct Password "+i+" is guess by thread "+this.getName());
                System.exit(0);
            }
        }
    }
}
