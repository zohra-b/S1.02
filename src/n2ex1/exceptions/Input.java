package n2ex1.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static Scanner input = new Scanner(System.in);

    /// ////INPUT MISMATCH EXCEPTIONS`
    public static byte readByte(String message) {
        byte data = 0;
        boolean isByte = false;
        System.out.println(message);

        while (!isByte) {
            try {
                data = input.nextByte();
                input.nextLine();
                isByte = true;

            } catch (InputMismatchException ime) {
                System.out.println("You must enter an entire number \n" + message);
                input.nextLine();

            }
        }
        return data;
    }


    public static int readInt(String message) {
        int data = 0;
        boolean isInt = false;
        System.out.println(message);

        while (!isInt) {
            try {
                data = input.nextInt();
                isInt = true;
            } catch (InputMismatchException ime) {
                System.out.println("You must enter an integer \n" + message);
                input.nextLine();
            }
        }
        return data;
    }

    public static float readFloat(String message) {
        float data = 0f;
        boolean isFloat = false;

        System.out.println(message);
        while (!isFloat) {
            try {
                data = input.nextFloat();
                isFloat = true;
                input.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("You must enter a float \n" + message);
                input.nextLine();
            }
        }
        return data;
    }

    public static double readDouble(String message) {
        double data = 0d;
        boolean isDouble = false;

        System.out.println(message);
        while (!isDouble) {
            try {
                data = input.nextDouble();
                isDouble = true;
                input.nextLine();
            } catch (InputMismatchException ime) {
                System.out.println("You must enter a double \n" + message);
                input.nextLine();
            }
        }
        return data;
    }

    /// ////////// INPUT CUSTOM EXCEPTIONS
    public static char readChar(String message) throws CustomInputException {
        char data;
        String entry = "";

        System.out.println(message);
        entry = input.next();
        if (entry.length() > 1) {
            throw new CustomInputException("You must enter only one character");
        } else if (entry.isEmpty()) {
            throw new CustomInputException("You must enter at least one character");
        }
        data = entry.charAt(0);
        input.nextLine();

        return data;
    }

    public static String readString(String message) throws CustomInputException {
        String data;

        System.out.println(message);
        data = input.nextLine();
        if (data.isEmpty()) {
            throw new CustomInputException("Enter something");
        }
        return data;
    }

    public static boolean readYesNo(String message) throws CustomInputException {
        String data;
        System.out.println(message);
        data = input.next();
        boolean myBoolean = false;
        if (data.isEmpty()) {
            throw new CustomInputException("You must enter something");
        } else if ((data.charAt(0) != 'y') && (data.charAt(0) != 'n')) {
            throw new CustomInputException("You must enter Y for yes or N for no");
        } else if (data.charAt(0) == 'y') {
            myBoolean = true;
        } else if (data.charAt(0) == 'n') {
            myBoolean = myBoolean;
        }
    return myBoolean;
    }


}
