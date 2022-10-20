import javax.swing.*;

public abstract class NodeVisitor {
    public abstract void visited(ProductList productList, JPanel panel);
    public abstract  void visitTrading();
    public  abstract  void visitFacade();
}
