/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.controller;

import javax.swing.JLabel;
import wwtbam.model.IChoice;
import wwtbam.model.Model;
import wwtbam.view.View;

/**
 *
 * @author lipat
 */
public class Controller implements IItemObserver, Updateable {

    Model model;
    View view;
    Timer time;

    //baseplate code done
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.addObserver(this);
        time = new Timer(this);
        time.setTimeLeft(model.getTotalTime());
        view.getQuestionPanel().getTimeLeft().setMaximum(model.getTotalTime());
        time.startTimer();
        time.run();
        update();
    }

    /*
    to add:
    void update() <-- will get information from model then set info to view
    void changePanel() <-- will change panel from title to questions to game over
    void gameOver() <-- when wrong choice
    void time() <-- timer. when ran out then game over
     */
    @Override
    public void update() {
        model.setTimeLeft(time.getTime());
        view.getQuestionPanel().getQuestion().setText(model.getQuestion());
        view.getQuestionPanel().getQuestionNumber().setText(String.valueOf(model.getSize()));
        view.getQuestionPanel().getChoice1().setText(model.getChoices().get(0).getChoice());
        view.getQuestionPanel().getChoice2().setText(model.getChoices().get(1).getChoice());
        view.getQuestionPanel().getChoice3().setText(model.getChoices().get(2).getChoice());
        view.getQuestionPanel().getChoice4().setText(model.getChoices().get(3).getChoice());
        view.getQuestionPanel().getChoice1().setChoice(model.getChoices().get(0));
        view.getQuestionPanel().getChoice2().setChoice(model.getChoices().get(1));
        view.getQuestionPanel().getChoice3().setChoice(model.getChoices().get(2));
        view.getQuestionPanel().getChoice4().setChoice(model.getChoices().get(3));
        view.getQuestionPanel().getTimeLeft().setValue(model.getTimeLeft());
        view.getContinuePanel().getPrizeLbl().setText(String.valueOf(model.getPrize()));
        JLabel tempLabel=view.getQuestionPanel().getPrizeLabels().get(model.getQuestionNumber());
      
        view.getQuestionPanel().highlightLabel(tempLabel);
                
    }
    

    @Override
    public void choicePressed(IChoice choice) {
        if (choice.isCorrect()) {
            //then increment score of model
            model.setPrize(model.getDifficulty().getPrize()+model.getPrize());
            System.out.println(model.getPrize());
            model.nextItem();
            view.getQuestionPanel().getTimeLeft().setMaximum(model.getDifficulty().getTime());
            time.setTimeLeft(model.getDifficulty().getTime());
            time.startTimer();
            update();
            System.out.println("Correct");
            toContinuePanel();
        } else {
            toGameOver();
            //game over
        }
    }

    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
    }

    @Override
    public void toHomePanel() {
        view.setPanel(view.getHomePanel());
    }

    @Override
    public void toQuestionPanel() {
        view.validate();
        view.setPanel(view.getQuestionPanel());
        
    }

    @Override
    public void toGameOver() {
        view.setPanel(view.getGameOverPanel());
    }

    @Override
    public void toContinuePanel() {
        view.setPanel(view.getContinuePanel());
    }

}
