import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Design Pattern : Facade Pattern
 * A Login system
 */
public class Login extends JFrame implements ActionListener {
    private Map<String, String> Sellers;
    private Map<String, String> Buyers;
    public static Person person;
    private static JLabel userLabel;
    private  static  JTextField userText;
    private  static  JLabel passwordLabel;
    private  static JTextField passwordText;
    private  static JButton button;
    private  static JLabel success;;
    public Login() throws FileNotFoundException {
        Sellers = new HashMap<String, String>();
        Buyers = new HashMap<String, String>();
        JPanel panel = new JPanel();
        this.add(panel);
        panel.setLayout(null);

        ImportUser();
        userLabel = new JLabel("Username");
        userLabel.setBounds(10,20, 80 ,25);
        panel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(100, 20 ,165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,50, 80 ,25);
        panel.add(passwordLabel);

        passwordText = new JTextField();
        passwordText.setBounds(100, 50 ,165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10, 90, 60, 30);
        button.addActionListener(this::actionPerformed);
        panel.add(button);

        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        //success = new JLabel("Success");
        //success.setBounds(10,90, 80, 20);
        //panel.add(success);
    }

    /**
     * ImportUser()
     * Import users to the system
     */
     private void ImportUser() throws FileNotFoundException {
        File Buyer_doc = new File("/Users/liam0504/Desktop/Documents/ASU/SER515/assignDP.lhsu16/src/data/BuyerInfo.txt");
        Scanner Buyer_obj = new Scanner(Buyer_doc);
        String str = null;
        String username = null;
        String passward = null;
        while(Buyer_obj.hasNext()){
            if(Buyer_obj.hasNextLine()){
                str = Buyer_obj.nextLine();
                for(int i = 0; i < str.length(); i++){
                    if(str.charAt(i) != ':')
                        continue;
                    else{
                        username = str.substring(0, i);
                        passward = str.substring(i + 1);
                        Buyers.put(username, passward);
                        //Product product = new Product("test", "test");
                    }
                }

            }
            else break;
        }
         File Seller_doc = new File("/Users/liam0504/Desktop/Documents/ASU/SER515/assignDP.lhsu16/src/data/SellerInfo.txt");
         Scanner Seller_obj = new Scanner(Seller_doc);
         while(Seller_obj.hasNext()){
             if(Seller_obj.hasNextLine()){
                 str = Seller_obj.nextLine();
                 for(int i = 0; i < str.length(); i++){
                     if(str.charAt(i) != ':')
                         continue;
                     else{
                         username = str.substring(0, i);
                         passward = str.substring(i + 1);
                         Sellers.put(username, passward);
                     }
                 }

             }
             else break;
         }
     }

    /**
     * when a user click the Login button, the system would display a menu
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();
        if(Sellers.containsKey(user) && Sellers.get(user).equals(password)){
            person = new Seller(user, password);
            try {
                Facade.getInstance().attachProductToUser();
                this.setVisible(false);
                System.out.print(Facade.getInstance().getBuyer_ProductList());
                person.showMenu();

            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        } else if (Buyers.containsKey(user) && Buyers.get(user).equals(password)) {
            person = new Buyer(user, password);
            try {
                Facade.getInstance().attachProductToUser();
                this.setVisible(false);
                person.showMenu();
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "You have entered an invalid username or password");
        }
    }

    public Map<String, String> getBuyers() {
        return Buyers;
    }
    public Map<String, String> getSellers() {
        return Sellers;
    }
}
