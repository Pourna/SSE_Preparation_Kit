import java.util.ArrayList;
import java.util.List;

public class Cart {
    public List<Item> items = new ArrayList<>();

    public Cart(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> displayCart() {
        return this.items;
    }
}
