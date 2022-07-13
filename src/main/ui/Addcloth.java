package ui;

import model.Closet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Addcloth extends JPanel {

    private Closet closet;
    JLabel jlabel1 = new JLabel();
    JLabel closetLBL = new JLabel();
    JLabel typeLBL = new JLabel();
    JLabel colorLBL = new JLabel();
    JLabel descL = new JLabel();
    JLabel occLBL = new JLabel();
    JLabel weatherLBL = new JLabel();
    JLabel ratingLBL = new JLabel();
    JTextField type = new JTextField();
    JTextField color = new JTextField();
    JTextField desc = new JTextField();
    JTextField occ = new JTextField();
    JTextField weather = new JTextField();
    JTextField rating = new JTextField();
    JButton addButton = new JButton();

    // Constructs an add clothing panel
    // EFFECTS: Initializes panel and takes in closet data
    public Addcloth(Closet clos) {
        initComponents();
        this.closet = clos;
    }

    // Initializes panel
    // MODIFIES: this
    // EFFECTS: Sets layout for panel and sets labels and buttons
    private void initComponents() {

        jlabel1.setText("Enter Clothing Information");
        closetLBL.setFont(new Font("Lucida", 0, 25));
        closetLBL.setText("Curate Your Closet!");
        typeLBL.setText("Type");
        colorLBL.setText("Color");
        descL.setText("Description/Name");
        occLBL.setText("Occasion");
        weatherLBL.setText("Weather");
        ratingLBL.setText("Rating");
        addButton.setText("Add");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

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
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(closetLBL)
                                        .addComponent(typeLBL).addComponent(colorLBL).addComponent(descL)
                                        .addComponent(occLBL).addComponent(weatherLBL).addComponent(ratingLBL))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(
                                                GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(type, GroupLayout.DEFAULT_SIZE, 126,
                                                Short.MAX_VALUE)
                                        .addComponent(color, GroupLayout.Alignment.LEADING)
                                        .addComponent(desc, GroupLayout.Alignment.LEADING)
                                        .addComponent(occ, GroupLayout.Alignment.LEADING)
                                        .addComponent(weather, GroupLayout.Alignment.LEADING)
                                        .addComponent(rating, GroupLayout.Alignment.LEADING)
                                        .addComponent(addButton))

                        ));
    }

    // Sets vertical layout
    // MODIFIES: this
    // EFFECTS: Sets vertical layout for all labels, panels, and buttons
    private void vertLayout(GroupLayout layout) {
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addContainerGap().addGap(30, 30, 30)
                                .addComponent(closetLBL).addGroup(layout.createParallelGroup(
                                        GroupLayout.Alignment.TRAILING).addComponent(type, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(typeLBL))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(colorLBL)
                                        .addComponent(color, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(descL)
                                        .addComponent(desc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(occ, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE).addComponent(occLBL))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(weather, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE).addComponent(weatherLBL))
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(ratingLBL).addComponent(rating, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addComponent(addButton)));
    }

    // Sets button functionality
    // MODIFIES: closet
    // EFFECTS: Allows button to add clothing from text fields
    private void addActionPerformed(ActionEvent evt) {
        try {
            int i = Integer.parseInt(rating.getText());
            closet.addClothing(type.getText(), color.getText(), desc.getText(), occ.getText(), weather.getText(),
                    i);
            JOptionPane.showMessageDialog(null, "Clothing Added!");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number for ratings!");
        }
    }
}
