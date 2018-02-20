package com.marcin;

import java.util.ArrayList;

public class Plansza {
    private final int WIDTH = 17;                                       // Szerokość planszy
    private final int HEIGHT = 17;                                      // Wysokość planszy
    private String[][] plansza = new String[WIDTH][HEIGHT];             // tablica z pól planszy
    private String[] kolumny = {"A","B","C","D","E","F","G","H"};
    private String[] wiersze = {"8","7","6","5","4","3","2","1"};
    private int temp = 0;
    private ArrayList <Pionek> biale = new ArrayList<>();
    private ArrayList<Pionek> czarne = new ArrayList<>();

    public Plansza(){
        konstruujPlansze();
        dodajPionkaBialego();
        rysujPlansze();
    }

    public void konstruujPlansze(){
        for(int i = 0; i< HEIGHT; i++){                                 //stworzenie planszy
            if(i%2 ==0){
                for (int j = 1; j< WIDTH; j=j+2){                       // wypełnienie pól poziomymi liniami
                    char k = 8208;
                    plansza[i][j] = ""+k;                       // szukanie odpowiedniej długości
                }
                for (int l = 0; l<=WIDTH; l=l+2){
                    plansza[i][l] = "+";                                // stworzenie przecięcia się linii
                }
            } else {
                for (int j = 0; j< WIDTH; j=j+2){                      // wypełnienie pól pionowymi liniami
                    plansza[i][j] = "|";
                }
            }
        }

        for (int i = 3; i<HEIGHT; i =i+4){                             // wypełnienie białymi polami wierszy nieparzystych

            for (int j = 3; j< WIDTH; j=j+4){
                char n = 9608;
                plansza[i][j] = "x";
            }
        }

        for (int i = 1; i<HEIGHT; i =i+4){                      // wypełnienie białymi polami wierszy parzystych
            for (int j = 1; j< WIDTH; j=j+4){
                char n = 9608;
                plansza[i][j] = ""+n;
            }

        }

    }

    public void dodajPionkaBialego(){
        for (int i = 1; i<6; i =i+2){
            for(int j = 3; j<16; j=j+4){
                biale.add(new Pionek(i,j,true));
            }
        }

        for (Pionek a:biale) {
            plansza[a.getPosx()][a.getPosy()] = "O";
        }
    }


    public void rysujPlansze(){                                     //narysowanie zawartości planszy
        for (int i = 0; i<kolumny.length; i++){
            System.out.printf("\t"+"\t"+kolumny[i]);
        }
        System.out.println();
        for (int i = 0; i< HEIGHT; i++){

            if (i%2 !=0){
                System.out.printf(wiersze[temp]);
            } else {System.out.printf(" ");}

            for (int j = 0; j< HEIGHT; j++){
                if (plansza[i][j] == null){
                    System.out.printf("\t"+" ");
                }else {
                    System.out.format("\t"+plansza[i][j]);
                }
            }
            if (i%2 !=0){
                System.out.print(" "+wiersze[temp]);
                temp++;
            } else {System.out.print(" ");}

            System.out.println();
        }
        for (int i = 0; i<kolumny.length; i++){
            System.out.printf( "\t" + "\t"+kolumny[i]);
        }
        System.out.println();
    }
}
