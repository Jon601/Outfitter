package model;

public class Accessory extends Clothing {

    // EFFECTS: team has given owner, team name, and roster
    public Accessory(String color, String desc, String occasion, String weather, int rating) {
        setType(0);
        setColor(color);
        setDesc(desc);
        setOccasion(occasion);
        setWeather(weather);
        setRating(rating);
    }
}
