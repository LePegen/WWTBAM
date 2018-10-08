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
public class Model implements IItem, IModel {

    ArrayList<IItem> items;
    IItem currentItem;
    int questionNumber;
    ItemFactory itemFactory;
    int prize;

    public Model() {
        itemFactory=new ItemFactory();
        this.items=itemFactory.getItems();
        questionNumber = -1;
        prize=0;
        nextItem();
    }
    
    public int getPrize(){
    return prize;
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
            currentItem=items.get(questionNumber);
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
