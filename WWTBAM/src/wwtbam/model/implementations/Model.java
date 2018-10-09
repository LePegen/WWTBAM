/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.model.implementations;

import factory.IItemFactory;
import factory.implementations.*;
import wwtbam.model.implementations.Difficulty;
import java.util.ArrayList;
import wwtbam.model.IChoice;
import wwtbam.model.IItem;
import wwtbam.model.IModel;

/**
 *
 * @author lipat
 */
public class Model implements IItem, IModel {

    ArrayList<IItem> items;
    IItem currentItem;
    int questionNumber;
    IItemFactory itemFactory;
    
    boolean lifeline1;
    boolean lifeline2;
    boolean lifeline3;
    
    int prize;
    int timeLeft;
    int totalTimeLeft;

    public Model() {
        itemFactory = new ItemFactory();
        this.items = itemFactory.getItems();
        questionNumber = -1;
        prize = 0;
        nextItem();
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public boolean isLifeline1() {
        return lifeline1;
    }

    public void setLifeline1(boolean lifeline1) {
        this.lifeline1 = lifeline1;
    }

    public boolean isLifeline2() {
        return lifeline2;
    }

    public void setLifeline2(boolean lifeline2) {
        this.lifeline2 = lifeline2;
    }

    public boolean isLifeline3() {
        return lifeline3;
    }

    public void setLifeline3(boolean lifeline3) {
        this.lifeline3 = lifeline3;
    }
    
    
    
    

    public int getTotalTime() {
        return totalTimeLeft;
    }
    
    public Difficulty getDifficulty(){
    return this.currentItem.getDifficulty();
    }
    

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public int getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }
    
    
    
    

    @Override
    public String getQuestion() {
        return currentItem.getQuestion();
    }

    @Override
    public ArrayList<IChoice> getChoices() {
        return currentItem.getChoices();
    }

    @Override
    public Boolean isCorrect() {
        return currentItem.isCorrect();
    }

    @Override
    public void setCorrect(Boolean bool) {
        currentItem.setCorrect(bool);
    }

    @Override
    public IItem getCurrentItem() {
        return currentItem;
    }

    @Override
    public boolean nextItem() {
        if (questionNumber < items.size()) {
            questionNumber++;
            currentItem = items.get(questionNumber);
            this.timeLeft=currentItem.getDifficulty().getTime();
            this.totalTimeLeft = currentItem.getDifficulty().getTime();

            return true;
        }
        return false;
    }

    @Override
    public int getSize() {
        return items.size();
    }

    @Override
    public IItem getItem(int index) {
        return items.get(index);
    }

}
