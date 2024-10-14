package DesignPattern.Structure.Decorator.Addon;

import DesignPattern.Structure.Decorator.BaseProduct.Beverage;

public class Whip implements Beverage {

    Beverage b;
    public Whip(Beverage b) {
        this.b = b;
    }

    @Override
    public String getDescription() {
        return b.getDescription()+" added with Whipped cream";
    }

    @Override
    public int getCost() {
        return 5+b.getCost();
    }
}
