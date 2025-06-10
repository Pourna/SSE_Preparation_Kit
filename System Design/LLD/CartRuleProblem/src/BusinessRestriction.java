import java.util.Arrays;
import java.util.List;

public class BusinessRestriction implements Rule {
    List<Rule> rules = Arrays.asList(new BulkBuyLimit(), new BulkBuyLimitCategory());
    @Override
    public boolean verify(Cart cart) {
        boolean result=true;
        for (Rule r:rules) {
            result = result && r.verify(cart);
        }
        return result;
    }

    public static void main(String[] args) {
        Cart cart = new Cart(Arrays.asList(
                new Item(1, Category.PARACETAMOL,3),
                new Item(2, Category.ANALGESIC,2),
                new Item(3, Category.CHOCOLATE,8),
                new Item(4, Category.PARACETAMOL,2)));
        System.out.println(new BusinessRestriction().verify(cart)? "MET":"BREACHED");
        System.gc();
    }
}

