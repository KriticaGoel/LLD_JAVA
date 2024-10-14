package DesignPattern.Structure.Decorator.Addon;

import DesignPattern.Structure.Decorator.BaseProduct.Beverage;

public class Moha implements Beverage {
    Beverage b;

    public Moha(Beverage b) {
        this.b = b;
    }

    @Override
    public String getDescription() {
        return b.getDescription()+" added with moha";
    }

    @Override
    public int getCost() {
        return 10+b.getCost();
    }
}
