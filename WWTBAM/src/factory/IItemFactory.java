/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.util.ArrayList;
import wwtbam.model.IItem;

/**
 *
 * @author lipat
 */
public interface IItemFactory {
    ArrayList<IItem> getItems();
}
