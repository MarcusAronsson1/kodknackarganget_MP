package com.kodknackarganget.mp;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


public class readJSON {

    public Project loadJSON(){

        Gson gson = new Gson();

        try (Reader reader = new FileReader("DIT092.json")) {

            Project project = gson.fromJson(reader, Project.class); // Convert JSON to Java Object
            return project;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
