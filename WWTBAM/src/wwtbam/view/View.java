/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.view;

import javax.swing.JFrame;
import wwtbam.controller.IItemObserver;

/**
 *
 * @author lipat
 */
public class View extends JFrame{
    QuestionPanel questionPanel;
    HomePanel homePanel;
    public View() {
        questionPanel=new QuestionPanel();
        homePanel=new HomePanel();
     
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.add(questionPanel);
        this.setVisible(true);
    }
    
    public void addObserver(IItemObserver iItemObserver){
        questionPanel.addObserver(iItemObserver);
    }
    
    
}
//d
