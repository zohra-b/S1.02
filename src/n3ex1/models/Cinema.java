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

    public Cinema(){ //NE RECOIT PAS DE PARAMETRES SELON L'ENONCE
        this.newSeatsManagement = new SeatsManagement();
        this.newCineManagement = new CineManagement(this);
        askForStartingDatas(); // inicialitzarà el nombre de files i de seients
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


            }
        } while (option !=0);
    }

    public void askForStartingDatas(){/// Demanarà a l’usuari/ària el nombre de files i seients i els guardarà en els atributs corresponents
        System.out.print("Introdueix el numero de filas");
        this.totalRows = input.nextInt();
        input.nextLine();
        System.out.print("Introdueix el numero de seients per fila");
        this.seatsPerRow = input.nextInt();
        input.nextLine();

    }

}
