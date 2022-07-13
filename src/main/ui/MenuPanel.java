package ui;

import model.Closet;
import model.EventLog;
import model.Outfit;
import model.SubCloset;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuPanel extends JFrame {

    private Closet closet;
    private String name = "name";
    private SubCloset out = new SubCloset(1);
    private SubCloset in = new SubCloset(2);
    private SubCloset shoe = new SubCloset(3);
    private SubCloset acc = new SubCloset(4);
    private SubCloset pant = new SubCloset(5);
    private List<Outfit> fits = new ArrayList<>();
    JPanel buttonJPanel = new JPanel();
    JLabel title = new JLabel();
    JButton start = new JButton();
    JButton quit = new JButton();
    Image myPicture = ImageIO.read(new File("data/closet.png"));
    JLabel picLabel = new JLabel(new ImageIcon(myPicture));

    // Constructs a gen panel
    // EFFECTS: Initializes panel and takes in closet data
    public MenuPanel() throws IOException {
        initial();
        this.closet = new Closet(name, out, in, shoe, acc, pant, fits);

    }

    // Initializes panel
    // MODIFIES: this
    // EFFECTS: Sets layout for panel and sets labels and buttons
    public void initial() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        start.setText("Start!");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                createOptions(evt);
            }
        });

        quit.setText("Quit");
        quit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(EventLog.getInstance().toString());
                System.exit(0);
            }
        });

        title.setFont(new Font("Lucida", 0, 25));
        title.setText("Welcome to Outfitter!");

        GroupLayout viewJPanelLayout = new GroupLayout(buttonJPanel);
        buttonJPanel.setLayout(viewJPanelLayout);
        horzLayout(viewJPanelLayout);
        vertLayout(viewJPanelLayout);

        getContentPane().add(buttonJPanel, BorderLayout.CENTER);
        pack();
    }

    // Sets horizontal layout
    // MODIFIES: this
    // EFFECTS: Sets horizontal layout for all labels, panels, and buttons
    private void horzLayout(GroupLayout l) {
        l.setHorizontalGroup(
                l.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(l.createSequentialGroup()
                                .addContainerGap(50, Short.MAX_VALUE)
                                .addGroup(l.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(picLabel)
                                        .addComponent(title)
                                        .addComponent(start)
                                        .addComponent(quit))
                                .addContainerGap(50, Short.MAX_VALUE)));
    }

    // Sets vertical layout
    // MODIFIES: this
    // EFFECTS: Sets vertical layout for all labels, panels, and buttons
    private void vertLayout(GroupLayout l) {
        l.setVerticalGroup(
                l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addGroup(l.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(picLabel)
                                .addGap(18, 18, 18)
                                .addComponent(title)
                                .addGap(21, 21, 21)
                                .addComponent(start)
                                .addGap(18, 18, 18)
                                .addComponent(quit)
                                .addContainerGap(100, Short.MAX_VALUE)));
    }

    // Opens option panel
    // MODIFIES: this
    // EFFECTS: Makes this frame invisible and creates a new option panel frame
    private void createOptions(ActionEvent evt) {
        OptionsPanel create = new OptionsPanel(closet);
        this.setVisible(false);
        create.setVisible(true);
    }

}
