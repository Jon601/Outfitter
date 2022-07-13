package model;

import org.json.JSONObject;
import persistence.Wrote;

public class Clothing implements Wrote {

    private int type;
    private String color;
    private String desc;
    private String occasion;
    private String weather;
    private int rating;

    // EFFECTS: team has given owner, team name, and roster
    public Clothing() {
        this.type = 99;
        this.color = "";
        this.desc = "";
        this.occasion = "";
        this.weather = "";
        this.rating = 0;
    }

    // gives outerwear color
    //EFFECTS: returns this.color
    public String getColor() {
        return this.color;
    }

    // gives outerwear description
    //EFFECTS: returns this.desc
    public String getDesc() {
        return this.desc;
    }

    // gives outerwear occasion
    //EFFECTS: returns this.occasion
    public String getOccasion() {
        return this.occasion;
    }

    // gives what weather the outerwear is for
    //EFFECTS: returns this.desc
    public String getWeather() {
        return this.weather;
    }

    // sets outerwear color
    //EFFECTS: sets this.color to input
    public void setColor(String c) {
        this.color = c;
    }

    // sets outerwear description
    //EFFECTS: sets this.desc to input
    public void setDesc(String d) {
        this.desc = d;
    }

    // sets outerwear occasion
    //EFFECTS: sets this.occasion to input
    public void setOccasion(String o) {
        this.occasion = o;
    }

    // sets outerwear weather
    //EFFECTS: sets this.weather to input
    public void setWeather(String w) {
        this.weather = w;
    }

    // sets outerwear rating
    //EFFECTS: sets this.rating to input
    public void setRating(int r) {
        this.rating = r;
    }

    // sets clothing type
    //EFFECTS: sets this.type to input
    public void setType(int r) {
        this.type = r;
    }

    @Override
    // Writes all contents into Json
    // EFFECTS: returns clothing as a JSON object
    public JSONObject intoJson() {
        JSONObject json = new JSONObject();
        json.put("Type", type);
        json.put("Color", color);
        json.put("Desc", desc);
        json.put("Occasion", occasion);
        json.put("Weather", weather);
        json.put("Rating", rating);
        return json;
    }
}
