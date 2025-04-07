package n2ex1.controllers;

import n2ex1.exceptions.CustomInputException;
import n2ex1.exceptions.Input;

public class Controllers {
    public static void run(){



        System.out.println(Input.readByte("readByte() method \n Enter your age"));
        System.out.println(Input.readInt("readInt() method \n Enter your birth year"));
        System.out.println(Input.readFloat("readFloat() method \nEnter your weight"));
        System.out.println(Input.readDouble("readDouble() \n Enter un double"));

        InputProcessor.isChar();
        InputProcessor.isString();
        InputProcessor.isBoolean();




    }
    }

