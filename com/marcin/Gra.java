package com.marcin;

public class Gra {
    public static void main(String[]args){
        int pozLiterowaStara;
        int pozLiczbowaStara;
        int pozLiterowaNowa;
        int pozLiczbowaNowa;
        boolean kolej;

        Plansza plansza = new Plansza();
        PomocnikGry pomocnikGry = new PomocnikGry();
        do {
            do {
                try{
                    pomocnikGry.odczytPozPionka("Ruch białych. Podaj pionek który ma zostać przesunięty: ");
                    try {
                        kolej = false;
                        pozLiterowaStara = pomocnikGry.konwersjaWspolrzedneLiterowe();
                        pozLiczbowaStara = pomocnikGry.konwersjaWspolrzedneLiczbowe();
                        if (plansza.testZgodnosci(pozLiterowaStara,pozLiczbowaStara,kolej)==kolej) {
                            pomocnikGry.odczytPozPionka("Podaj na które pole ma zostać przesunięty");
                            pozLiterowaNowa = pomocnikGry.konwersjaWspolrzedneLiterowe();
                            pozLiczbowaNowa = pomocnikGry.konwersjaWspolrzedneLiczbowe();
                            plansza.przesunPionek(pozLiterowaStara, pozLiczbowaStara, pozLiterowaNowa, pozLiczbowaNowa, false);
                        } else {
                            throw new IllegalArgumentException("Ruszasz złego pionka");
                        }
                    }
                    catch (NullPointerException f) {
                        System.out.println(f + "Proszę podać prawidłowe dane");
                        kolej = true;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println(e + "Proszę podać prawidłowe dane");
                        kolej = true;
                    }
                }

                catch (ArrayIndexOutOfBoundsException g){
                    System.out.println(g + "Proszę podać prawidłowe dane");
                    kolej = true;
                }


            } while (kolej == true);

            plansza.ustawPionki();
            plansza.rysujPlansze();
            do {
                try {
                    pomocnikGry.odczytPozPionka("Ruch czarnych. Podaj pionek który ma zostać przesunięty: ");
                    try {
                        kolej = true;
                        pozLiterowaStara = pomocnikGry.konwersjaWspolrzedneLiterowe();
                        pozLiczbowaStara = pomocnikGry.konwersjaWspolrzedneLiczbowe();
                        if (plansza.testZgodnosci(pozLiterowaStara,pozLiczbowaStara,kolej)==kolej) {
                            pomocnikGry.odczytPozPionka("Podaj na które pole ma zostać przesunięty");
                            pozLiterowaNowa = pomocnikGry.konwersjaWspolrzedneLiterowe();
                            pozLiczbowaNowa = pomocnikGry.konwersjaWspolrzedneLiczbowe();
                            plansza.przesunPionek(pozLiterowaStara, pozLiczbowaStara, pozLiterowaNowa, pozLiczbowaNowa, true);
                        } else {
                            throw new IllegalArgumentException("Ruszasz złego pionka");
                        }
                    }
                    catch (NullPointerException f) {
                        System.out.println("Proszę podać prawidłowe dane");
                        kolej = false;
                    }
                    catch (IllegalArgumentException e){
                        System.out.println("Proszę podać prawidłowe dane");
                        kolej = false;
                    }
                }
                catch (ArrayIndexOutOfBoundsException g){
                    System.out.println(g + "Proszę podać prawidłowe dane");
                    kolej = false;
                }

            } while (kolej == false);
            plansza.ustawPionki();
            plansza.rysujPlansze();
        } while (plansza.getBialeSize() != 0 || plansza.getCzarneSize() !=0);

    }
}
