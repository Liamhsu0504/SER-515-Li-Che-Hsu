import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Facade {
    private static Facade instance;

    private ProductList productList;
    private  Map<String, ProductList> buyer_ProductList;
    private  Map<String, ProductList> seller_ProductList;
    private Login login;
    public Facade() throws FileNotFoundException {
        buyer_ProductList = new HashMap<String, ProductList>();
        seller_ProductList = new HashMap<String, ProductList>();
        instance = null;
        login = new Login();
        productList = new ProductList();
        createProductList();
    }
    public static Facade getInstance() throws FileNotFoundException {
        if(instance == null)
            instance = new Facade();
        return instance;
    }
//  private Login Login(){return login;}

    public Map<String, ProductList> getBuyer_ProductList(){ return buyer_ProductList; }

    public Map<String, ProductList> getSeller_ProductList() { return seller_ProductList;}

    public ProductList getProductList() {
        return productList;
    }

    public void addTrading(){}

    public void ViewTrading(){}

    public void decideBidding(){}

    public void remind(){}


    public void createProductList() throws FileNotFoundException {
        String str;
        File Product_doc = new File("/Users/liam0504/Desktop/Documents/ASU/SER515/Design Pattern/src/data/ProductInfo.txt");
        Scanner Product_obj = new Scanner(Product_doc);
        while(Product_obj.hasNext()){
            if(Product_obj.hasNextLine()){
                str = Product_obj.nextLine();
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) == ':') {
                        String Product_type = str.substring(0, i);
                        String Product_name = str.substring(i + 1);
                        productList.add(new Product(Product_name, Product_type));
                    }
                }

            }
            else break;
        }
    }

    public void selectProduct(){}

    public void ProductionOperation(){}

    public void attachProductToUser() throws FileNotFoundException {
        Map<String, String> Buyers = login.getBuyers();
        Map<String, String> Sellers = login.getSellers();
        String str;
        File UserProduct_doc = new File("/Users/liam0504/Desktop/Documents/ASU/SER515/Design Pattern/src/data/UserProduct.txt");
        Scanner UserProduct_obj = new Scanner(UserProduct_doc);
        while(UserProduct_obj.hasNext()) {
            if (UserProduct_obj.hasNextLine()) {
                str = UserProduct_obj.nextLine();
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ':') {
                        String Username = str.substring(0, i);
                        String Product_name = str.substring(i + 1);
                        Product product = productList.get_name(Product_name);
                        if(Buyers.containsKey(Username)){
                            if(!buyer_ProductList.containsKey(Username)){
                                buyer_ProductList.put(Username, new ProductList());
                            }
                            if(!buyer_ProductList.get(Username).contains(Product_name))
                            buyer_ProductList.get(Username).add(product);
                            //System.out.print(buyer_ProductList);
                        }
                        else {
                            if(!seller_ProductList.containsKey(Username)){
                                seller_ProductList.put(Username, new ProductList());
                            }
                            if(!seller_ProductList.get(Username).contains(Product_name))
                                seller_ProductList.get(Username).add(product);
                            //System.out.print(seller_ProductList);
                        }
                    }
                }

            } else break;
        }
    }
}