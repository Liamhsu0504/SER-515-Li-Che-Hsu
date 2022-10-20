import javax.swing.*;
import java.io.FileNotFoundException;

public interface ProductMenu {
    public abstract void showMenu(JPanel panel) throws FileNotFoundException;
    public abstract void showAddButton();
    public abstract void showViewButton();
    public abstract void showRadioButton();
    public abstract void showLabels();
    public abstract void showComboxes();
}
