package CoreJava.Threading.ResourceSharing;

public class DataRace {

    public static void main(String[] args) {
        RaceCondition raceCondition = new RaceCondition();
       Thread th = new Thread(() -> {
           for(int i=0;i<Integer.MAX_VALUE;i++){
               raceCondition.increment();
           }
       });

       Thread th1 = new Thread(() -> {
           for(int i=0;i<Integer.MAX_VALUE;i++){
               raceCondition.checkForDataRace();
           }
       });

       th.start();
       th1.start();

    }



    public static class RaceCondition{
        private  volatile int x=0;
        private  volatile int y=0;

        public void increment(){
            x++;
            y++;
        }

        public void checkForDataRace(){
            if(y>x){
                System.out.println("Data Race condition exists x="+x+" y="+y);
            }
        }
    }
}
