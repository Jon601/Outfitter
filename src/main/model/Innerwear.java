package model;

public class Innerwear extends Clothing {

    // EFFECTS: team has given owner, team name, and roster
    public Innerwear(String color, String desc, String occasion, String weather, int rating) {
        setType(1);
        setColor(color);
        setDesc(desc);
        setOccasion(occasion);
        setWeather(weather);
        setRating(rating);
    }
}
