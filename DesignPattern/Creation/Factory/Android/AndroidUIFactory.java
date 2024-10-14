package DesignPattern.Creation.Factory.Android;

import DesignPattern.Creation.Factory.Button;
import DesignPattern.Creation.Factory.Menu;
import DesignPattern.Creation.Factory.UIFactory;

public class AndroidUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }
}
