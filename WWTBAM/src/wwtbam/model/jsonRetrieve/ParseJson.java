/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wwtbam.model.jsonRetrieve;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.*;
import wwtbam.model.CorrectChoice;
import wwtbam.model.DifficultyFactory;
import wwtbam.model.FalseChoice;
import wwtbam.model.IChoice;
import wwtbam.model.IItem;
import wwtbam.model.Item;

/**
 *
 * @author lipat
 */
public class ParseJson implements IJsonParse, UseLocalFile {

    File file;
    ArrayList<IItem> items;
    String data;
    JSONObject jObject;

    DifficultyFactory difficultyFactory;

    public ParseJson(String dir) {
        difficultyFactory = new DifficultyFactory();
        items = new ArrayList<>();
        setupFile(dir);
        initializeItems();
    }

    public void initializeItems() {
        JSONArray jsona = jObject.getJSONArray("Questions");
        int index = jsona.length();
        for (int i = 0; i < index; i++) {
            JSONObject currObj = jsona.getJSONObject(i);
            String question = currObj.getString("Question");
            String difficulty = currObj.getString("Difficulty");
            ArrayList<IChoice> choices = new ArrayList<>();
            CorrectChoice answer = new CorrectChoice(currObj.getString("Answer"));

            JSONArray falseAnsArr = currObj.getJSONArray("False Answers");
            for (int j = 0; j < falseAnsArr.length(); j++) {
                choices.add(new FalseChoice(falseAnsArr.getString(j)));
            }
            choices.add(answer);
            Item tempItem = new Item(question);
            tempItem.setChoices(choices);
            tempItem.setDifficulty(difficultyFactory.getDifficulty(difficulty));
            items.add(tempItem);

        }

    }

    @Override
    public ArrayList<IItem> getItems() {
        return this.items;
    }

    BufferedReader bufferedReader;
    FileReader fileReader;

    @Override
    public void setupFile(String dir) {
        this.file = new File(dir);
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String currLine = "";
            String jsonContent = "";
            while ((currLine = bufferedReader.readLine()) != null) {
                jsonContent += currLine;
            }

            this.jObject = new JSONObject(jsonContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
