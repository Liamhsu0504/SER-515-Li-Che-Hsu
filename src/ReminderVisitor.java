import javax.swing.*;
/**
 * Design Pattern: Visitor Pattern
 * A user can know what products they actually have, the products would display on the flame
 */
public class ReminderVisitor extends NodeVisitor {
    @Override
    public void visited(ProductList productList, JPanel panel) {
        ProductIterator productIterator = new ProductIterator(productList);
        JLabel userLabel = new JLabel("Your cart : ");
        userLabel.setBounds(10,10, 80 ,25);
        panel.add(userLabel);
        int index = 0;
        while (productIterator.hasNext()){
            Product p = productIterator.Next();
            JLabel item = new JLabel(p.get_name());
            item.setBounds(100 + (index * 50), 10 , 80, 25);
            panel.add(item);
            System.out.print(p.get_name());
            index++;
        }
    }

    @Override
    public void visitTrading() {

    }

    @Override
    public void visitFacade() {

    }
}
