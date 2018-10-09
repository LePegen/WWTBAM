/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.view;

import javax.swing.*;

/**
 *
 * @author lipat
 */
public interface IQuestionPanel{
    //todo: add documentation
    JLabel getQuestionNumber();

    JTextPane getQuestion();

    JButton getChoice1();

    JButton getChoice2();

    JButton getChoice3();

    JButton getChoice4();
    
    JProgressBar getTimeLeft();

}
