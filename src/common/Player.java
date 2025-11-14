package common;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private String name;
    private int hp = 5;
    private List<Integer> stones = new ArrayList<>(); // stone IDs 1..8


    public Player(String name) {
        this.name = name;
    }
    public String getName() { return name; }
    public int getHp() { return hp; }
    public void setHp(int hp) { this.hp = hp; }
    public List<Integer> getStones() { return stones; }
}
