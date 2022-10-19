import javax.swing.*;
import java.io.FileNotFoundException;

public class Seller extends Person {

    public Seller(String username, String password) {
        super(username, password);
    }
    private static JLabel userLabel;
    private  static JButton button;
    @Override
    public void showMenu() throws FileNotFoundException {
        Facade facade = Facade.getInstance();
        String Username = super.getUsername();
        super.theProductMenu.showMenu();
        userLabel = new JLabel("ProductList");
        userLabel.setBounds(10,10, 80 ,25);
        this.add(userLabel);



        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void test() throws FileNotFoundException {

    }
}
