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
public interface IModel {
    /**
     * @see IItem
     * @return returns the current question
     */
    IItem getCurrentItem();
    boolean nextItem();
    int getSize();
    IItem getItem(int index);
    
}
