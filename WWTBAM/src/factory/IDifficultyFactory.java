/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import wwtbam.model.implementations.Difficulty;

/**
 *
 * @author lipat
 */
public interface IDifficultyFactory {
    
    Difficulty getDifficulty(String difficulty); 
    
}
