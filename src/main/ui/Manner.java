package ui;

import model.Closet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manner extends JPanel {

    private Closet closet;
    JLabel manLBL = new JLabel();
    JLabel nameLBL = new JLabel();
    JLabel outLBL = new JLabel();
    JLabel inLBL = new JLabel();
    JLabel shoeLBL = new JLabel();
    JLabel accLBL = new JLabel();
    JLabel pantLBL = new JLabel();
    JLabel ratingLBL = new JLabel();
    JTextField name = new JTextField();
    JTextField out = new JTextField();
    JTextField in = new JTextField();
    JTextField shoe = new JTextField();
    JTextField acc = new JTextField();
    JTextField pant = new JTextField();
    JTextField rating = new JTextField();
    JButton enter = new JButton();

    // Constructs a man panel
    // EFFECTS: Initializes panel and takes in closet data
    public Manner(Closet closet) {
        this.closet = closet;
        init();
    }

    // Initializes panel
    // MODIFIES: this
    // EFFECTS: Sets layout for panel and sets labels and buttons
    private void init() {
        manLBL.setFont(new Font("Lucida", 0, 25));
        manLBL.setText("Make Your Own Outfit!");
        enter.setText("Enter");
        nameLBL.setText("Name:     ");
        outLBL.setText("Outerwear:     ");
        inLBL.setText("Innerwear:    ");
        shoeLBL.setText("Shoes:     ");
        accLBL.setText("Accessories:     ");
        pantLBL.setText("Pants:     ");
        ratingLBL.setText("Rating:     ");

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                entering(evt);
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
                                        .addComponent(manLBL)
                                        .addComponent(nameLBL).addComponent(outLBL).addComponent(inLBL)
                                        .addComponent(shoeLBL).addComponent(accLBL).addComponent(pantLBL)
                                        .addComponent(ratingLBL))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(
                                                GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(name, GroupLayout.DEFAULT_SIZE, 126,
                                                Short.MAX_VALUE)
                                        .addComponent(out, GroupLayout.Alignment.LEADING)
                                        .addComponent(in, GroupLayout.Alignment.LEADING)
                                        .addComponent(shoe, GroupLayout.Alignment.LEADING)
                                        .addComponent(acc, GroupLayout.Alignment.LEADING)
                                        .addComponent(pant, GroupLayout.Alignment.LEADING)
                                        .addComponent(rating, GroupLayout.Alignment.LEADING)
                                        .addComponent(enter))

                        ));
    }

    // Sets vertical layout
    // MODIFIES: this
    // EFFECTS: Sets vertical layout for all labels, panels, and buttons
    private void vertLayout(GroupLayout layout) {
        layout.setVerticalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
                .addGap(30, 30, 30).addComponent(manLBL).addGroup(layout.createParallelGroup(
                        GroupLayout.Alignment.TRAILING).addComponent(name, GroupLayout.PREFERRED_SIZE,
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(nameLBL))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(outLBL)
                        .addComponent(out, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(inLBL)
                        .addComponent(in, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(shoe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE).addComponent(shoeLBL))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(acc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE).addComponent(accLBL))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(pantLBL).addComponent(pant, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(ratingLBL).addComponent(rating, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addComponent(enter)));
    }

    // Enters a manually made outfit
    // MODIFIES: closet
    // EFFECTS: Adds outfit based on text field entries
    private void entering(ActionEvent e) {
        try {
            int i = Integer.parseInt(rating.getText());
            closet.makeOutfit(name.getText(), out.getText(), in.getText(), shoe.getText(), acc.getText(),
                    pant.getText(), i);
            JOptionPane.showMessageDialog(null, "Outfit Entered!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a number for ratings!");
        }

    }
}
