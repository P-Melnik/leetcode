package patterns.abstractFactory;

public class Application {
    private Button button;
    private CheckBox checkBox;

    Application(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void paint() {
        button.print();
        checkBox.print();
    }
}
