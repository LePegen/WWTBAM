/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import org.json.JSONObject;
import wwtbam.model.jsonRetrieve.ParseJson;

/**
 *
 * @author lipat
 */
public class ItemFactory {
    ///could use some work
    ParseJson jsonParse;
    ArrayList<IItem> items;

    public ItemFactory() {
        jsonParse = new ParseJson("src/wwtbam/model/jsonRetrieve/choices.json");
        this.items=jsonParse.getItems();
    }

    public ArrayList<IItem> getItems() {
        return items;
    }

        

}
