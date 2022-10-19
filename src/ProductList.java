import java.util.ArrayList;

public class ProductList extends ArrayList<Product>{

    public Product get_name(String product_name) {
        for(Product product : this){
            if(product_name.equals(product.get_name())){
                return product;
            }
        }
        return null;
    }
}
