package ui;

import model.Closet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditOut extends JPanel {

    private Closet closet;
    JLabel viewLBL = new JLabel();
    JLabel oldLBL = new JLabel();
    JTextField old = new JTextField();
    JLabel nameLBL = new JLabel();
    JTextField name = new JTextField();
    JLabel contLBL = new JLabel();
    JTextField cont = new JTextField();
    JLabel ratLBL = new JLabel();
    JTextField rat = new JTextField();
    JLabel outs = new JLabel();
    JButton edit = new JButton();
    JButton ref = new JButton();

    // Constructs an edit outfit panel
    // EFFECTS: Initializes panel and takes in closet data
    public EditOut(Closet closet) {
        this.closet = closet;
        init();
    }

    // Initializes panel
    // MODIFIES: this
    // EFFECTS: Sets layout for panel and sets labels and buttons
    private void init() {
        viewLBL.setFont(new Font("Lucida", 0, 25));
        viewLBL.setText("Edit Outfits");
        oldLBL.setText("Outfit to Change");
        nameLBL.setText("Name");
        outs.setText("Current Outfits:     ");
        edit.setText("Edit Outfit");
        ref.setText("Refresh");
        contLBL.setText("Contents");
        ratLBL.setText("Rating");

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
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(viewLBL).addComponent(outs).addComponent(oldLBL)
                                        .addGap(18, 18, 18)
                                        .addComponent(old, GroupLayout.Alignment.LEADING, 100,
                                                GroupLayout.DEFAULT_SIZE, 80).addComponent(ref))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nameLBL, GroupLayout.Alignment.LEADING)
                                        .addComponent(name, GroupLayout.Alignment.LEADING, 80,
                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(edit))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(contLBL, GroupLayout.Alignment.LEADING)
                                        .addComponent(cont, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ratLBL, GroupLayout.Alignment.LEADING)
                                        .addComponent(rat, GroupLayout.DEFAULT_SIZE, 80, 80))));
    }

    // Sets vertical layout
    // MODIFIES: this
    // EFFECTS: Sets vertical layout for all labels, panels, and buttons
    private void vertLayout(GroupLayout layout) {
        layout.setVerticalGroup(layout.createParallelGroup(
                GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
                .addGap(30, 30, 30).addComponent(viewLBL).addGap(18, 18, 18)
                .addComponent(outs).addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(oldLBL).addComponent(nameLBL).addComponent(contLBL).addComponent(ratLBL))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(old, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(name, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(cont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addComponent(rat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(ref).addComponent(edit))));
    }

    // Gives button functionality
    // MODIFIES: this
    // EFFECTS: Sets buttons to methods
    private void makeAction() {
        ref.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                refr(evt);
            }
        });

        ref.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ed(evt);
            }
        });
    }

    // Displays current outfits
    // MODIFIES: this
    // EFFECTS: Sets outs label to display all outfits
    private void refr(ActionEvent evt) {
        outs.setText("Current Outfits:     " + this.closet.getFits());
    }

    // Edit outfit
    // MODIFIES: closet
    // EFFECTS: Sets given outfit to new text entries
    private void ed(ActionEvent evt) {
        try {
            int i = Integer.parseInt(rat.getText());
            this.closet.setOutfit(old.getText(), name.getText(), cont.getText(), i);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter a number for ratings!");
        }

    }
}
