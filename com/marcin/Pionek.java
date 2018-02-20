package com.marcin;

public class Pionek {
    private int posx;
    private int posy;
    private boolean flag;

    public Pionek(int posx, int posy, boolean flag){
        this.posx = posx;
        this.posy = posy;
        this.flag = flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }
    public boolean isFlag() {
        return flag;
    }
}
