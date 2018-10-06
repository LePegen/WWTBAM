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
    int index;
    ItemFactory itemFactory;

    public Model() {
        itemFactory=new ItemFactory();
        this.items=itemFactory.getItems();
        index = -1;
        nextItem();
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
        if (index < items.size()) {
            index++;
            currentItem=items.get(index);
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
