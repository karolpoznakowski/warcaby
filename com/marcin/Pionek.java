package com.marcin;

public class Pionek {
    private int posLiczbowa;
    private int posAlfabetyczna;
    private boolean flag;

    public Pionek(int posLiczbowa, int posAlfabetyczna, boolean flag){
        this.posLiczbowa = posLiczbowa;
        this.posAlfabetyczna = posAlfabetyczna;
        this.flag = flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setPosAlfabetyczna(int posAlfabetyczna) {
        this.posAlfabetyczna = posAlfabetyczna;
    }

    public void setPosLiczbowa(int posLiczbowa) {
        this.posLiczbowa = posLiczbowa;
    }

    public int getPosLiczbowa() {
        return posLiczbowa;
    }

    public int getPosAlfabetyczna() {
        return posAlfabetyczna;
    }
    public boolean isFlag() {
        return flag;
    }

    public void wykonajRuch(int xs, int ys, int xn, int yn){
        if (Math.abs(xs-xn)==2 && Math.abs(ys-yn)==2){
            przesuniecie(xn,yn);
        } else if (Math.abs(xs-xn)==4 && Math.abs(ys-yn)==4){
          System.out.print("bicie");
          bicie();
        } else {
            System.out.println("Taki ruch jest niepoprawny");
        }
    }

    private void przesuniecie(int xn, int yn){
        posLiczbowa=yn;
        posAlfabetyczna=xn;
        System.out.println("Przesunąłeś pionka");
    }

    private void bicie(){
        System.out.println("Zbiłeś pionka");
    }
}
