package persistence;

import model.Closet;
import model.Clothing;
import model.Outfit;
import model.SubCloset;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.ArrayList;

// Represents a writer that writes JSON representation of closet to file
public class Writer {
    private PrintWriter writer;
    private String dest;

    // EFFECTS: constructs writer to write to destination file
    public Writer(String destination) {
        this.dest = destination;
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(dest));
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of workroom to file
    public void write(Closet clos) {
        JSONObject json = clos.intoJson();
        saveToFile(json.toString());
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}