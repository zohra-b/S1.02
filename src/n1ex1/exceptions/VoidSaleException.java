package n1ex1.exceptions;

public class VoidSaleException extends Exception {
    public VoidSaleException() {
        super("You need to add products before you can make any sale");
    }
}
