package model;

public class Pants extends Clothing {

    // EFFECTS: team has given owner, team name, and roster
    public Pants(String color, String desc, String occasion, String weather, int rating) {
        setType(3);
        setColor(color);
        setDesc(desc);
        setOccasion(occasion);
        setWeather(weather);
        setRating(rating);
    }
}
