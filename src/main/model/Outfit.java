package model;

import org.json.JSONObject;
import persistence.Wrote;

public class Outfit implements Wrote {

    private String name;
    private String contents;
    private int rating;

    // EFFECTS: team has given owner, team name, and roster
    public Outfit(String name, String contents, int rating) {
        this.name = name;
        this.contents = contents;
        this.rating = rating;
    }

    // gives name
    //EFFECTS: returns this.name
    public String getName() {
        return this.name;
    }

    // gives outfit contents
    //EFFECTS: returns this.contents
    public String getContents() {
        return this.contents;
    }

    // gives rating
    //EFFECTS: returns this.rating
    public int getRating() {
        return this.rating;
    }

    @Override
    // Writes all contents into Json
    // EFFECTS: returns outfit as a JSON object
    public JSONObject intoJson() {
        JSONObject json = new JSONObject();
        json.put("Name", name);
        json.put("Contents", contents);
        json.put("Rating", rating);
        return json;
    }
}
