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
public class FalseChoice implements IChoice {

    private boolean correct;
    private String choice;

    public FalseChoice(String choice) {
        correct = false;
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
