package DesignPattern.Creation.Factory;

import DesignPattern.Creation.Factory.Android.AndroidUIFactory;
import DesignPattern.Creation.Factory.IOS.IOSUIFactory;

public class App {
    public static void main(String[] args) {
        UIFactory androidUIFactory = new AndroidUIFactory();
        UIFactory iosUIFactory = new IOSUIFactory();
//        System.out.println(androidUIFactory.createButton());
//        System.out.println(androidUIFactory.createMenu());
//
//
//        System.out.println(iosUIFactory.createButton());
//        System.out.println(iosUIFactory.createMenu());

        Flutter flutter = new Flutter(androidUIFactory);
        flutter.setTheme();
        flutter.setRefreshRate();
        flutter.pageLayout();

        Flutter flutterIOS = new Flutter(iosUIFactory);
        flutterIOS.pageLayout();
    }
}
