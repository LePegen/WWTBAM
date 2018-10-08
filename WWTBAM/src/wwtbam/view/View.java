/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.view;

import java.awt.CardLayout;
import javax.swing.*;
import wwtbam.controller.IItemObserver;

/**
 *
 * @author lipat
 */
public class View extends JFrame {

    QuestionPanel questionPanel;
    HomePanel homePanel;
    GameOverPanel gameOverPanel;
    ContinuePanel continuePanel;

    JPanel currentPanel;

    public View() {
        questionPanel = new QuestionPanel();
        homePanel = new HomePanel();
        gameOverPanel = new GameOverPanel();
        continuePanel = new ContinuePanel();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);

        this.setPanel(homePanel);
        this.setVisible(true);
      

    }

 
    public void setPanel(JPanel panel) {
        if (currentPanel != null) {
            this.remove(currentPanel);
        }
        this.currentPanel = panel;
        this.add(currentPanel);
        this.validate();
        this.repaint();
        
    }   
    
    public QuestionPanel getQuestionPanel() {
        return questionPanel;
    }

    public HomePanel getHomePanel() {
        return homePanel;
    }

    public GameOverPanel getGameOverPanel() {
        return gameOverPanel;
    }

    public ContinuePanel getContinuePanel() {
        return continuePanel;
    }

    public void addObserver(IItemObserver iItemObserver) {
        questionPanel.addObserver(iItemObserver);
        homePanel.addObserver(iItemObserver);
        gameOverPanel.addObserver(iItemObserver);
        continuePanel.addObserver(iItemObserver);
    }

}
//d
