package main;

public class Player {
    private String name;
    private int id;

    public Player(int id, String  name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format(id+" "+ name);
    }
}
