package DesignPattern.Structure.Decorator.Addon;

import DesignPattern.Structure.Decorator.BaseProduct.Beverage;

public class ChocolateScryp implements Beverage {
    Beverage b;
    public ChocolateScryp(Beverage b) {
        this.b = b;
    }
    @Override
    public String getDescription() {
        return b.getDescription()+" added with chocolate scryp";
    }

    @Override
    public int getCost() {
        return 20+b.getCost();
    }
}
