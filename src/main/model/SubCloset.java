package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Wrote;

import java.util.*;

public class SubCloset {

    private int type;
    private ArrayList<Clothing> closet;

    public SubCloset(int type) {
        this.type = type;
        this.closet = new ArrayList<>();
    }

    // Adds new piece of clothing to subcloset
    // MODIFIES: this
    // EFFECTS: adds given clothing to this.closet
    public void addClothing(Clothing c) {
        this.closet.add(c);
    }

    public void setType(int i) {
        this.type = i;
    }

    // filters the list of clothes to produce list with same color as given
    // EFFECTS: creates a filtered list of clothes with same color as given,
    // returns a random piece of clothing from filtered
    public String genColor(String s) {
        List<Clothing> filtered = new ArrayList<>();
        for (Clothing c : closet) {
            if (c.getColor().equals(s)) {
                filtered.add(c);
            }
        }
        if (!filtered.isEmpty()) {
            Clothing c = filtered.get((int) (Math.random() * (filtered.size())));
            return c.getDesc();
        } else {
            return "";
        }
    }

    // filters the list of clothes to produce list with same occasion as given
    // EFFECTS: creates a filtered list of clothes with same occasion as given,
    // returns a random piece of clothing from filtered
    public String genOccasion(String s) {
        List<Clothing> filtered = new ArrayList<>();
        for (Clothing c : closet) {
            if (c.getOccasion().equals(s)) {
                filtered.add(c);
            }
        }
        if (!filtered.isEmpty()) {
            Clothing c = filtered.get((int) (Math.random() * (filtered.size() - 1)));
            return c.getDesc();
        } else {
            return "";
        }
    }

    // filters the list of clothes to produce list with same weather as given
    // EFFECTS: creates a filtered list of clothes with same weather as given,
    // returns a random piece of clothing from filtered
    public String genWeather(String s) {
        List<Clothing> filtered = new ArrayList<>();
        for (Clothing c : closet) {
            if (c.getWeather().equals(s)) {
                filtered.add(c);
            }
        }
        if (!filtered.isEmpty()) {
            Clothing c = filtered.get((int) (Math.random() * (filtered.size() - 1)));
            return c.getDesc();
        } else {
            return "";
        }
    }

    // Tells whether the subcloset is empty or not
    // EFFECTS: returns true if closet.size is 0, false if else
    public boolean isEmpty() {
        return closet.size() == 0;
    }

    // Gives the contents of a subcloset
    // EFFECTS: returns list of clothes from subcloset
    public List<Clothing> getClothing() {
        return this.closet;
    }

    // Converts subcloset contents into a String
    // EFFECTS: returns list of clothes as String
    public String showClothing() {
        String all = "";
        for (Clothing clothing : closet) {
            all += (clothing.getDesc() + ", ");
        }
        return all;
    }
}
