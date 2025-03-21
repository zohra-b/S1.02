package n3ex1.models;

import java.util.Objects;

public class Seat {
    private int row;
    private int seat;
    private String user;

    public Seat(int row, int seat, String user ){
        this.row = row;
        this.seat = seat;
        this.user = user;
    }

    public int getRow(){
        return this.row;
    }
    public int getSeat(){
        return this.seat;
    }
    public String getUser() {
        return this.user;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, seat, user);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass() ) return false;
        Seat seat2 = (Seat) obj;

        return this.row == seat2.getRow() && this.seat == seat2.getSeat();

    }

    @Override
    public String toString(){
        return "Fila : " + this.row + ", Seient: " + this.seat + " , Persona: " +  this.user + "\n";
    }
}

