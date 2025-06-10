import java.util.List;

public class BulkBuyLimitCategory implements Rule {
    @Override
    public boolean verify(Cart cart) {
        List<Item> items = cart.displayCart();
        int totalQuantity=0;
        for(Item i: items) {
            if(i.getCategory()== Category.PARACETAMOL) {
                totalQuantity+=i.getQuantity();
            }
        }
        return (totalQuantity<=5);
    }
}
