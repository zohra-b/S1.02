package n3ex1.models;

import n3ex1.controllers.CineManagement;
import n3ex1.controllers.SeatsManagement;

import java.util.Scanner;

public class Cinema {

    private int totalRows;
    private int seatsPerRow;
    private SeatsManagement newSeatsManagement;
    private CineManagement newCineManagement;
    private Scanner input = new Scanner(System.in);

    public Cinema(){
        this.newSeatsManagement = new SeatsManagement();
        this.newCineManagement = new CineManagement(this);
        askForStartingDatas();
    }

    public int getTotalRows(){
        return this.totalRows;
    }
    public int getSeatsPerRow(){
        return this.seatsPerRow;
    }

    public void start() {
        int option;
        do {
            option = newCineManagement.displayInitialMenu();
            switch(option){
                case 1 : newCineManagement.showSeats();
                    break;
                case 2 : newCineManagement.showSeatsPerUser();
                    break;
                case 3 : newCineManagement.bookSeat();
                    break;
                case 4 : newCineManagement.cancelBookedSeat();
                    break;
                case 5 : newCineManagement.cancelUserBookedSeats();
                    break;

            }
        } while (option !=0);
    }

    public void askForStartingDatas(){
        System.out.print("Introdueix el numero de filas");
        this.totalRows = input.nextInt();
        input.nextLine();
        System.out.print("Introdueix el numero de seients per fila");
        this.seatsPerRow = input.nextInt();
        input.nextLine();

    }

}
