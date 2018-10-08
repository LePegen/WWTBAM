/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.view;

import wwtbam.view.components.GameOverPanel;
import wwtbam.view.components.ContinuePanel;
import wwtbam.view.components.HomePanel;
import wwtbam.view.components.QuestionPanel;
import java.awt.CardLayout;
import javax.swing.*;
import wwtbam.controller.IItemObserver;
import wwtbam.view.components.AboutPanel;
import wwtbam.view.components.InstructionPanel;

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

    /**
     * to add: about panel how to play panel winner panel
     */
    public View() {
        questionPanel = new QuestionPanel();
        homePanel = new HomePanel();
        gameOverPanel = new GameOverPanel();
        continuePanel = new ContinuePanel();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("Who wants to be a millionaire");
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
