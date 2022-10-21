import javax.swing.*;
/**
 * Design Pattern : Visitor Pattern
 * The functions that are provided for visitors to visit
 */
public abstract class NodeVisitor {
    public abstract void visited(ProductList productList, JPanel panel);
    public abstract  void visitTrading();
    public  abstract  void visitFacade();
}
