public class Item {
    int quantity;
    int productId;
    Category category;

    public Item(int productId, Category category, int quantity) {
        this.category = category;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Category getCategory() {
        return this.category;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getProductId() {
        return this.productId;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

    public void reduceQuantity() {
        this.quantity--;
    }
}
