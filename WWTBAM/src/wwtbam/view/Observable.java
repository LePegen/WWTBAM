/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.view;

import wwtbam.controller.IItemObserver;

/**
 *
 * @author lipat
 */
public interface Observable {
    
    public void addObserver(IItemObserver observer);
    
}
