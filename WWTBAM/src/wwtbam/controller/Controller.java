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
public class Controller implements IItemObserver {

    Model model;
    View view;

    //baseplate code done
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.addObserver(this);
      
        update();

    }

    /*
    to add:
    void update() <-- will get information from model then set info to view
    void changePanel() <-- will change panel from title to questions to game over
    void gameOver() <-- when wrong choice
    void time() <-- timer. when ran out then game over
     */
    void update() {

        view.getQuestionPanel().getChoice1().setText(model.getChoices().get(0).getChoice());
        view.getQuestionPanel().getChoice2().setText(model.getChoices().get(1).getChoice());
        view.getQuestionPanel().getChoice3().setText(model.getChoices().get(2).getChoice());
        view.getQuestionPanel().getChoice4().setText(model.getChoices().get(3).getChoice());

    }

    @Override
    public void choicePressed(IChoice choice) {
        if (choice.isCorrect()) {
            //then increment score of model
            model.nextItem();
            update();
            System.out.println("Correct");
        } else {
            //game over
        }
    }

    public static void main(String[] args) {
        new Controller(new Model(), new View());
    }

    @Override
    public void toHomePanel() {
        view.setPanel(view.getHomePanel());
        }

    @Override
    public void toQuestionPanel() {
                view.setPanel(view.getQuestionPanel());
    }

    @Override
    public void toGameOver() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
