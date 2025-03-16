
<p align="center"><h1 align="center">S1.02. Exceptions</h1></p>

<br>

---

## 📍 Objectives

Learn how to handle Java Exceptions and build robust code.
---

## 👾 Exercises
### 📌 Level 1 - ex 1
Create a "Product" class with the attributes name and price, and another class "Sale". Its attributes are a collection of products and the total price of the sale.

The "Sale" class has a CalculateTotal() method that launches the personalized exception "VoidSaleException" which shows the screen “Per fer una venda primer has to affect products” if the collection of products is void. If the collection is not void, it has to get the sum of all the products from the total value of the sale.

The personalized exception "VoidSaleException" is member of the Exception class. The constructor has to pass the message “Per fer una venda primer has d’afegir productes” when you catch the exception. It must be displayed on the screen with the getMessage() method of the exception.

Write the code necessary to generate and catch an exception like "IndexOutOfBoundsException".


### 📌 Level 2 - ex 1
Create a class called "Input". This class should be used to handle the different exceptions that can appear in Java when entering data from the keyboard using the Scanner class.
The first thing to do is instantiate an object of the Scanner class and from there, create static methods to read the different types of data from the keyboard.

All methods receive a String with the message that you want to show to the user, for example: “Enter your age”, and return the appropriate data entered by the user in each method, for example: a byte with the user's age.

Methods to implement by catching the exception of the "InputMismatchException" class:
public static byte readByte(String message);
public static int readInt(String message);
public static float readFloat(String message);
public static double readDouble(String message);

Methods to implement by catching a custom exception from the Exception class:
public static char readChar(String message);
public static String readString(String message);
public static boolean readSiNo(String message), if the user enters “s”, returns “true”, if the user enters “n”, returns “false”.

### 📌 Level 3 - ex 1
A famous cinema company has asked us to develop an application for reserving seats in their cinemas. The application will be used by salespeople when selling tickets.

Once the application has been started, it will ask the user how many rows and how many seats per row the cinema has. Once this data has been entered, the following menu will be displayed:

1.- Show all reserved seats.
2.- Show seats reserved by a person.
3.- Reserve a seat.
4.- Cancel the reservation of a seat.
5.- Cancel all reservations for a person.
0.- Exit.

The application will have the following classes:

**Main Class**
It will have the main of the application where an object of the "Cinema" class will be instantiated and its "start" method will be called.

**Seat Class**
It will have the data of a seat:
Attributes:
Number of row.
Number of seat.
Person who reserves the seat.

Methods:
Constructor with all parameters.
Getters for all attributes.
Equals: will return that two seats are equal if the row and the seat are the same.
toString: will return a String with the following format: “Row: 5, Seat: 20, Person: Maria Febrer”

**Cinema Class**
It will contain the attributes and the initialization method.
Attributes:
Number of rows in the cinema.
Number of seats for each row.
An object of the class "SeatsManagement"
An object of the class "CinemaManagement"

Methods:
Constructor: will not receive parameters. It will initialize the object of the class "SeatsManagement" and "CinemaManagement". It will call the method "askForInitialDatas" which will initialize the number of rows and seats.
start: it will start the application. It will call the method "menu" and depending on the number returned, it will call the corresponding method of the class "CinemaManagement".
"askForInitialDatas": It will ask the user for the number of rows and seats and save them in the corresponding attributes

**CinemaManagement Class:**

It will contain the logic for managing the cinema operations.
Attributes:
An object of the "Cinema" class

Methods:
"Constructor": It will receive as a parameter an object of the "Cinema" class and assign it to the corresponding attribute.
"menu": It will show the main menu options to the user, ask for the number of the chosen option and return it.
"showSeats": It will show all the reserved seats.
"showSeatsPerPerson": Asks for the name of the person who made the reservation and shows all the seats reserved by that person
"bookSeat": Asks the user for a row number (calls the "enterRowNumber" method), a seat number (calls the "enterSeatNumber" method), the name of the person making the reservation (calls the "enterUser" method) and reserves the seat.
"cancelBookedSeat": Asks the user for a row number (calls the "enterRowNumber" method), a seat number (calls the "enterRowNumber" method) and deletes the seat reservation.
"cancelUserBookedSeats": Asks the user for the name of the person (calls the "enterUser" method) and deletes the seats reserved by the person entered.
"enterUser": Asks the user for the name of the person and returns it if it is correct. If it contains numbers, throws a custom exception "IncorrectPersonNameException"
"enterRow": Requests the row number, if it is between 1 and the total number of rows, returns it. If not, throws a custom exception "IncorrectRowException"
"enterSeat": Requests the seat, if the number is between 1 and the total number of seats, returns it. If not, throws a custom exception "IncorrectSeatException":

**SeatsManagement Class**

It will contain an ArrayList of seats and the methods to add, remove and search for seats in the ArrayList.

Attributes:
seats: ArrayList of seats.

Methods:
Constructor: It will not receive parameters and will initialize the ArrayList of chairs.
"getSeats": It will return the attribute seats.
"addSeat": It will be responsible for adding a Seat to the ArrayList of Seats. It will receive an object of the "Seat" class as a parameter and add it to the ArrayList. If the row and seat of the Seat received as a parameter coincide with that of a Seat already in the ArrayList (the "searchSeat" method will be used), the custom exception "OccupiedSeatException" will be thrown.
"deleteSeat": will be responsible for removing a Seat from the ArrayList of Seats. It will receive the row and seat number as parameters and will remove it from the ArrayList. If the row and seat do not match that of a reserved Seat (the "searchSeat" method will be used), it will throw a custom exception "AvailableSeatException".
"searchSeat": Searches in the ArrayList of Seats, the Seat that matches the data received as a parameter (row and seat). If it finds it, it will return the position of the Seat in the ArrayList and, if it does not find it, it will return -1.


---
## 🚀 Getting Started

### ☑️ Prerequisites

Before getting started with S1.02, ensure your runtime environment meets the following requirements:

- **Programming Language:** Java 23SE
- IntelliJ oir Eclipse IDE


### ⚙️ Installation

Clone the S1.02 repository:
```sh
❯ git clone https://github.com/zohra-b/S1.02
```
