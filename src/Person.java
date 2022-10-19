import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public abstract class Person extends JFrame {

    public ProductMenu theProductMenu;
    private String username;
    private String password;
    private static ProductList productList;

    public Person(String username, String password){
        this.username = username;
        this.password = password;
        this.theProductMenu = new MeatProductMenu(this);
    }
    /*public void setUserType(int UserType) {
        this.UserType = UserType;
    }*/

    public String getUsername () {
        return this.username;
    }

    public abstract void showMenu() throws FileNotFoundException;

    public abstract void test() throws FileNotFoundException;

    public void showAddButton() {

    }
    public void showViewButton() {

    }
    public void showRadioButton() {

    }
    public void showLabels() {

    }
}
