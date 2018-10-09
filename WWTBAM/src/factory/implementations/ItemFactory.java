/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory.implementations;

import factory.IItemFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.JSONObject;
import wwtbam.model.IItem;
import factory.implementations.jsonRetrieve.IJsonParse;
import factory.implementations.jsonRetrieve.JsonParse;

/**
 *
 * @author lipat
 */
public class ItemFactory implements IItemFactory{
    ///could use some work
    IJsonParse jsonParse;
    ArrayList<IItem> items;

    public ItemFactory() {
        jsonParse = new JsonParse("src\\factory\\implementations\\jsonRetrieve\\choices.json");
        this.items=jsonParse.getItems();
    }

    @Override
    public ArrayList<IItem> getItems() {
        return items;
    }

        

}
