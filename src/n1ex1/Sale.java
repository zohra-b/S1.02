package n1ex1;
import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> products = new ArrayList();
    private int totalPrice;

    public Sale() {
    }

    public ArrayList<Product> getProducts() {
        return this.products;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public void addProducts(Product product) {
        this.products.add(product);
    }

    public int calculateTotal() throws VoidSaleException {
        int totalPrice = 0;
        if (this.products.isEmpty()) {
            throw new VoidSaleException();
        } else {
            for(Product p : this.products) {
                int price = p.getPrice();
                totalPrice += price;
            }

            return totalPrice;
        }
    }
}