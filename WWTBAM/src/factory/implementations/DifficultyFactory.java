/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.implementations;

import factory.IDifficultyFactory;
import wwtbam.model.implementations.Difficulty;

/**
 *
 * @author lipat
 */
public class DifficultyFactory implements IDifficultyFactory{

    public Difficulty getDifficulty(String difficulty) {
        Difficulty toReturn = null;
        switch (difficulty) {
            case "Easy":
                return new Difficulty(30, "Easy", 20000);
             
            case "Intermediate":
                return new Difficulty(20, "Intermediate", 150000);

            case "Hard":
                return new Difficulty(15, "Hard", 450000);


        }
        return toReturn;
    }
}
