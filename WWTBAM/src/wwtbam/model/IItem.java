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
public interface IItem {

    /**
     * Returns the question to be asked
     * @return question to be asked
     */
    public String getQuestion();
    /**
     * 
     * @return array of choices
     */
    public ArrayList<IChoice> getChoices();
    /**
     * If user selected the correct choice then true
     * @return if user selected the correct choice
     */
    public Boolean isCorrect();
    /**
     * @param bool set true if selected CorrectChoice
     */
    public void setCorrect(Boolean bool);

}
