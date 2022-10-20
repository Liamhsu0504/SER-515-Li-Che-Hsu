import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MeatProductMenu extends JFrame implements ProductMenu, ActionListener {
    private ProductList productList;
    JMenuBar menuBar = new JMenuBar();
    JMenu menu_meat = new JMenu(" Choose_Meats");
    JButton switch_productmenu = new JButton("Switch to Produce Menu");
    private static Person person;
    public MeatProductMenu(Person person) {
        this.person = person;
    }

    @Override
    public void showMenu(JPanel panel) throws FileNotFoundException {
        //JPanel panel = new JPanel();
        productList = Facade.getInstance().getProductList();
        menuBar.setBounds(10, 100, 150, 30);
        setJMenuBar(menuBar);
        menu_meat.setBounds(10,10, 150, 10);
        menuBar.add(menu_meat);
        menu_meat.setText("Choose_Meats");
        ProductIterator iterator = new ProductIterator(productList);
        while(iterator.hasNext()){
            Product p = iterator.Next();
            if(p.get_type().equals("Meat")){
                JCheckBoxMenuItem item = new JCheckBoxMenuItem(p.get_name());
                menu_meat.add(item);
            }
        }
        switch_productmenu.setBounds(10,50, 180,20);
        switch_productmenu.addActionListener(this);
        panel.add(menuBar);
        menuBar.setVisible(true);
        switch_productmenu.setVisible(true);
        panel.add(switch_productmenu);
        person.add(panel);
        panel.setLayout(null);
        //menuBar.setVisible(false);
    }

    public void actionPerformed(ActionEvent e) {
        try{
            menu_meat.setVisible(false);
            switch_productmenu.setVisible(false);
            person.dispose();
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
