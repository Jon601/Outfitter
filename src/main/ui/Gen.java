package ui;

import model.Closet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gen extends JPanel {

    private Closet closet;
    JLabel genLBL = new JLabel();
    JButton color = new JButton();
    JButton weather = new JButton();
    JButton occ = new JButton();
    JLabel out = new JLabel();
    JLabel nameLBL = new JLabel();
    JLabel descLBL = new JLabel();
    JLabel ratingLBL = new JLabel();
    JTextField name = new JTextField();
    JTextField desc = new JTextField();
    JTextField rating = new JTextField();

    // Constructs a gen panel
    // EFFECTS: Initializes panel and takes in closet data
    public Gen(Closet closet) {
        this.closet = closet;
        init();
    }

    // Initializes panel
    // MODIFIES: this
    // EFFECTS: Sets layout for panel and sets labels and buttons
    private void init() {
        genLBL.setFont(new Font("Lucida", 0, 25));
        genLBL.setText("Generate by Color, Occasion, or Weather");
        color.setText("Color");
        weather.setText("Weather");
        occ.setText("Occasion");
        nameLBL.setText("Name");
        descLBL.setText("Color/Occasion/Weather");
        ratingLBL.setText("Rating");
        out.setText("Your New Outfit:    ");

        makeAction();

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        horzLayout(layout);
        vertLayout(layout);
    }

    // Sets horizontal layout
    // MODIFIES: this
    // EFFECTS: Sets horizontal layout for all labels, panels, and buttons
    private void horzLayout(GroupLayout layout) {
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(genLBL)
                        .addGroup(layout.createSequentialGroup().addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(nameLBL).addComponent(name, GroupLayout.DEFAULT_SIZE, 126,
                                                150).addComponent(color))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING, false)
                                        .addComponent(descLBL, GroupLayout.Alignment.LEADING)
                                        .addComponent(desc, GroupLayout.Alignment.LEADING)
                                        .addComponent(weather, GroupLayout.Alignment.LEADING))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ratingLBL, GroupLayout.Alignment.LEADING)
                                        .addComponent(rating, GroupLayout.Alignment.LEADING)
                                        .addComponent(occ, GroupLayout.Alignment.LEADING)))
                        .addComponent(out));
    }

    // Sets vertical layout
    // MODIFIES: this
    // EFFECTS: Sets vertical layout for all labels, panels, and buttons
    private void vertLayout(GroupLayout layout) {
        layout.setVerticalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
                .addGap(30, 30, 30)
                .addComponent(genLBL)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(nameLBL).addComponent(descLBL).addComponent(ratingLBL))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(desc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(rating, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(color)
                        .addComponent(weather)
                        .addComponent(occ))
                .addGap(15, 15, 15)
                .addComponent(out)));
    }

    // Gives button functionality
    // MODIFIES: this
    // EFFECTS: Sets buttons to methods
    private void makeAction() {
        color.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                colorGen(evt);
            }
        });

        weather.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                weatherGen(evt);
            }
        });

        occ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                occGen(evt);
            }
        });
    }

    // Generates outfit by color
    // MODIFIES: this, closet
    // EFFECTS: Generates color outfit and displays it, displays message if successful
    private void colorGen(ActionEvent evt) {
        try {
            int i = Integer.parseInt(rating.getText());
            out.setText(this.closet.genColorOutfit(name.getText(), desc.getText(), i));
            JOptionPane.showMessageDialog(null, "An Outfit Generated by Color!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number for ratings!");
        }
    }

    // Generates outfit by weather
    // MODIFIES: this, closet
    // EFFECTS: Generates weather outfit and displays it, displays message if successful
    private void weatherGen(ActionEvent evt) {
        try {
            int i = Integer.parseInt(rating.getText());
            out.setText(this.closet.genWeatherOutfit(name.getText(), desc.getText(), i));
            JOptionPane.showMessageDialog(null, "An Outfit Generated by Weather!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number for ratings!");
        }
    }

    // Generates outfit by occasion
    // MODIFIES: this, closet
    // EFFECTS: Generates occasion outfit and displays it, displays message if successful
    private void occGen(ActionEvent evt) {
        try {
            int i = Integer.parseInt(rating.getText());
            out.setText(this.closet.genOccasionOutfit(name.getText(), desc.getText(), i));
            JOptionPane.showMessageDialog(null, "An Outfit Generated by Occasion!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number for ratings!");
        }
    }
}
