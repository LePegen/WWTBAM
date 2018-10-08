/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.model;

/**
 *
 * @author chescapaor
 */
public class Prize {
    
    
    public int getPrize(Item item){
        int prize=0;
        switch(item.getDifficulty()){
            case "Easy":
                prize=20000;
                break;
                case "Intermediate":
                    prize=150000;
                break;
                case "Hard":
                    prize=450000;
                break;
        }
        return prize;
    }
    
}
