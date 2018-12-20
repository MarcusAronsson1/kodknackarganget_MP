package com.kodknackarganget.mp;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class readJSON {

    public void loadJSON(){

        Gson gson = new Gson();

        try (Reader reader = new FileReader("test.json")) {

            Project project = gson.fromJson(reader, Project.class); // Convert JSON to Java Object

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
