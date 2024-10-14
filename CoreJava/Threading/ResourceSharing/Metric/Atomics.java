package CoreJava.Threading.ResourceSharing.Metric;

import java.util.Random;

public class Atomics {

    public static void main(String[] args) {
        Metric metric = new Metric();
        BusinessLogic businessLogic = new BusinessLogic(metric);
        BusinessLogic businessLogic2 = new BusinessLogic(metric);
        MetricPrinter metricPrinter = new MetricPrinter(metric);

        businessLogic.start();
        businessLogic2.start();
        metricPrinter.start();
    }

    public static class MetricPrinter extends Thread {
        Metric metric;

        public MetricPrinter(Metric metric){
            this.metric = metric;
        }

        @Override
        public void run() {
         while(true){
             System.out.println(metric.getAverage());
         }
        }

    }

    public static class BusinessLogic extends Thread {
        Metric metric;
        Random random= new Random();

        public BusinessLogic(Metric metric) {
            this.metric=metric;
        }

        @Override
        public void run() {
            while (true) {
                long startTime = System.currentTimeMillis();
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                long endTime = System.currentTimeMillis();
                metric.addSample(endTime - startTime);
            }
        }
    }


    public static class Metric {
        private volatile long count=0;
        private volatile double average=0.0;

        public synchronized void addSample(long sample){
            double currentSample= average*count;
            count++;
            average=(currentSample+sample)/count;
        }

        public double getAverage(){
            return average;
        }


    }
}
