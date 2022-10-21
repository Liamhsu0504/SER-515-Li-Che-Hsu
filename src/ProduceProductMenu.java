import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

public class ProduceProductMenu extends  JFrame implements ProductMenu{
    private static Person person;
    JMenu menu_produce = new JMenu(" Choose_Products");
    JButton switch_productmenu = new JButton("Switch to Meat Menu");
    private ProductList productList;
    public ProduceProductMenu(Person person) {
        this.person = person;
    }
    @Override
    public void showMenu(JPanel panel) throws FileNotFoundException {
        productList = Facade.getInstance().getProductList();
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(10, 100, 150, 30);
        setJMenuBar(menuBar);
        menu_produce.setBounds(10,10, 150, 10);
        menuBar.add(menu_produce);
        ProductIterator iterator = new ProductIterator(productList);
        while(iterator.hasNext()){
            Product p = iterator.Next();
            if(p.get_type().equals("Produce")){
                JCheckBoxMenuItem item = new JCheckBoxMenuItem(p.get_name());
                menu_produce.add(item);
            }
        }
        switch_productmenu.setBounds(10,50, 180,20);
        switch_productmenu.addActionListener(this::actionPerformed);
        menu_produce.setVisible(true);
        switch_productmenu.setVisible(true);
        panel.add(menuBar);
        panel.add(switch_productmenu);
        person.add(panel);
        panel.setLayout(null);
    }

    private void actionPerformed(ActionEvent actionEvent) {
        try{
            menu_produce.setVisible(false);
            switch_productmenu.setVisible(false);
            person.dispose();
            person.theProductMenu = new MeatProductMenu(person);
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
