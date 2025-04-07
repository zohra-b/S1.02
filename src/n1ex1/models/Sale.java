package n1ex1.models;
import n1ex1.exceptions.VoidSaleException;

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

    public void setTotalPrice() { // Si estamos capturando una excepción no es necesario
                                    // declarar que el método arrojará una excepción:
        try {
            this.totalPrice = calculateTotal();
        } catch (VoidSaleException e){
            System.out.println(e.getMessage());

        }
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }


    public int calculateTotal() throws VoidSaleException {
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