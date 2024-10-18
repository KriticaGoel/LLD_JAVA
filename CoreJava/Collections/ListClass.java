package CoreJava.Collections;

import java.util.ArrayList;
import java.util.List;

public class ListClass {

    public static void main(String[] args) {

        List<Integer> listInteger1 = new ArrayList<>();
        listInteger1.add(1);
        listInteger1.add(3);
        listInteger1.add(4);


        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(10);
        listInteger.add(30);
        listInteger.add(40);
        listInteger.add(1, 20);
        listInteger.add(4, 10);


        listInteger.addAll(new ArrayList<Integer>(listInteger1));
//        listInteger.addAll(2,new ArrayList<Integer>(listInteger1));

        Integer abc = listInteger.set(1, 20);//override previous element and return it
        System.out.println("Old value at index 1 is " + abc);

        listInteger.addFirst(30);
        listInteger.addLast(100);
        for (int i = 0; i < listInteger.size(); i++) {
            System.out.println("Element at index " + i + " is " + listInteger.get(i));
        }
        System.out.println("TOTAL SIZE " + listInteger.size());
        System.out.println("The first occurrence of 10 is at index  " + listInteger.indexOf(10));
        System.out.println("The last occurrence of 10 is at index  " + listInteger.lastIndexOf(10));
        System.out.println("Removed element at index 3 is  " + listInteger.remove(3));
        System.out.println("The first occurrence of 10 is at index  " + listInteger.indexOf(10));
        System.out.println("The last occurrence of 10 is at index  " + listInteger.lastIndexOf(10));
        System.out.println("Remove element 10 first occurrence " + listInteger.remove((Integer) 10));
        System.out.println("0th element of the list " + listInteger.getFirst());
        System.out.println("Last element of the list " + listInteger.getLast());

        for (int i = 0; i < listInteger.size(); i++) {
            System.out.println("Element at index " + i + " is " + listInteger.get(i));
        }
        listInteger.clear();
        for (int i = 0; i < listInteger.size(); i++) {
            System.out.println(listInteger.get(i));
        }
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(integers.subList(3, 6));
        System.out.println(integers.reversed());
        System.out.println(List.of(1, 2, 3, 4, 5, 6));

    }
}
