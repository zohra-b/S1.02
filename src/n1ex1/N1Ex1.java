package n1ex1;

public class N1Ex1 {
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
