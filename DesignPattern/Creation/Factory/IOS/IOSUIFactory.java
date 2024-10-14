package DesignPattern.Creation.Factory.IOS;

import DesignPattern.Creation.Factory.Button;
import DesignPattern.Creation.Factory.Menu;
import DesignPattern.Creation.Factory.UIFactory;

public class IOSUIFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}
