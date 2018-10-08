/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.model.implementations;

import wwtbam.model.implementations.Difficulty;
import java.util.ArrayList;
import java.util.Collections;
import wwtbam.model.IChoice;
import wwtbam.model.IItem;

/**
 *
 * @author lipat
 */
public class Item implements IItem {

    private String question;
    private Difficulty difficulty;
    private ArrayList<IChoice> choices;
    private boolean isCorrect = false;
    /**
     * 
     * @param question
     * @param answer 
     */
    public Item(String question) {
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
    
    public Difficulty getDifficulty(){
        return this.difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
    
    

 

    public void setChoices(ArrayList<IChoice> choices) {        
        this.choices = choices;
        Collections.shuffle(choices);

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
