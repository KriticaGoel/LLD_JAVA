package DesignPattern.Structure.Decorator.Addon;

import DesignPattern.Structure.Decorator.BaseProduct.Beverage;

public class Icecream implements Beverage {

    Beverage b;

    Icecream(Beverage beverage) {
        b = beverage;
    }

    @Override
    public String getDescription() {
        return b.getDescription()+" added with Icecream";
    }

    @Override
    public int getCost() {
        return 50+b.getCost();
    }
}
