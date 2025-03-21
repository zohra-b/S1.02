package n3ex1.models;

import n3ex1.controllers.CineManagement;
import n3ex1.controllers.SeatsManagement;

import java.util.Scanner;

public class Cinema {

    private int totalRows;
    private int seatsPerRow;
    //private final SeatsManagement newSeatsManagement;
    private final CineManagement newCineManagement;
    private Scanner input = new Scanner(System.in);

    public Cinema(){
        //this.newSeatsManagement = new SeatsManagement();
        this.newCineManagement = new CineManagement(this);
        askForStartingDatas();
        newCineManagement.start();
    }

    public int getTotalRows(){
        return this.totalRows;
    }
    public int getSeatsPerRow(){
        return this.seatsPerRow;
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
