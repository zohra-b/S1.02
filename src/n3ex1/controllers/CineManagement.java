package n3ex1.controllers;

import n3ex1.exceptions.*;
import n3ex1.models.Cinema;
import n3ex1.models.Seat;

import java.util.*;


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
            switch (option) {
                case 1:
                    showSeats();
                    break;
                case 2:
                    showSeatsPerUser();
                    break;
                case 3:
                    bookSeat();
                    break;
                case 4:
                    cancelBookedSeat();
                    break;
                case 5:
                    cancelUserBookedSeats();
                    break;

            }
        } while (option != 0);
    }

    public void showSeats() {
        try {
            System.out.println("Aqui tens totes les butaques reservadas:\n" + seatsManagement.getAllSeats());
        } catch (NoSeatsReservedException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Seat> findSeatsPerUser() {
        String name = "";
        try {
            name = enterUser();
        } catch (IncorrectUserNameException e) {
            System.out.println(e.getMessage());
        }

        List<Seat> seatsPerUser = new ArrayList<>();
        for (int i = 0; i < seatsManagement.getSeats().size(); i++) {
            if (name.equalsIgnoreCase(seatsManagement.getSeats().get(i).getUser())) {
                seatsPerUser.add(seatsManagement.getSeats().get(i));
            }
        }
        if (seatsPerUser.isEmpty()) {
            System.out.println("Aquest usuari no té reserves.");
        }
            return seatsPerUser;

    }

    public void showSeatsPerUser() {
        StringBuilder showSeatsPerUser = new StringBuilder();
        List<Seat> seatsPerUser = findSeatsPerUser();
        for (Seat s : seatsPerUser) {
            showSeatsPerUser.append(s.toString()).append("\n");

        }
        System.out.println(showSeatsPerUser);
    }

    public void bookSeat() {
        boolean occupiedSeat;
        do {
            occupiedSeat = false;
            int row = enterRowNumber();
            int seat = enterSeatNumber();
            try {
                if (seatsManagement.searchSeat(row, seat) != -1) {
                    throw new OccupiedSeatException("Aquesta butaca ja esta ocupada");
                }
            } catch (OccupiedSeatException e) {
                System.out.println(e.getMessage());
                occupiedSeat = true;
            } catch (AvailableSeatException e) {
                String user = enterUser();
                seatsManagement.addSeat(row, seat, user);
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
            seatsManagement.deleteSeat(row, seat);
            System.out.print("La reserva s´ha cancelat. \n");

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

    public String enterUser() {
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

    public int enterRowNumber() {
        int rowNumber = 0 ;

        do {
            System.out.println("Quin és el numero de fila");
            try {
                rowNumber = SC.nextInt();
                SC.nextLine();
                if (rowNumber < 1 || rowNumber > cinema.getTotalRows()) {
                    System.out.println("Fila incorrecta");
                }
            } catch (IncorrectRowNumberException e) {
                System.out.println(e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("El número de fila ha de ser un enter");
                SC.nextLine();
            }
        } while (rowNumber < 1 || rowNumber > cinema.getTotalRows());
        return rowNumber;
    }

    public int enterSeatNumber() throws IncorrectSeatNumberException {
        int seatNumber = 0;

        do {
            System.out.println("Quin és el numero de seient");
            try {
                seatNumber = SC.nextInt();
                SC.nextLine();
                if (seatNumber < 1 || seatNumber > cinema.getSeatsPerRow()) {
                System.out.println("Numero de seient incorrecte. Introdueix un numero de seient");
                }
            } catch (IncorrectSeatNumberException e) {
                System.out.println(e.getMessage());

            } catch (InputMismatchException e){
                System.out.println("El número de seient ha de ser un enter");
                SC.nextLine();
            }
        } while (seatNumber < 1 || seatNumber > cinema.getSeatsPerRow());
        return seatNumber;
    }

}



