package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    SubCloset in = new SubCloset(1);
    SubCloset out = new SubCloset(0);
    SubCloset shoe = new SubCloset(2);
    SubCloset pant = new SubCloset(4);
    SubCloset accs = new SubCloset(3);
    ArrayList<Outfit> fits = new ArrayList<Outfit>();
    Clothing cc = new Shoe("Red", "Nike", "Running", "Sunny", 8);
    Clothing ccc = new Innerwear("Red", "Adidas", "Running", "Sunny", 8);

    @Test
    void testReaderNonExistentFile() {
        Reader reader = new Reader("./data/noSuchFile.json");
        try {
            Closet clos = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        Reader reader = new Reader("./data/testWriterEmptyCloset.json");
        try {
            Closet clos = reader.read();
            assertEquals("name", clos.getName());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        Reader reader = new Reader("./data/testWriterGenCloset.json");
        try {
            Closet clos = reader.read();
            assertEquals("name", clos.getName());
            shoe.addClothing(cc);
            in.addClothing(ccc);
            Closet cl = new Closet("name", out, in, shoe, accs, pant, fits);
            assertEquals(cl.getInnerwear().showClothing(), clos.getInnerwear().showClothing());
            assertEquals("<1> hi: out, in, shoe, acc, and pants Rating: 6", clos.showOutfits());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}