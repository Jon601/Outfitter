package persistence;

import com.sun.corba.se.spi.ior.ObjectKey;
import model.Closet;
import model.Clothing;
import model.Outfit;
import model.SubCloset;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Reader {
    private String source;
    private SubCloset out = new SubCloset(1);
    private SubCloset in = new SubCloset(2);
    private SubCloset shoe = new SubCloset(3);
    private SubCloset acc = new SubCloset(4);
    private SubCloset pant = new SubCloset(5);

    // EFFECTS: constructs reader to read from source file
    public Reader(String source) {
        this.source = source;
    }

    // EFFECTS: reads closet from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Closet read() throws IOException {
        String data = readFile(source);
        JSONObject ob = new JSONObject(data);
        return parseCloset(ob);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder content = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> content.append(s));
        }

        return content.toString();
    }

    // EFFECTS: parses closet from JSON object and returns it
    private Closet parseCloset(JSONObject object) {
        String name = object.getString("name");
        Closet clos = new Closet(name, out, in, shoe, acc, pant, new ArrayList<Outfit>());
        addOut(clos, object);
        addIn(clos, object);
        addShoe(clos, object);
        addAcc(clos, object);
        addPant(clos, object);
        addFits(clos, object);
        return clos;
    }

    // MODIFIES: clos
    // EFFECTS: adds clothes from outerwear JSON array
    private void addOut(Closet clos, JSONObject object) {
        JSONArray outer = object.getJSONArray("Out");
        for (Object json : outer) {
            JSONObject next = (JSONObject) json;
            addClothes(clos, next);
        }
    }

    // MODIFIES: clos
    // EFFECTS: adds clothes from innerwear JSON array
    private void addIn(Closet clos, JSONObject object) {
        JSONArray inner = object.getJSONArray("In");
        for (Object json : inner) {
            JSONObject next = (JSONObject) json;
            addClothes(clos, next);
        }
    }

    // MODIFIES: clos
    // EFFECTS: adds clothes from shoe JSON array
    private void addShoe(Closet clos, JSONObject object) {
        JSONArray shoer = object.getJSONArray("Shoe");
        for (Object json : shoer) {
            JSONObject next = (JSONObject) json;
            addClothes(clos, next);
        }
    }

    // MODIFIES: clos
    // EFFECTS: adds clothes from accessory JSON array
    private void addAcc(Closet clos, JSONObject object) {
        JSONArray accer = object.getJSONArray("Acc");
        for (Object json : accer) {
            JSONObject next = (JSONObject) json;
            addClothes(clos, next);
        }
    }

    // MODIFIES: clos
    // EFFECTS: adds clothes from pant JSON array
    private void addPant(Closet clos, JSONObject object) {
        JSONArray panter = object.getJSONArray("Pant");
        for (Object json : panter) {
            JSONObject next = (JSONObject) json;
            addClothes(clos, next);
        }
    }

    // MODIFIES: clos
    // EFFECTS: parses outfits from JSON object and adds them to closet
    private void addFits(Closet clos, JSONObject jsonObject) {
        JSONArray jsonFits = jsonObject.getJSONArray("Fits");

        for (Object json : jsonFits) {
            JSONObject sub = (JSONObject) json;
            addFit(clos, sub);
        }
    }

    // MODIFIES: clos
    // EFFECTS: parses outfit from JSON object and adds them to closet
    private void addFit(Closet clos, JSONObject json) {
        String fit = json.getString("Name");
        String cont = json.getString("Contents");
        int rat = json.getInt("Rating");
        clos.addOutfit(new Outfit(fit, cont, rat));
    }

    // MODIFIES: clos
    // EFFECTS: parses clothing from JSON object and adds them to closet
    private void addClothes(Closet clos, JSONObject json) {
        int type = json.getInt("Type");
        String color = json.getString("Color");
        String desc = json.getString("Desc");
        String occ = json.getString("Occasion");
        String weather = json.getString("Weather");
        int rating = json.getInt("Rating");
        if (type == 0) {
            clos.addClothing("Outerwear", color, desc, occ, weather, rating);
        } else if (type == 1) {
            clos.addClothing("Innerwear", color, desc, occ, weather, rating);
        } else if (type == 2) {
            clos.addClothing("Shoe", color, desc, occ, weather, rating);
        } else if (type == 3) {
            clos.addClothing("Accessory", color, desc, occ, weather, rating);
        } else if (type == 4) {
            clos.addClothing("Pants", color, desc, occ, weather, rating);
        }
    }
}

