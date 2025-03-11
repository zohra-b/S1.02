package n1ex1;

public class VoidSaleException extends Exception {
    public VoidSaleException() {
        super("You need to add products before you can make any sale");
    }

    public String getMessage() {
        return super.getMessage();
    }
}
