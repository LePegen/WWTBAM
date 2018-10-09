/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.controller;

import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import wwtbam.model.IChoice;
import wwtbam.model.implementations.Model;
import wwtbam.view.View;
import wwtbam.view.components.QuestionPanel;

/**
 *
 * @author lipat
 */
public class Controller implements IItemObserver, Updateable {

    /**
     * Not fully MVC due to nature of java swing The idea of the project is to
     * show as much object oriented design as possible
     */
    Model model;
    View view;
    Timer time;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.addObserver(this);
        time = new Timer(this);
        time.run();
    }

    //better to separate
    @Override
    public void update() {
        model.setTimeLeft(time.getTime());
        view.getQuestionPanel().getQuestion().setText(model.getQuestion());
        view.getQuestionPanel().getQuestionNumber().setText(String.valueOf(model.getQuestionNumber() + 1));
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
        JLabel tempLabel = view.getQuestionPanel().getPrizeLabels().get(model.getQuestionNumber());
        view.getQuestionPanel().highlightLabel(tempLabel);
    }

    //logic
    @Override
    public void choicePressed(IChoice choice) {
        time.stopTimer();
        //debugging solution
        if (model.getQuestionNumber() < 9) {
            if (choice.isCorrect()) {
                //then increment score of model
                model.setPrize(model.getDifficulty().getPrize() + model.getPrize());
                model.nextItem();
                restartTimer();
                toContinuePanel();
            } else {
                view.getQuestionPanel().revealAnswer();
                update();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                }
                model.setPrize(0);
                toGameOver();
            }
        } else {
            toGameOver();
        }
    }

    public void restartTimer() {
        view.getQuestionPanel().getTimeLeft().setMaximum(model.getDifficulty().getTime());
        time.setTimeLeft(model.getDifficulty().getTime());
        time.startTimer();
    }

    public static void main(String[] s) {
        Controller controller = new Controller(new Model(), new View());
    }

    public void restart() {
        view.setVisible(false);
        view.dispose();
        this.model = new Model();
        this.view = new View();
        this.view.addObserver(this);

        time.setTimeLeft(model.getTotalTime());
        view.getQuestionPanel().getTimeLeft().setMaximum(model.getTotalTime());
        time.startTimer();
        update();
    }

    //observer functions
    @Override
    public void toHomePanel() {
        view.setPanel(view.getHomePanel());
        update();

    }

    @Override
    public void toQuestionPanel() {

        restartTimer();
        view.setPanel(view.getQuestionPanel());
        update();

    }

    @Override
    public void toGameOver() {
        view.getGameOverPanel().getPrizelbl().setText(String.valueOf(model.getPrize()));
        view.setPanel(view.getGameOverPanel());
        update();

    }

    @Override
    public void toContinuePanel() {
        view.setPanel(view.getContinuePanel());
        update();

    }

    @Override
    public void cantUpdate() {
        toGameOver();
    }

    @Override
    public void exitGame() {
        System.exit(0);
    }

    @Override
    public void start() {
        time.setTimeLeft(model.getTotalTime());
        view.getQuestionPanel().getTimeLeft().setMaximum(model.getTotalTime());
        time.startTimer();
    }

    @Override
    public void lifeLine1() {
        for (int i = 0; i < 2; i++) {
            if(view.getQuestionPanel().getButtons().get(i).getChoice().isCorrect()){
                i--;
            }else{
                view.getQuestionPanel().getButtons().get(i).setEnabled(false);
            }
            
        }
    }
    
    @Override
    public void lifeLine2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void lifeLine3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
