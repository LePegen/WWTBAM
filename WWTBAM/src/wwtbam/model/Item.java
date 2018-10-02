/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.model;

import java.util.ArrayList;

/**
 *
 * @author lipat
 */
public class Item {
   
    private String question;
    private ArrayList<AbstractAnswer> choices;
    private boolean isCorrect=false;

    public Item(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<AbstractAnswer> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<AbstractAnswer> choices) {
        this.choices = choices;
    }

    public boolean isIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }
    
    
    
    
    
    
    
}
