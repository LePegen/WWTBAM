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
import org.json.*;

/**
 *
 * @author lipat
 */
public class ItemFactory {

    File file;
    JSONObject jObject;
    ArrayList<JSONObject> items;
    int index=0;
    
    //redo code
    public ItemFactory() {
        //breaks SRP. suggestion: move to other class
        this.file = new File("C:\\Users\\lipat\\Documents\\School\\WWTBAM\\WWTBAM\\WWTBAM\\src\\wwtbam\\model\\choices.json");
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String jsonContent = "";
            String tempString = "";
            while (!"".equals(tempString = bufferedReader.readLine())) {
                jsonContent += tempString;
            }
       
            this.jObject = new JSONObject(jsonContent);
         
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        items = new ArrayList<>();
        addItems();
    }

    public void addItems() {
        
        JSONObject tempObject;
        int i = 0;
        for (int j = 0; j < jObject.getJSONArray("Questions").length(); j++) {
            tempObject = jObject.getJSONArray("Questions").getJSONObject(i);
            items.add(tempObject);
            
        }
    }
    
    public Item getItem(){
        String question=items.get(index).getString("Question");
        return new Item(question);
    
    }

    public static void main(String[] args) {
        ItemFactory itemFactory=new ItemFactory();
       
               
        System.out.println(itemFactory.getItem().getQuestion());
    }

}
