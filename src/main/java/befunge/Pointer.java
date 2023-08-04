package befunge;

import exceptions.BefungeException;

public class Pointer {
    private int x;
    private int y;

    public Pointer(int x, int y) {
        this.x = x;
        this.y = y;
        if(x<0||x>=25||y<0||y>=80) throw new BefungeException("Pointer outside  screen boundaries!");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void moveTo(Direction move){
        x+= move.getX();
        y+= move.getY();
        if(x<0||x>=25||y<0||y>=80) throw new BefungeException("Pointer outside  screen boundaries!");
    }
}
