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
public interface AbstractItem {
    public String getQuestion();
    public ArrayList<AbstractChoice> getChoices();
    public Boolean isCorrect();
    public void setCorrect(Boolean bool);
    
    
}
