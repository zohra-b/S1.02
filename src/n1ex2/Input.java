package n1ex2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input extends Exception{
    //1 fields
    static Scanner input = new Scanner(System.in);


    public static byte readByte(String message){
        byte data = 0;
        boolean isByte = false;
        System.out.println(message);

        while(!isByte) {
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


    public static int readInt(String message){
        int data = 0;
        boolean isInt = false;
        System.out.println(message);

        while(!isInt){
            try{
                data = input.nextInt();
                isInt = true;
            } catch (InputMismatchException ime){
                System.out.println("You must enter an integer \n" + message);
                input.nextLine();
            }
        }
        return data;
    }

    public static float readFloat(String message){
        float data = 0f;
        boolean isFloat = false;

        System.out.println(message);
        while(!isFloat){
            try {
                data = input.nextFloat();
                isFloat = true;
                input.nextLine();
            } catch (InputMismatchException ime){
                System.out.println("You must enter a float \n" + message);
                input.nextLine();
            }
        }
        return data;
    }

    public static double readDouble(String message){
        double data = 0d;
        boolean isDouble = false;

        System.out.println(message);
        while(!isDouble){
            try {
                data = input.nextDouble();
                isDouble = true;
                input.nextLine();
            } catch (InputMismatchException ime){
                System.out.println("You must enter a double \n" + message);
                input.nextLine();
            }
        }
        return data;
    }
}
