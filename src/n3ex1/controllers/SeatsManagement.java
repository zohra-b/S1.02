package n3ex1.controllers;

import n3ex1.exceptions.AvailableSeatException;
import n3ex1.exceptions.OccupiedSeatException;
import n3ex1.models.Seat;
import java.util.ArrayList;

public class SeatsManagement {
    static ArrayList<Seat> seats;

    public SeatsManagement() {
        seats = new ArrayList<>();
    }

    public ArrayList<Seat> getAllSeats() {
        return seats;
    }

    public static void addSeat(int row, int seat, String user) {
//        try {
//            if (searchSeat(row, seat) != -1) {
//                throw new OccupiedSeatException("Aquesta butaca ja esta ocupada");
//            } else {
                seats.add(new Seat(row, seat, user));
//            }
//        } catch (OccupiedSeatException e) {
//            System.out.println(e.getMessage());
//        }
    }

    public static void deleteSeat(int row, int seat) throws AvailableSeatException {
        try {
            int index = searchSeat(row, seat);
            if (index == - 1) {
                throw new AvailableSeatException("Aquesta butaca no esta ocupada");
            } else {
                seats.remove(index);
                System.out.print("La reserva s´ha cancelat");
            }
        } catch (AvailableSeatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int searchSeat(int row, int seat) {
        /*Cerca a l’ArrayList de butaques, la butaca que coincideixi amb les
          dades rebudes com a paràmetre (fila i seient). Si la troba, retornarà la posició de la butaca a l’ArrayList i, si no la troba, retornarà -1.*/
        int seatIndex = -1;
        for (int i = 0; i < seats.size(); i++) {
            if (row == seats.get(i).getRow() && seat == seats.get(i).getSeat()) {
                seatIndex = i;
            }
        }
        return seatIndex;
    }
}



