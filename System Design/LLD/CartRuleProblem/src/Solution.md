Tesco cart rule management problem 

These regulations are mandatory from legal and business perspective to enforce for all order transactions.
You are given an order with a list of products in the shopping cart/basket with productid, product Category and quantity. And also, Restriction Rules on Qty and Qty/Category.
Example:

Ordered items in the shopping cart/basket

`Item-1 -> productid=1, category=Paracetamol, quantity=3
Item-2 -> productid=2, category=analgesic, quantity=3
Item-3 -> productid=3, category=chocolate, quantity=8
Item-4 -> productid=4, category= Paracetamol, quantity=2`

Business Restriction rules:

`Cannot buy more than 10 Quantity of any products - BulkBuyLimit
Cannot buy more than 5 Quantity of paracetamol products – BulkBuyLimitCategory
`

Write a restriction rule engine to run the restriction check against the shopping cart/basket and return the status as to MET/BREACHED indicating restriction
status for the given restriction rules.
For the above given example, the restriction status returned would be MET.*/

Category Enum
```aiignore
public enum Category {
    PARACETAMOL,
    ANALGESIC,
    CHOCOLATE
}
```

Item Class
```
public class Item {
    int productId;
    int quantity;
    Category category;
    
    public Item(int productId, int quantity, Category category) {
        this.productId = productId;
        this.quantity = quantity;
        this.category = category;
    }
    
    public int getQuantity() {
       return this.quantity;
    }
    
    public int getProductId() {
       return this.productId;
    }
    
    public Category getCategory() {
       return this.category;
    }
}
```
Cart Class 
```aiignore
public class Cart {
    List<Item> items = new ArrayList<>();
    
    public Cart(List<Item> items) {
       this.items=items;
    }
    
    public addItem(Item item) {
       this.items.add(item);
    }
    
    public List<Item> getItems() {
       return this.items;
    }
}
```

Rule interface
```aiignore
public interface  Rule {
     boolean check(Cart cart);
}
```

BulkBuyLimit class 
```aiignore
public BulkBuyLimit implements Rule {
     @Override
     public boolean check(Cart cart) {
        Map<Category, Integer> map = new HashMap<>();
        
        cart.getItems().forEach(i-> {
           map.put(i.getCategory, map.getOrDefault(i.getCategory(),0)+i.getQuantity());
        });
        boolean result=true;
        for(Category c:map.keySet()) {
           result= result && map.get(c)<=10;
        }
        
        return result;
     }
}
```

BulkBuyLimitCategory class
```aiignore
public class BulkBuyLimitCategory implements Rule {
    @Override 
    public boolean check(Cart cart) {
       int total=0;
       for(Item i:cart.getItems()) {
           if(i.getCategory()==Category.PARACETAMOL) {
                total+=i.getQuantity();
           }
       }
       return (total<=5);
    }
}
```

Main class
```aiignore
public class BusinessRule implements Rule {
    @Override
    public boolean check(Cart cart) {
        List<Rule> rules = Arrays.asList(new BulkBuyLimit(), new BulkBuyLimitCategory());
        boolean result = true;
        for(Rule r:rules) {
            result = result && r.check(cart);
        }
        return result;
    }
    
    public static void main(String[] args) {
        Cart cart = new Cart(Arrays.asList(
                new Item(1,Category.PARACETAMOL,3),
                new Item(2,Category.ANALGESIC,2),
                new Item(3,Category.CHOCOLATE,8),
                new Item(4,Category.PARACETAMOL,2)));
        System.out.println(new BusinessRule().verify(cart)? "MET":"BREACHED");
    }
}
```