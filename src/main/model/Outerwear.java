package model;

public class Outerwear extends Clothing {

    // EFFECTS: team has given owner, team name, and roster
    public Outerwear(String color, String desc, String occasion, String weather, int rating) {
        setType(2);
        setColor(color);
        setDesc(desc);
        setOccasion(occasion);
        setWeather(weather);
        setRating(rating);
    }
}
