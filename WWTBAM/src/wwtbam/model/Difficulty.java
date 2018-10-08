/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.model;

/**
 *
 * @author lipat
 */
public class Difficulty {
    private int time;
    private String name;
    private int prize;

    public Difficulty(int time, String name, int prize) {
        this.time = time;
        this.name = name;
        this.prize = prize;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }
    
}
