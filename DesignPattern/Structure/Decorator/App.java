package DesignPattern.Structure.Decorator;

import DesignPattern.Structure.Decorator.Addon.Moha;
import DesignPattern.Structure.Decorator.BaseProduct.Beverage;
import DesignPattern.Structure.Decorator.BaseProduct.Capicono;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter which cofee you want to have \n 1. Capicono \n 2.Coldcoffee \n 3.Expresso");
//
//        String Coffee = myObj.nextLine();  // Read user input
//        System.out.println("Coffee choiced by you is: " + userName);  // Output user input

        Beverage beverage = new Capicono();
        System.out.println(beverage.getCost());

        beverage = new Moha(beverage);
        System.out.println(beverage.getDescription());
        System.out.println(beverage.getCost());

    }
}
