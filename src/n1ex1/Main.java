package n1ex1;

import n1ex1.exceptions.VoidSaleException;
import n1ex1.models.Product;
import n1ex1.models.Sale;

public class Main {
    public static void main(String[] args) {
        Sale sales = new Sale();

        try {
            sales.calculateTotal();
        } catch (VoidSaleException vse) {
            System.out.println(vse.getMessage());
        }

        try {
            ((Product) sales.getProducts().get(1)).getName();
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println(iobe.getMessage());
        }

    }
}
