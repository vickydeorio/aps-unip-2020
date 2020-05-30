package main.java.com.aps.cc.unip.utils;

public class IdGenerator {
    private int id;

    public IdGenerator(){
        this.id = 0;
    }

    public int getId(){
        this.id++;

        return this.id;
    }
}
