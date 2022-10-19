import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class MeatProductMenu extends JFrame implements ProductMenu{
    private ProductList productList;
    private static Person person;
    public MeatProductMenu(Person person) {
        this.person = person;
    }

    @Override
    public void showMenu() throws FileNotFoundException {
        productList = Facade.getInstance().getProductList();
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(10, 10, 60, 30);
        setJMenuBar(menuBar);
        JMenu menu_meat = new JMenu("Meats");
        menu_meat.setBounds(10,10, 10, 10);
        menuBar.add(menu_meat);
        for(int i = 0; i < productList.size(); i++){
            Product p = productList.get(i);
            System.out.print(p.get_name());
            if(p.get_type().equals("Meat")){
                JCheckBoxMenuItem item = new JCheckBoxMenuItem(p.get_name());
                menu_meat.add(item);
                System.out.print(p.get_name() + i);
            }
        }
        person.add(menuBar);
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
