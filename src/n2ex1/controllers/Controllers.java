package n2ex1.controllers;

import n2ex1.exceptions.CustomInputException;
import n2ex1.exceptions.Input;

public class Controllers {
    public static void run(){
        boolean isChar = false;
        boolean isString = false;
        boolean isBoolean = false;


        byte age = Input.readByte("Enter your age");
        System.out.println(age);

        int year = Input.readInt("Enter your birth year");
        System.out.println(year);

        float weight = Input.readFloat("Enter your weight");
        System.out.println(weight);

        double doubleNumber = Input.readDouble("Enter un double");
        System.out.println(doubleNumber);


        while(!isChar) {
            try {
                char character = Input.readChar("Enter a character");
                System.out.println(character);
                isChar =true;
            } catch (CustomInputException e) {
                System.out.println(e.getMessage());
            }
        }

        while (!isString) {
            try {
                String myString = Input.readString("Enter something");
                System.out.println(myString);
                isString = true;
            } catch (CustomInputException cie) {
                System.out.println("You must enter something");
            }
        }

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

