package CoreJava.Generics.GenericClassMethod;

import java.math.BigInteger;
import java.util.Optional;

public class Main {

    public static <K, V, Z> Z adder(K key, V value) {
        System.out.println("key: " + key + " value: " + value);
        return (Z) BigInteger.ONE;
    }

    public static void main(String[] args) {

        Pair oldP = new Pair(1.0, 2.0);
        Double oldKey = (Double) oldP.getKey();
        System.out.println(oldKey);
        System.out.println(oldP.getValue());


        Pair<Double, Double> p = new Pair(1.0, 2.0);
        Double key = p.getKey();
        System.out.println(key);
        System.out.println(p.getValue());

        System.out.println(Optional.ofNullable(adder("Kritica", "Goel")));

    }
}
