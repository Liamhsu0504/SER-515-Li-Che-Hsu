
Design Patterns

I created 5 designed patterns for the trading application.

1 Facade Pattern || Class file : Facade.java

Facade.java provides an interface that allows users to access the application simply. The main.java can access the system only call the Facade.java. 

2 Bridge Pattern || Class file : ProductMenu.java  MeatProductMenu.java  ProduceProductMenu.java Person.java Buyer.java Seller.java

ProductMenu.java is the implementor of MeatProductMenu and ProduceProductMenu. They would display different kinds of menus. There are two kinds of users, buyer, and seller, which implement Person.java

3 Factory Pattern || Class file : ProductMenu.java  MeatProductMenu.java  ProduceProductMenu

After logging in to the system, a user can use the switch button to switch the menus. The factory pattern enables the system to decide which menu should be displayed.

4 Iterator Pattern || Class file : ListIterator.java ProductIterator.java ProductList.java

These classes use the Iterator pattern to show what products are on a menu. For example, We can know that there are beef, pork, and mutton in the MeatProduct Menu by using Iterator Pattern.

5 Visitor Pattern || Class file: NodeVisitor.java ReminderVisitor.java

A user can know what products they actually have by utilizing the Visitor Pattern.   
