import java.util.HashMap;
import java.util.Map;

public class BulkBuyLimit implements Rule {
     public boolean verify(Cart cart) {
        Map<Category, Integer> map = new HashMap<>();
        cart.displayCart().forEach(i -> {
            map.put(i.getCategory(), map.getOrDefault(i.getCategory(),0)+i.getQuantity());
        });

        boolean result=true;
        for(Category c: map.keySet()) {
            result = result && map.get(c)<=10;
        }
        return result;
    }
}
