package n1ex1;

import n1ex1.exceptions.VoidSaleException;
import n1ex1.models.Product;
import n1ex1.models.Sale;

public class Main {
    public static void main(String[] args) {
        Sale sale = new Sale();

        Product product1 = new Product("Laptop", 1200);
        Product product2 = new Product("Mouse", 25);
        sale.addProduct(product1);
        sale.addProduct(product2);

//        try {
//            sale.calculateTotal();
//        } catch (VoidSaleException vse) {
//            System.out.println(vse.getMessage());
//        }
//
//        try {
//            sale.getProducts().get(1);
//        } catch (IndexOutOfBoundsException iobe) {
//            System.out.println(iobe.getMessage());
//        }

        try {
            System.out.println(sale.calculateTotal());
            System.out.println(sale.getProducts().get(1));
        } catch (VoidSaleException vse) {
            System.out.println(vse.getMessage());
        }  catch (IndexOutOfBoundsException iobe) {
            System.out.println(iobe.getMessage());
        }



    }
}
