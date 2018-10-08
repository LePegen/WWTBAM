/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.model.implementations;

import wwtbam.model.IChoice;

/**
 *
 * @author lipat
 */
public class Choice implements IChoice{
    String choice;
    boolean isCorrect;

    public Choice(String choice, boolean isCorrect) {
        this.choice = choice;
        this.isCorrect = isCorrect;
    }
    
    
    @Override
    public boolean isCorrect() {
        return this.isCorrect;
    }

    @Override
    public String getChoice() {
        return this.choice;
    }
    
}
