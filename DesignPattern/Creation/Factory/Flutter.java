package DesignPattern.Creation.Factory;

public class Flutter {

    UIFactory uiFactory;

    Flutter(UIFactory uiFactory){
        this.uiFactory = uiFactory;
    }
    public void setTheme(){
        System.out.println("Theme set");
    }

    public void setRefreshRate(){
        System.out.println("Refresh rate");
    }

    public void pageLayout(){
        Button button= uiFactory.createButton();
        System.out.println(button.getClass().getName());

        Menu menu= uiFactory.createMenu();
        System.out.println(menu.getClass().getName());
    }
}
