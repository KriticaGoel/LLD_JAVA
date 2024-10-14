package DesignPattern.Structure.Decorator.BaseProduct;

public class Capicono implements Beverage{
    @Override
    public String getDescription() {
        return "Capicino coffee";
    }

    @Override
    public int getCost() {
        return 100;
    }
}
