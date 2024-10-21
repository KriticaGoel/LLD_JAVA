package CoreJava.Stream;

import java.util.List;

public class StreamsPractice {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.forEach(System.out::println);
        numbers.stream().findFirst().ifPresent(System.out::println);
    }

}
