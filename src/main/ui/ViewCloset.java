package ui;

import model.Closet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCloset extends JPanel {

    private Closet closet;
    JLabel viewLBL = new JLabel();
    JLabel viewOut = new JLabel();
    JLabel viewIn = new JLabel();
    JLabel viewShoe = new JLabel();
    JLabel viewAcc = new JLabel();
    JLabel viewPant = new JLabel();
    JLabel viewFit = new JLabel();
    JButton refresh = new JButton();

    public ViewCloset(Closet closet) {
        init();
        this.closet = closet;
    }

    private void init() {
        viewLBL.setFont(new Font("Lucida", 0, 25));
        viewLBL.setText("Your Closet Contents: ");
        viewOut.setText("Outerwear: ");
        viewIn.setText("Innerwear: ");
        viewShoe.setText("Shoes: ");
        viewAcc.setText("Accessories: ");
        viewPant.setText("Pants: ");
        viewFit.setText("Outfits: ");
        refresh.setText("Refresh");

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                refreshing(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        horzLayout(layout);
        vertLayout(layout);
    }

    private void horzLayout(GroupLayout layout) {
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(viewLBL)
                                        .addComponent(viewOut).addComponent(viewIn).addComponent(viewShoe)
                                        .addComponent(viewAcc).addComponent(viewPant).addComponent(viewFit)
                                        .addComponent(refresh))
                        ));
    }

    private void vertLayout(GroupLayout layout) {
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addContainerGap()
                                .addGap(30, 30, 30)
                                .addComponent(viewLBL)
                                .addGap(18, 18, 18)
                                .addComponent(viewOut)
                                .addGap(18, 18, 18)
                                .addComponent(viewIn)
                                .addGap(18, 18, 18)
                                .addComponent(viewShoe)
                                .addGap(18, 18, 18)
                                .addComponent(viewAcc)
                                .addGap(18, 18, 18)
                                .addComponent(viewPant)
                                .addGap(18, 18, 18)
                                .addComponent(viewFit)
                                .addGap(18, 18, 18)
                                .addComponent(refresh)));
    }

    private void refreshing(ActionEvent evt) {
        viewOut.setText("Outerwear:     " + this.closet.getOuterwear().showClothing());
        viewIn.setText("Innerwear:     " + this.closet.getInnerwear().showClothing());
        viewShoe.setText("Shoes:     " + this.closet.getShoes().showClothing());
        viewAcc.setText("Accessories:     " + this.closet.getAccessory().showClothing());
        viewPant.setText("Pants:     " + this.closet.getPants().showClothing());
        viewFit.setText("Outfits:     " + this.closet.showOutfits());
    }
}
