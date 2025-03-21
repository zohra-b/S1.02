package n3ex1.controllers;

import n3ex1.exceptions.*;
import n3ex1.models.Cinema;
import n3ex1.models.Seat;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;


public class CineManagement {
    private final Scanner SC = new Scanner(System.in);
    private final SeatsManagement seatsManagement;
    private final Cinema cinema;

    public CineManagement(Cinema cinema) {
        this.cinema = cinema;
        this.seatsManagement = new SeatsManagement();
    }

    public byte displayInitialMenu() {
        System.out.println("""
                1.- Mostrar totes les butaques reservades.
                2.- Mostrar les butaques reservades per una persona.
                3.- Reservar una butaca.
                4.- Anul·lar la reserva d’una butaca.
                5.- Anul·lar totes les reserves d’una persona.
                0.- Sortir.
                """
        );
        byte option = SC.nextByte();
        SC.nextLine();
        return option;

    }

    public void start() {
        int option;
        do {
            option = displayInitialMenu();
            switch(option){
                case 1 : showSeats();
                    break;
                case 2 : showSeatsPerUser();
                    break;
                case 3 : bookSeat();
                    break;
                case 4 : cancelBookedSeat();
                    break;
                case 5 : cancelUserBookedSeats();
                    break;

            }
        } while (option !=0);
    }
    public void showSeats() {
        try {
            System.out.println("Aqui tens totes les butaques reservadas:\n" + seatsManagement.getAllSeats());
        } catch (NoSeatsReservedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showSeatsPerUser() throws UserNotfoundException {
        StringBuilder seatsPerUser = new StringBuilder();
        String name;
        boolean userFound = false;
        System.out.println("Introdueix el nom del usuari");
        name = SC.nextLine();

        for (int i = 0; i < seatsManagement.getSeats().size(); i++) {
            if (name.equalsIgnoreCase(seatsManagement.getSeats().get(i).getUser())) {
                seatsPerUser.append(seatsManagement.getSeats().get(i).toString()).append("\n");
                userFound = true;
            }
        }
        try {
            if (userFound){
                System.out.println("Aqui tens totes les butaques reservadas per aquest usuari :\n" + seatsPerUser);
            } else {
                throw new UserNotfoundException("L'usuari no té reserves. ");
            }
        } catch (UserNotfoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public void bookSeat() throws OccupiedSeatException {
        boolean occupiedSeat;
        do {
            occupiedSeat = false;
            int row = enterRowNumber();
            int seat = enterSeatNumber();
            try {
                if (seatsManagement.searchSeat(row, seat) != -1) {
                    throw new OccupiedSeatException("Aquesta butaca ja esta ocupada");
                } else {
                    String user = enterUser();
                    seatsManagement.addSeat(row, seat, user);
                }
            } catch (OccupiedSeatException e) {
                System.out.println(e.getMessage());
                occupiedSeat = true;
            }
        } while (occupiedSeat);
    }



    public void cancelBookedSeat() {
        System.out.println("Numero de fila ?");
        int row = SC.nextInt();
        SC.nextLine();
        System.out.println("Numero de seient ?");
        int seat = SC.nextInt();
        SC.nextLine();
        try {
            int index = seatsManagement.searchSeat(row, seat);
            if (index == -1) {
                throw new AvailableSeatException("Aquesta butaca no esta ocupada\n");
            } else {
                seatsManagement.deleteSeat(row, seat);
                System.out.print("La reserva s´ha cancelat. \n");
            }
        } catch (AvailableSeatException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cancelUserBookedSeats(){
        String name = "";
        boolean bookingCanceled = false;
        Iterator<Seat> iterator = seatsManagement.getSeats().iterator();

        try {
            name = enterUser();
        } catch (IncorrectUserNameException e) {
            System.out.println(e.getMessage());
        }

        while (iterator.hasNext()) {
            Seat seat = iterator.next();
            if (seat.getUser().equalsIgnoreCase(name)) {
                iterator.remove();
                bookingCanceled = true;
                    }
        }

        if(bookingCanceled){
            System.out.print("S´han cancelat les reserves de l'usuari. \n");
            } else {
                System.out.println("Aquest usuari no té reserves");
            }

    }



    public String enterUser() throws IncorrectUserNameException {
        String user ="";
        System.out.println("Introdueix el nom de la persona ");
        String name = SC.nextLine();
        try {
            for (char c : name.toCharArray()) {
                if (Character.isDigit(c)) {
                    throw new IncorrectUserNameException("El nom no pot contenir numeros\n");
                }
                }
            user = name;

        } catch (IncorrectUserNameException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }

    public int enterRowNumber() throws IncorrectRowNumberException {
        int rowNumber = 0 ;
        boolean validInput = false;
        do {
            System.out.println("Quin és el numero de fila");
            try {
                rowNumber = SC.nextInt();
                SC.nextLine();
                if (rowNumber >= 1 && rowNumber <= cinema.getTotalRows()) {
                    validInput = true;
                } else {
                    throw new IncorrectRowNumberException("Fila incorrecta");
                }
            } catch (IncorrectRowNumberException e) {
                System.out.println(e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("El número de fila ha de ser un enter");
                SC.nextLine();
            }
        } while (!validInput);
        return rowNumber;
    }

    public int enterSeatNumber() throws IncorrectSeatNumberException {
        int seatNumber = 0;
        boolean validInput = false;
        System.out.println("Quin és el numero de seient");
        do {
            try {
                seatNumber = SC.nextInt();
                SC.nextLine();
                if (seatNumber >= 1 && seatNumber <= cinema.getSeatsPerRow()) {
                    validInput = true;
                } else {
                    throw new IncorrectSeatNumberException("Numero de seient incorrecte. Introdueix un numero de seient");
                }
            } catch (IncorrectSeatNumberException e) {
                System.out.println(e.getMessage());

            } catch (InputMismatchException e){
                System.out.println("El número de seient ha de ser un enter");
                SC.nextLine();
            }
        } while (!validInput);
        return seatNumber;
    }
}



