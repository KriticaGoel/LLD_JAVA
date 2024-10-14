package DesignPattern.Structure.Decorator.BaseProduct;

public class Expresso implements Beverage{


    @Override
    public String getDescription() {
        return "Expresso Coffee";
    }

    @Override
    public int getCost() {
        return 50;
    }
}
