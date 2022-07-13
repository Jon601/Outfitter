package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WriterTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.


    SubCloset in = new SubCloset(1);
    SubCloset out = new SubCloset(0);
    SubCloset shoe = new SubCloset(2);
    SubCloset pant = new SubCloset(4);
    SubCloset accs = new SubCloset(3);
    ArrayList<Outfit> fits = new ArrayList<Outfit>();
    Clothing cc = new Shoe("Red", "Nike", "Running", "Sunny", 8);
    Clothing ccc = new Innerwear("Red", "Adidas", "Running", "Sunny", 8);

    @Test
    void testWriterInvalidFile() {
        try {
            Closet clos = new Closet("name", out, in, shoe, accs, pant, fits);
            Writer writer = new Writer("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Closet clos = new Closet("name", out, in, shoe, accs, pant, fits);
            Writer writer = new Writer("./data/testWriterEmptyCloset.json");
            writer.open();
            writer.write(clos);
            writer.close();

            Reader reader = new Reader("./data/testWriterEmptyCloset.json");
            clos = reader.read();
            assertEquals("name", clos.getName());
            assertEquals(0, clos.getInnerwear().getClothing().size());
            assertEquals(0, clos.getOuterwear().getClothing().size());
            assertEquals(0, clos.getShoes().getClothing().size());
            assertEquals(0, clos.getAccessory().getClothing().size());
            assertEquals(0, clos.getPants().getClothing().size());
            assertEquals(0, clos.getFits().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Closet clos = new Closet("name", out, in, shoe, accs, pant, fits);
            shoe.addClothing(cc);
            in.addClothing(ccc);
            clos.makeOutfit("hi", "out", "in", "shoe", "acc", "pants", 6);
            Writer writer = new Writer("./data/testWriterGenCloset.json");
            writer.open();
            writer.write(clos);
            writer.close();

            Reader reader = new Reader("./data/testWriterGenCloset.json");
            clos = reader.read();
            assertEquals("name", clos.getName());
            List<Outfit> outs = clos.getFits();
            assertEquals(1, outs.size());
            assertEquals(clos.getInnerwear().getClothing().get(0).getDesc(), "Adidas");

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}