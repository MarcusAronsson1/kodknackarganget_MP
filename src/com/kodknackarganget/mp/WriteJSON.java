package com.kodknackarganget.mp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class WriteJSON {

    public void saveJSON(Project project){

        Gson gson = new GsonBuilder().setPrettyPrinting().create(); //Create JSON with pretty printing

        try (FileWriter writer = new FileWriter("DIT092.json")) {

            gson.toJson(project, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
