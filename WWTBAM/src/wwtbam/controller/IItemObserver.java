/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.controller;

import wwtbam.model.IChoice;

/**
 *
 * @author lipat
 */

//pseudo observer design pattern
public interface IItemObserver {

    void choicePressed(IChoice choice);

    void toHomePanel();

    void toQuestionPanel();

    void toGameOver();

    void toContinuePanel();
    
    void restart();
    
    void exitGame();
    
    void start();

    void lifeLine2();

    void lifeLine1();

    void lifeLine3();
}
