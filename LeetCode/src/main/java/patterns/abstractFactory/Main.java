package patterns.abstractFactory;

public class Main {

    private static Application configureApp() {
        Application app;
        GUIFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOsGUIFactory();
        } else {
            factory = new WindowsGUIFactory();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {

        Application app = configureApp();
        app.paint();
    }
}
