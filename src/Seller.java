import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Map;

public class Seller extends Person {

    public Seller(String username, String password) {
        super(username, password);
    }
    private static JLabel userLabel;
    private  static JButton button;
    @Override
    public void showMenu() throws FileNotFoundException {
        Map<String, ProductList> productList_map = Facade.getInstance().getSeller_ProductList();
        String Username = super.getUsername();
        ProductList productList = productList_map.get(Username);
        super.theProductMenu.showMenu();
        userLabel = new JLabel("Your cart : ");
        userLabel.setBounds(10,70, 80 ,25);
        this.add(userLabel);
        for(int i = 0; i < productList.size(); i++){
            Product p = productList.get(i);
            JLabel item = new JLabel(p.get_name());
            item.setBounds(10 + (i * 50), 10 , 80, 200);
            this.add(item);
            System.out.print(p.get_name() + i);
        }


        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void test() throws FileNotFoundException {

    }
}
