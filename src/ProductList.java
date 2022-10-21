import javax.swing.*;
import java.util.ArrayList;
/**
 * Design Pattern: Iterator Pattern
 * ProductList is a list of product
 */
public class ProductList extends ArrayList<Product>{

    public Product get_name(String product_name) {
        for(Product product : this){
            if(product_name.equals(product.get_name())){
                return product;
            }
        }
        return null;
    }

    public void accept(NodeVisitor visitor, JPanel panel){
        visitor.visited(this, panel);
    }
}
