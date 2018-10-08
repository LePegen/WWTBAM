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
public interface IItemObserver {
    void choicePressed(IChoice choice);
    void toHomePanel();
    void toQuestionPanel();
    void toGameOver();
}
