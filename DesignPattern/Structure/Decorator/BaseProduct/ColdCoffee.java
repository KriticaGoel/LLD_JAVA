package DesignPattern.Structure.Decorator.BaseProduct;

public class ColdCoffee implements Beverage{
    @Override
    public String getDescription() {
        return "Cold Coffee";
    }

    @Override
    public int getCost() {
        return 150;
    }
}
