public class Product {
    private String Product_name;
    private String Product_type;

    public Product(String Product_name, String Product_type){
        this.Product_name = Product_name;
        this.Product_type = Product_type;
    }
    public  Product(String Product_name){
        this.Product_name = Product_name;
    }

    public String get_name() {
        return Product_name;
    }
    public String get_type() {
        return Product_type;
    }
}
