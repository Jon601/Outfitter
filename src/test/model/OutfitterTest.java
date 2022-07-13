package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class OutfitterTest {

    private Closet clos;
    SubCloset in = new SubCloset(1);
    SubCloset out = new SubCloset(0);
    SubCloset shoe = new SubCloset(2);
    SubCloset pant = new SubCloset(4);
    SubCloset accs = new SubCloset(3);
    ArrayList<Outfit> fits = new ArrayList<Outfit>();
    Clothing cc = new Shoe("Red", "Nike", "Running", "Sunny", 8);
    Clothing ccc = new Innerwear("Red", "Adidas", "Running", "Sunny", 8);
    Clothing c = new Outerwear("Red", "Reebok", "Running", "Sunny", 8);
    Clothing ca = new Accessory("Red", "Watch", "Running", "Sunny", 8);
    Clothing caa = new Pants("Red", "Supreme", "Running", "Sunny", 8);

    @BeforeEach
    void runBefore() {
        clos = new Closet("name", out, in, shoe, accs, pant, fits);
        clos.addClothing("Shoe", "Red", "Nike", "Running", "Sunny", 8);
        clos.addClothing("Innerwear", "Red", "Adidas", "Running", "Sunny", 8);
        clos.addClothing("Outerwear" , "Red", "Reebok", "Running", "Sunny", 8);
        clos.addClothing("Accessory", "Red", "Watch", "Running", "Sunny", 8);
        clos.addClothing("Pants", "Red", "Supreme", "Running", "Sunny", 8);
    }

    @Test
    void testAddClothingsub() {

        Clothing caca = new Shoe("Red", "Nike", "Walking", "Sunny", 8);
        shoe.addClothing(caca);
        ArrayList<Clothing> sho = new ArrayList<Clothing>();
        sho.add(this.cc);
        sho.add(caca);

        assertEquals(sho, shoe.getClothing());
    }

    @Test
    void testAddClothing() {

        Clothing caca = new Innerwear("White", "Tank Top", "Lifting", "Sunny", 3);
        Clothing acac = new Outerwear("White", "Windbreaker", "Biking", "Cloudy", 5);
        Clothing popo = new Accessory("Gold", "Bracelet", "Fashion", "Sunny", 8);
        Clothing poop = new Pants("White", "Cargo", "Strutting", "Sunny", 5);
        Clothing poo = new Shoe("Black", "Boot", "Strutting", "Rainy", 9);
        clos.addClothing("Innerwear", "White", "Tank Top", "Lifting", "Sunny", 3);
        clos.addClothing("Outerwear", "White", "Windbreaker", "Biking", "Cloudy", 5);
        clos.addClothing("Accessory", "Gold", "Bracelet", "Fashion", "Sunny", 8);
        clos.addClothing("Pants", "White", "Cargo", "Strutting", "Sunny", 5);
        clos.addClothing("Shoes", "Black", "Boot", "Strutting", "Rainy", 9);
        ArrayList<Clothing> sho = new ArrayList<Clothing>();
        ArrayList<Clothing> shoo = new ArrayList<Clothing>();
        ArrayList<Clothing> sh = new ArrayList<Clothing>();
        ArrayList<Clothing> shh = new ArrayList<Clothing>();
        ArrayList<Clothing> ssh = new ArrayList<Clothing>();
        sho.add(this.ccc);
        sho.add(caca);
        assertEquals(sho.get(1).getDesc(), clos.getInnerwear().getClothing().get(1).getDesc());
        shoo.add(this.c);
        shoo.add(acac);
        assertEquals(shoo.get(1).getDesc(), clos.getOuterwear().getClothing().get(1).getDesc());
        sh.add(this.ca);
        sh.add(popo);
        assertEquals(sh.get(1).getDesc(), clos.getAccessory().getClothing().get(1).getDesc());
        shh.add(this.caa);
        shh.add(poop);
        assertEquals(shh.get(1).getDesc(), clos.getPants().getClothing().get(1).getDesc());
        ssh.add(this.cc);
        ssh.add(poo);
        assertEquals(ssh.get(1).getDesc(), clos.getShoes().getClothing().get(1).getDesc());
    }

    @Test
    void testIsEmpty() {

        SubCloset s = new SubCloset(1);
        assertTrue(s.isEmpty());
        assertFalse(shoe.isEmpty());
    }

    @Test
    void testGenWeather() {

        String red = "Sunny";
        SubCloset s = new SubCloset(4);
        Clothing cc = new Shoe("Red", "Nike", "Running", red, 8);
        Clothing ccc = new Shoe("Red", "Adidas", "Running", red, 8);
        s.addClothing(cc);
        assertEquals("Nike", s.genWeather(red));
        assertEquals("", s.genColor("no"));
        s.addClothing(ccc);
        ArrayList<String> cloth = new ArrayList<String>();
        cloth.add(cc.getDesc());
        cloth.add(ccc.getDesc());
        assertTrue(cloth.contains(s.genWeather(red)));

    }

    @Test
    void testGenColor() {

        String red = "Red";
        SubCloset s = new SubCloset(4);
        Clothing cc = new Shoe("Red", "Nike", "Running", "Sunny", 8);
        Clothing ccc = new Shoe("Red", "Adidas", "Running", red, 8);
        s.addClothing(cc);
        assertEquals("Nike", s.genColor(red));
        assertEquals("", s.genColor("no"));
        s.addClothing(ccc);
        ArrayList<String> cloth = new ArrayList<String>();
        cloth.add(cc.getDesc());
        cloth.add(ccc.getDesc());
        assertTrue(cloth.contains(s.genColor(red)));
    }

    @Test
    void testGenOccasion() {

        String red = "Running";
        SubCloset s = new SubCloset(4);
        Clothing cc = new Shoe("Red", "Nike", "Running", "Sunny", 8);
        Clothing ccc = new Shoe("Red", "Adidas", "Running", red, 8);
        s.addClothing(cc);
        assertEquals("Nike", s.genOccasion("Running"));
        assertEquals("", s.genColor("no"));
        s.addClothing(ccc);
        ArrayList<String> cloth = new ArrayList<String>();
        cloth.add(cc.getDesc());
        cloth.add(ccc.getDesc());
        assertTrue(cloth.contains(s.genOccasion(red)));
        assertEquals("", s.genOccasion("no"));
        assertEquals("", s.genWeather("no"));
    }

    @Test
    void testMakeOutfit() {
        assertEquals("Your 1 outfit has coat, shirt, shoes, watch, and shorts",
                clos.makeOutfit("1", "coat", "shirt", "shoes", "watch",
                        "shorts", 7));
    }

    @Test
    void testGenColorOutfit() {
        assertEquals("Your 1 (Red) outfit has Reebok, Adidas, Nike, Watch, and Supreme",
                clos.genColorOutfit("1", "Red", 7));
    }

    @Test
    void testGenOccasionOutfit() {
        assertEquals("Your 67 (Running) outfit has Reebok, Adidas, Nike, Watch, and Supreme",
                clos.genOccasionOutfit("67", "Running", 9));
    }

    @Test
    void testGenWeatherOutfit() {
        assertEquals("Your 20 (Sunny) outfit has Reebok, Adidas, Nike, Watch, and Supreme",
                clos.genWeatherOutfit("20", "Sunny", 10));
    }

    @Test
    void testShowOutfit() {
        clos.makeOutfit("97", "Jacket", "Shirt", "Shoe", "Bracelet",
                "Shorts", 9);
        assertEquals("<> 97: Jacket, Shirt, Shoe, Bracelet, and Shorts Rating: 9",
                clos.showOutfits());
        clos.genWeatherOutfit("99", "Sunny", 8);
        assertEquals("<> 97: Jacket, Shirt, Shoe, Bracelet, and Shorts Rating: 9" +
                        "<> 99: Reebok, Adidas, Nike, Watch, and Supreme Rating: 8",
                clos.showOutfits());
    }

    @Test
    void testSetOutfit() {
        clos.makeOutfit("97", "Jacket", "Shirt", "Shoe", "Bracelet",
                "Shorts", 9);
        clos.setOutfit("97", "hi", "hi", 9);
        assertEquals("<> hi: hi Rating: 9", clos.showOutfits());
        clos.setOutfit("L", "k", "l", 9);
        assertEquals("<> hi: hi Rating: 9", clos.showOutfits());
    }

    @Test
    void testShowClothing() {
        assertEquals("Nike", shoe.showClothing());
        assertEquals("Adidas", in.showClothing());
    }
}