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
public class Item implements IItem {

    private String question;
    private String difficulty;
    private ArrayList<IChoice> choices;
    private boolean isCorrect = false;
    /**
     * 
     * @param question
     * @param answer 
     */
    public Item(String question,String difficulty) {
        this.question = question;
      
        this.difficulty=difficulty;
    }
    /**
     * 
     * @return 
     */
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

 

    public void setChoices(ArrayList<IChoice> choices) {
        this.choices = choices;
    }


    @Override
    public ArrayList<IChoice> getChoices() {
        return choices;
    }

    @Override
    public Boolean isCorrect() {
        return isCorrect;
    }

    @Override
    public void setCorrect(Boolean bool) {
            this.isCorrect=bool;
    }

}
