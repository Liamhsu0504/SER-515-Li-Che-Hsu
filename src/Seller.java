import javax.swing.*;
import java.awt.event.ActionEvent;
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
        JPanel panel = new JPanel();
        String Username = super.getUsername();
        ProductList productList = productList_map.get(Username);
        super.theProductMenu.showMenu();
        userLabel = new JLabel("Your cart : ");
        userLabel.setBounds(10,70, 80 ,25);
        this.add(userLabel);
        ReminderVisitor reminderVisitor = new ReminderVisitor();
        productList.accept(reminderVisitor, panel);
        this.add(panel);
        /*for(int index = 0; index < productList.size(); index++){
            Product p = productList.get(index);
            JLabel item = new JLabel(p.get_name());
            item.setBounds(10 + (index * 30), 10 , 80, 200);
            this.add(item);
        }*/
        JButton button_Logout = new JButton("Logout");
        button_Logout.setBounds(50,90,60,25);
        button_Logout.addActionListener(this::actionPerformed);
        panel.add(button_Logout);

        this.setSize(400, 300);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(panel);
    }

    private void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Logout")) {
            this.setVisible(false);
            try {
                Facade.getInstance().Login().setVisible(true);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void test() throws FileNotFoundException {

    }
}
