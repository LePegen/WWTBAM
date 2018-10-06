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
public interface IChoice {
    /**
     * 
     * @return true if is a correct choice
     */
    public boolean isCorrect();
    /**
     * This is the text to be put in the JButton
     * 
     * @return returns the value of the choice
     */
    public String getChoice();
}
