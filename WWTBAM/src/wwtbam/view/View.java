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
public class View extends JFrame{
    QuestionPanel questionPanel;
    HomePanel homePanel;
    
    JPanel currentPanel;
    
    public View() {
        questionPanel=new QuestionPanel();
        homePanel=new HomePanel();
     
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        
        this.setPanel(homePanel);
        this.setVisible(true);
        
        this.setPanel(homePanel);
       
    }
    
    public QuestionPanel getQuestionPanel(){
    return this.questionPanel;
    }
    
    public void setPanel(JPanel panel){
        if (currentPanel != null) {
        this.remove(currentPanel);
        }
        this.currentPanel=panel;
        this.add(currentPanel);
        this.validate();

    }
    
    public HomePanel getHomePanel(){
    return this.homePanel;
    }
    
        
    public void addObserver(IItemObserver iItemObserver){
        questionPanel.addObserver(iItemObserver);
        homePanel.setObserver(iItemObserver);
    }
    
    
}
//d
