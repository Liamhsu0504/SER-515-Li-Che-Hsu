import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MeatProductMenu extends JFrame implements ProductMenu{
    private ProductList productList;
    //private JMenuBar menu_bar;
    //private JMenu menu_meat;
    private static Person person;
    public MeatProductMenu(Person person) {
        this.person = person;
    }

    @Override
    public void showMenu() throws FileNotFoundException {
        productList = Facade.getInstance().getProductList();
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(10, 10, 150, 30);
        setJMenuBar(menuBar);
        JMenu menu_meat = new JMenu(" Choose_Meats");
        menu_meat.setBounds(10,10, 150, 10);
        menuBar.add(menu_meat);
        for(int i = 0; i < productList.size(); i++){
            Product p = productList.get(i);
            if(p.get_type().equals("Meat")){
                JCheckBoxMenuItem item = new JCheckBoxMenuItem(p.get_name());
                menu_meat.add(item);
            }
        }
        JButton switch_productmenu = new JButton("Switch to Produce Menu");
        switch_productmenu.setBounds(10,50, 180,20);
        switch_productmenu.addActionListener(this::actionPerformed);
        person.add(switch_productmenu);
        person.add(menuBar);
        System.out.print(menuBar);
    }

    private void actionPerformed(ActionEvent actionEvent) {
        try{
            JMenuBar menubar = person.getJMenuBar();
            System.out.print(menubar);
            menubar.setVisible(false);
            person.theProductMenu = new ProduceProductMenu(person);
            person.showMenu();
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
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
