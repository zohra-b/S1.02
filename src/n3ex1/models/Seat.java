package n3ex1.models;

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

    public boolean equals(){

        return true;// Equals: retornarà que dues butaques són iguales si la fila i el seient són iguals.
    }



    @Override
    public String toString(){
        return "Fila : " + this.row + ", Seient: " + this.seat + " , Persona: " +  this.user;
    }
}

