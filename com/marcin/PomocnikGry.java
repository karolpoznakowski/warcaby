package com.marcin;

import java.util.Scanner;

public class PomocnikGry {
    private char[] pozPionka;
    private Scanner odczyt;

    public PomocnikGry() {
        odczyt = new Scanner(System.in);
    }

    public char[] odczytPozPionka(String t) {
        System.out.println(t);
        pozPionka = odczyt.nextLine().toLowerCase().toCharArray();
        return pozPionka;
    }



    public int konwersjaWspolrzedneLiterowe() {
        int t;
        char x = pozPionka[0];
        switch (x) {
            case 'a':
                t = 1;
                break;
            case 'b':
                t = 3;
                break;
            case 'c':
                t = 5;
                break;
            case 'd':
                t = 7;
                break;
            case 'e':
                t = 9;
                break;
            case 'f':
                t = 11;
                break;
            case 'g':
                t = 13;
                break;
            case 'h':
                t =  15;
                break;
            default:
                t = -1;
                System.out.println("Coś poszło nie tak");
        }
        System.out.print(t);
        return t;
    }

    public int konwersjaWspolrzedneLiczbowe() {
        int t;
        char x = pozPionka[1];
        switch (x) {
            case '8':
                t = 1;
                break;
            case '7':
                t = 3;
                break;
            case '6':
                t = 5;
                break;
            case '5':
                t = 7;
                break;
            case '4':
                t = 9;
                break;
            case '3':
                t = 11;
                break;
            case '2':
                t = 13;
                break;
            case '1':
                t =  15;
                break;
            default:
                t = -1;
                System.out.println("Coś poszło nie tak");
        }
        System.out.println(t);
        return t;
    }


}
