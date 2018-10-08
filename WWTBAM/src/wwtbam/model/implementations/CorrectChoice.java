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
public class CorrectChoice implements IChoice {

    private boolean correct;
    private String choice;

    public CorrectChoice(String choice) {
        correct = true;
        this.choice = choice;
    }

    @Override
    public boolean isCorrect() {
        return correct;
    }

    @Override
    public String getChoice() {
        return this.choice;
    }

}
