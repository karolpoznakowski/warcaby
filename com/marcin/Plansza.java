package com.marcin;

public class Plansza {
    private int width;
    private int height;

    public Plansza(){
        this.width = 8;
        this.height = 8;
        rysuj();
    }

    public void rysuj(){
        for (int m = 0; m<width;m++){
            System.out.print(" _");
        }
        System.out.println();
        for (int j=0; j<height;j++){

            System.out.print("|");
            for (int i = 0; i<width;i++){
                System.out.print("_|");
            }

            System.out.println();

        }

    }
}
