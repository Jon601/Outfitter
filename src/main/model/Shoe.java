package model;

public class Shoe extends Clothing {


    // EFFECTS: team has given owner, team name, and roster
    public Shoe(String color, String desc, String occasion, String weather, int rating) {
        setType(4);
        setColor(color);
        setDesc(desc);
        setOccasion(occasion);
        setWeather(weather);
        setRating(rating);
    }

}
