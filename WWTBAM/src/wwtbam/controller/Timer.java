/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lipat
 */
public class Timer implements Runnable, Updateable {

    private int time;
    private int totalTime;
    private boolean isRunning = false;
    private Updateable toUpdate;

    public Timer(Updateable toUpdate) {
        this.toUpdate = toUpdate;
    }

    public int getTime() {

        return time;
    }

    public void setTimeLeft(int seconds) {
        this.stopTimer();
        this.totalTime = seconds;
        this.time = seconds;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void startTimer() {
        isRunning = true;
    }

    public void stopTimer() {
        isRunning = false;
    }

    @Override
    public void run() {
        while (true) {
            if (isRunning == true && time > 0) {
                time--;
                update();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

    @Override
    public void update() {
        this.toUpdate.update();
    }

}
