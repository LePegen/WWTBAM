/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.controller;

import wwtbam.model.IChoice;
import wwtbam.model.Model;
import wwtbam.view.View;

/**
 *
 * @author lipat
 */
public class Controller implements IItemObserver{
    Model model;
    View view;
    
    //baseplate code done
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.addObserver(this);
    }
    
    /*
    to add:
    void update() <-- will get information from model then set info to view
    void changePanel() <-- will change panel from title to questions to game over
    void gameOver() <-- when wrong choice
    void time() <-- timer. when ran out then game over
    */
    
    
    @Override
    public void choicePressed(IChoice choice) {
        if(choice.isCorrect()){
            //then increment score of model
            System.out.println("Correct");
        }else{
        //game over
        }
    }
    
    public static void main(String[] args) {
        new Controller(new Model(), new View());
    }
    
}
 
