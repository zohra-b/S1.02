package n3ex1.controllers;

import n3ex1.exceptions.AvailableSeatException;
import n3ex1.exceptions.NoSeatsReservedException;
import n3ex1.models.Seat;
import java.util.ArrayList;

public class SeatsManagement {
    private ArrayList<Seat> seats;

    public SeatsManagement() {
        seats = new ArrayList<>();
    }


    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public StringBuilder getAllSeats() throws NoSeatsReservedException {
        StringBuilder reservedSeatsList = new StringBuilder();
        if (seats.isEmpty()) {
            throw new NoSeatsReservedException("No hi ha cap butaca reservada.");
        } else {
            for (Seat seat : seats) {
                reservedSeatsList.append(seat.toString());
            }
        }
        return reservedSeatsList;
    }

    public void addSeat (int row, int seat, String user) {
        Seat newSeat = new Seat(row, seat, user);
        seats.add(newSeat);
        System.out.print(newSeat);
    }

    public void deleteSeat(int row, int seat) {
        try {
            int index = searchSeat(row, seat);
            seats.remove(index);
        } catch (AvailableSeatException e) {
           System.out.println( e.getMessage());
        }
    }

    public int searchSeat(int row, int seat) throws AvailableSeatException{

        Seat seat1 = new Seat(row, seat, "");
        for (int i = 0; i < seats.size(); i++) {
            if (seat1.equals(seats.get(i))){
                return i;
            }
        }
        throw new AvailableSeatException("Aquesta butaca no esta reservada");
    }


}



