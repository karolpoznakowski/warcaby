package com.marcin;

public class Gra {
    public static void main(String[]args){
        int pozLiterowaStara;
        int pozLiczbowaStara;
        int pozLiterowaNowa;
        int pozLiczbowaNowa;

        Plansza plansza = new Plansza();
        PomocnikGry pomocnikGry = new PomocnikGry();
        do {
        pomocnikGry.odczytPozPionka("Ruch białych. Podaj pionek który ma zostać przesunięty: ");
            pozLiterowaStara = pomocnikGry.konwersjaWspolrzedneLiterowe();
            pozLiczbowaStara = pomocnikGry.konwersjaWspolrzedneLiczbowe();
            pomocnikGry.odczytPozPionka("Podaj na które pole ma zostać przesunięty");
            pozLiterowaNowa = pomocnikGry.konwersjaWspolrzedneLiterowe();
            pozLiczbowaNowa = pomocnikGry.konwersjaWspolrzedneLiczbowe();
            plansza.przesunPionek(pozLiterowaStara,pozLiczbowaStara,pozLiterowaNowa,pozLiczbowaNowa,false);
            plansza.ustawPionki();
            plansza.rysujPlansze();
            pomocnikGry.odczytPozPionka("Ruch czarnych. Podaj pionek który ma zostać przesunięty: ");
            pozLiterowaStara = pomocnikGry.konwersjaWspolrzedneLiterowe();
            pozLiczbowaStara = pomocnikGry.konwersjaWspolrzedneLiczbowe();
            pomocnikGry.odczytPozPionka("Podaj na które pole ma zostać przesunięty");
            pozLiterowaNowa = pomocnikGry.konwersjaWspolrzedneLiterowe();
            pozLiczbowaNowa = pomocnikGry.konwersjaWspolrzedneLiczbowe();
            plansza.przesunPionek(pozLiterowaStara,pozLiczbowaStara,pozLiterowaNowa,pozLiczbowaNowa,true);
            plansza.ustawPionki();
            plansza.rysujPlansze();
        } while (plansza.getBialeSize() != 0 || plansza.getCzarneSize() !=0);

    }
}
