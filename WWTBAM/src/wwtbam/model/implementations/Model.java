/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.model.implementations;

import factory.ItemFactory;
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
    ItemFactory itemFactory;
    
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
