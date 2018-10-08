/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.model;

/**
 *
 * @author lipat
 */
public class DifficultyFactory {

    public Difficulty getDifficulty(String difficulty) {
        Difficulty toReturn = null;
        switch (difficulty) {
            case "Easy":
                return new Difficulty(30, "Easy", 20000);
             
            case "Intermediate":
                return new Difficulty(30, "Intermediate", 20000);

            case "Hard":
                return new Difficulty(30, "Hard", 20000);


        }
        return toReturn;
    }
}
