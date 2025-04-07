package n2ex1.controllers;

import n2ex1.exceptions.CustomInputException;
import n2ex1.exceptions.Input;

public class InputProcessor {
    public static void isChar() {
        boolean isChar = false;

        while (!isChar) {
            try {
                char character = Input.readChar("Enter a character");
                System.out.println(character);
                isChar = true;
            } catch (CustomInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void isString(){
        boolean isString = false;
        while (!isString) {
            try {
                String myString = Input.readString("Enter something");
                System.out.println(myString);
                isString = true;
            } catch (CustomInputException cie) {
                System.out.println("You must enter something");
            }
        }
    }

    public static void isBoolean(){
        boolean isBoolean = false;

        while(!isBoolean){
            try{
                boolean myBoolean = Input.readYesNo("Enter y for yes or n for no");
                System.out.println(myBoolean);
                isBoolean = true;
            } catch (CustomInputException cie){
                System.out.println("You must enter Y or N");
            }
        }
    }


}