package org.chalmers.database;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DatabaseConnector {

    private JSONObject dbObj;
    private String path;
    JSONParser parser = new JSONParser();

    /**
     * Use when communicating with the JSON files (the database).
     * @param jsonUri the URI for the specified JSON file.
     */
    public DatabaseConnector(String jsonUri){
        path = jsonUri;
        try{
            dbObj = (JSONObject) parser.parse(new FileReader(path));
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getDbObj() {
        return new JSONObject(dbObj);
    }
    public String getDbPath() {return path;}
}
