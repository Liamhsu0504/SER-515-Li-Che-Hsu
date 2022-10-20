import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.Map;

public class Buyer extends Person{
    ProductList productList;
    public Buyer(String username, String password) {
        super(username, password);
    }
    public void showMenu() throws FileNotFoundException {
        Map<String, ProductList> productList_map = Facade.getInstance().getBuyer_ProductList();
        JPanel panel = new JPanel();
        String Username = super.getUsername();
        if(productList_map.get(Username) == null){
            productList_map.put(Username, new ProductList());
        }
        productList = productList_map.get(Username);
        super.theProductMenu.showMenu(panel);
        ReminderVisitor reminderVisitor = new ReminderVisitor();
        productList.accept(reminderVisitor, panel);
        this.add(panel);

        JButton button_Logout = new JButton("Logout");
        button_Logout.setBounds(10,190,100,25);
        button_Logout.addActionListener(this::actionPerformed);
        panel.add(button_Logout);

        this.setSize(800, 400);
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
}
