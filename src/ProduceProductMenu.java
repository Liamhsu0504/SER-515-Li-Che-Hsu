import javax.swing.*;
import java.io.FileNotFoundException;

public class ProduceProductMenu extends  JFrame implements ProductMenu{
    private static Person person;
    private ProductList productList;
    public ProduceProductMenu(Person person) {
        this.person = person;
    }
    @Override
    public void showMenu() throws FileNotFoundException {
        productList = Facade.getInstance().getProductList();
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(10, 10, 150, 30);
        setJMenuBar(menuBar);
        JMenu menu_meat = new JMenu(" Choose_Products");
        menu_meat.setVisible(true);
        menu_meat.setBounds(10,10, 150, 10);
        menuBar.add(menu_meat);
        for(int i = 0; i < productList.size(); i++){
            Product p = productList.get(i);
            if(p.get_type().equals("Produce")){
                JCheckBoxMenuItem item = new JCheckBoxMenuItem(p.get_name());
                menu_meat.add(item);
            }
        }
        person.add(menuBar);
        JButton switch_productmenu = new JButton("Switch to Meat Menu");
        switch_productmenu.setBounds(10,50, 180,20);
        //switch_productmenu.addActionListener(this::actionPerformed);
        person.add(switch_productmenu);
    }

    @Override
    public void showAddButton() {

    }

    @Override
    public void showViewButton() {

    }

    @Override
    public void showRadioButton() {

    }

    @Override
    public void showLabels() {

    }

    @Override
    public void showComboxes() {

    }
}
