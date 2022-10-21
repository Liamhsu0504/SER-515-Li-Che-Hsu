import java.io.FileNotFoundException;

public class Main {
    /**
        Design Pattern : Facade Pattern
        The main.java can access the system only call the Facade.java.
    */
    public static void main(String[] args) throws FileNotFoundException {
        Facade start = Facade.getInstance();
    }
}