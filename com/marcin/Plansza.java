package com.marcin;

import java.util.ArrayList;


public class Plansza {
    private final int WIDTH = 17;                                       // Szerokość planszy
    private final int HEIGHT = 17;                                      // Wysokość planszy
    private String[][] plansza = new String[WIDTH][HEIGHT];             // tablica z pól planszy
    private String[] kolumny = {"A","B","C","D","E","F","G","H"};
    private String[] wiersze = {"8","7","6","5","4","3","2","1"};
    private ArrayList <Pionek> biale = new ArrayList<>();
    private ArrayList<Pionek> czarne = new ArrayList<>();

    public Plansza(){
        konstruujPlansze();
        dodajPionkaCzarnego();
        dodajPionkaBialego();
        ustawPionki();
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
                plansza[i][j] = ""+n;
            }
        }

        for (int i = 1; i<HEIGHT; i =i+4){                      // wypełnienie białymi polami wierszy parzystych
            for (int j = 1; j< WIDTH; j=j+4){
                char n = 9608;
                plansza[i][j] = ""+n;
            }

        }

    }

    public void dodajPionkaCzarnego(){
        for (int i = 1; i<6; i =i+4){
            for(int j = 3; j<16; j=j+4){                            // pionki w wierszach 6 i 8
                czarne.add(new Pionek(i,j,true));
            }

        }

        for(int j = 1; j<16; j=j+4){                            // pionki w wierszu 7
            czarne.add(new Pionek(3,j,true));
        }


    }

    public int getBialeSize(){
        return biale.size();
    }

    public void dodajPionkaBialego(){
        for (int i = 11; i<16; i =i+4){
            for(int j = 1; j<16; j=j+4){                            // pionki w wierszach 1 i 3
                biale.add(new Pionek(i,j,false));
            }

        }

        for(int j = 3; j<16; j=j+4){                            // pionki w wierszu 2
            biale.add(new Pionek(13,j,false));
        }


    }

    public int getCzarneSize(){
        return czarne.size();
    }

    public void ustawPionki(){
        for (Pionek a:biale) {
            char c = 9673;
            plansza[a.getPosLiczbowa()][a.getPosAlfabetyczna()] = ""+c;            // ustawienie pionków białych na planszy
        }

        for (Pionek a:czarne) {
            char c = 9678;
            plansza[a.getPosLiczbowa()][a.getPosAlfabetyczna()] = ""+c;            // ustawienie pionków czarnych na planszy
        }
    }

    public void rysujPlansze(){                                     //narysowanie zawartości planszy
        int temp = 0;
        for (int i = 0; i<kolumny.length; i++){                     //wyświetlenie alfabetycznego oznaczenia kolumn
            System.out.printf("\t"+"\t"+kolumny[i]);
        }
        System.out.println();
        for (int i = 0; i< HEIGHT; i++){

            if (i%2 !=0){                                              //w wierszach po których porusza się pionek wyświetelenie numerycznego oznaczenia wiersza
                System.out.printf(wiersze[temp]);
            } else {System.out.printf(" ");}

            for (int j = 0; j< HEIGHT; j++){
                if (plansza[i][j] == null){
                    System.out.printf("\t"+" ");                       //wyświetlenie pustego pola jeżeli nie ma na nim pionka
                }else {
                    System.out.format("\t"+plansza[i][j]);              //wyświetlenie pionka
                }
            }
            if (i%2 !=0){
                System.out.print(" "+wiersze[temp]);                   //w wierszach po których porusza się pionek wyświetelenie numerycznego oznaczenia wiersza
                temp++;
            } else {System.out.print(" ");}

            System.out.println();
        }
        for (int i = 0; i<kolumny.length; i++){                     //wyświetlenie alfabetycznego oznaczenia kolumn
            System.out.printf( "\t" + "\t"+kolumny[i]);
        }
        System.out.println();
    }

    public Pionek wyszukajPionek(int x, int y){
        Pionek szukany = null;
        for (Pionek b:biale) {
            if (b.getPosAlfabetyczna() == x && b.getPosLiczbowa() == y){
                System.out.println("To ten pionek");
                szukany = b;

            } else {
                System.out.println( " To nie ten pionek");
            }
        }

        for (Pionek b:czarne) {
            if (b.getPosAlfabetyczna() == x && b.getPosLiczbowa() == y){
                System.out.println("To ten pionek");
                szukany = b;

            } else {
                System.out.println( " To nie ten pionek");
            }
        }
        return szukany;
    }

    public void przesunPionek(int pozLiterowaStara, int pozLiczbowaStara, int pozLiterowaNowa, int pozLiczbowaNowa, boolean flaga){
        Pionek p =wyszukajPionek(pozLiterowaStara, pozLiczbowaStara);
        if (p.isFlag() == flaga) {
            plansza[pozLiczbowaStara][pozLiterowaStara] = " ";
            p.wykonajRuch(pozLiterowaStara, pozLiczbowaStara, pozLiterowaNowa, pozLiczbowaNowa);
            usunPionek(pozLiterowaStara, pozLiczbowaStara, pozLiterowaNowa, pozLiczbowaNowa,flaga);
        } else{
            System.out.println("Ruszasz zły pionek!!!");
        }
    }

    public void usunPionek(int pozLiterowaStara, int pozLiczbowaStara, int pozLiterowaNowa, int pozLiczbowaNowa, boolean flaga){
        if(pozLiczbowaNowa-pozLiczbowaStara !=2 && pozLiterowaNowa-pozLiterowaStara !=2){
            int pozLiczbowaBita = pozLiczbowaStara + (pozLiczbowaNowa-pozLiczbowaStara)/2;
            int pozLiterowaBita = pozLiterowaStara + (pozLiterowaNowa-pozLiterowaStara)/2;
            int indexBiale = -1;
            int indexCzarne = -1;
            for (Pionek b:biale) {
                if (b.getPosAlfabetyczna() == pozLiterowaBita && b.getPosLiczbowa() == pozLiczbowaBita && flaga != b.isFlag()){
                    System.out.println("Ten pionek został zbity");
                    indexBiale =  biale.indexOf(b);
                } else if (flaga == b.isFlag()){
                    System.out.println( "Nie można zbić własnego pionka");
                }
            }
            if (indexBiale !=-1){
                biale.remove(indexBiale);
            }

            for (Pionek b:czarne) {
                if (b.getPosAlfabetyczna() ==  pozLiterowaBita && b.getPosLiczbowa() == pozLiczbowaBita && flaga != b.isFlag()){
                    System.out.println("Ten pionek został zbity");
                    indexCzarne= czarne.indexOf(b);

                } else if (flaga == b.isFlag()) {
                    System.out.println( "Nie można zbić własnego pionka");
                }
            }
            if (indexCzarne !=-1){
                czarne.remove(indexCzarne);
            }
            System.out.println("Ilość pionków białych: " + biale.size() + " Ilość pionków czarnych: " + czarne.size());
            plansza[pozLiczbowaBita][pozLiterowaBita] = " ";

        }
    }
}
