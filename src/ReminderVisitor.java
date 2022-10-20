import javax.swing.*;

public class ReminderVisitor extends NodeVisitor {
    private static Person person;
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
            panel.add(item);
            panel.setBounds(90 + (index * 30), 80 , 80, 200);
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
