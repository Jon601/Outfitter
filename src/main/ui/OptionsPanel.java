package ui;

import model.Closet;
import model.Event;
import persistence.Reader;
import persistence.Writer;
import model.EventLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class OptionsPanel extends JFrame {

    private Closet closet;
    JLabel title = new JLabel();
    JButton add = new JButton();
    JButton view = new JButton();
    JButton man = new JButton();
    JButton gen = new JButton();
    JButton viewOut = new JButton();
    JButton save = new JButton();
    JButton load = new JButton();
    JButton quit = new JButton();
    JPanel buttonJPanel = new JPanel();
    JPanel viewJPanel = new JPanel();
    JSplitPane splitJPanel = new JSplitPane();
    private static final String STORE = "./data/closet.json";

    // Constructs a gen panel
    // EFFECTS: Initializes panel and takes in closet data
    public OptionsPanel(Closet closet) {
        this.closet = closet;
        init();
    }

    // Initializes panel
    // MODIFIES: this
    // EFFECTS: Sets layout for panel and sets labels and buttons
    public void init() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new Font("Lucida", 0, 35));
        title.setText("Outfitter");
        add.setText("Add Clothing");
        view.setText("View Closet Contents");
        man.setText("Make an Outfit");
        gen.setText("Generate an Outfit");
        viewOut.setText("See Outfits");
        save.setText("Save");
        load.setText("Load");
        quit.setText("Quit");
        GroupLayout buttonJPanelLayout = new GroupLayout(buttonJPanel);
        buttonJPanel.setLayout(buttonJPanelLayout);
        horzLayout(buttonJPanelLayout);
        vertLayout(buttonJPanelLayout);
        splitJPanel.setLeftComponent(buttonJPanel);

        makeAction();

        GroupLayout viewJPanelLayout = new GroupLayout(viewJPanel);
        viewJPanel.setLayout(viewJPanelLayout);
        layout1(viewJPanelLayout);
        splitJPanel.setRightComponent(viewJPanel);
        bruh();
    }

    // Packs panel
    // MODIFIES: this
    // EFFECTS: packs all components and adds them
    private void bruh() {
        getContentPane().add(splitJPanel, BorderLayout.CENTER);
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
                                        .addComponent(title)
                                        .addComponent(add)
                                        .addComponent(view)
                                        .addComponent(man)
                                        .addComponent(gen)
                                        .addComponent(viewOut)
                                        .addComponent(save)
                                        .addComponent(load)
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
                                .addComponent(title)
                                .addGap(21, 21, 21)
                                .addComponent(add)
                                .addGap(18, 18, 18)
                                .addComponent(view)
                                .addGap(18, 18, 18)
                                .addComponent(man)
                                .addGap(18, 18, 18)
                                .addComponent(gen)
                                .addGap(18, 18, 18)
                                .addComponent(viewOut)
                                .addGap(18, 18, 18)
                                .addComponent(save)
                                .addGap(18, 18, 18)
                                .addComponent(load)
                                .addGap(18, 18, 18)
                                .addComponent(quit)
                                .addContainerGap(100, Short.MAX_VALUE)));
    }

    // Sets layout
    // MODIFIES: this
    // EFFECTS: Sets layout for all labels, panels, and buttons
    private void layout1(GroupLayout viewJPanelLayout) {
        viewJPanelLayout.setHorizontalGroup(
                viewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 581, Short.MAX_VALUE)
        );
        viewJPanelLayout.setVerticalGroup(
                viewJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 454, Short.MAX_VALUE)
        );
    }

    private void printLog() {
        for (Iterator<Event> it = EventLog.getInstance().iterator(); it.hasNext(); ) {
            Event event = it.next();
            System.out.println(event.getDate() + " | " + event.getDescription());
        }
    }

    // Gives button functionality
    // MODIFIES: this
    // EFFECTS: Sets buttons to methods
    private void makeAction() {
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                createAdd(evt);
            }
        });

        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printLog();
                System.exit(0);
            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createView(e);
            }
        });

        makeAction1();
    }

    // Gives button functionality
    // MODIFIES: this
    // EFFECTS: Sets buttons to methods
    private void makeAction1() {
        man.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manner(e);
            }
        });

        gen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                genner(e);
            }
        });

        viewOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewer(e);
            }
        });

        makeAction2();
    }

    // Gives button functionality
    // MODIFIES: this
    // EFFECTS: Sets buttons to methods
    private void makeAction2() {
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saver(e);
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loader(e);
            }
        });
    }

    // Displays add clothing panel
    // MODIFIES: this
    // EFFECTS: Sets right component to add clothing panel
    private void createAdd(ActionEvent evt) {
        Addcloth create = new Addcloth(closet);
        splitJPanel.setRightComponent(create);
    }

    // Displays view closet panel
    // MODIFIES: this
    // EFFECTS: Sets right component to view closet panel
    private void createView(ActionEvent evt) {
        ViewCloset create = new ViewCloset(closet);
        splitJPanel.setRightComponent(create);
    }

    // Displays man panel
    // MODIFIES: this
    // EFFECTS: Sets right component to man panel
    private void manner(ActionEvent evt) {
        Manner create = new Manner(closet);
        splitJPanel.setRightComponent(create);
    }

    // Displays gen panel
    // MODIFIES: this
    // EFFECTS: Sets right component to gen panel
    private void genner(ActionEvent evt) {
        Gen create = new Gen(closet);
        splitJPanel.setRightComponent(create);
    }

    // Displays edit outfit panel
    // MODIFIES: this
    // EFFECTS: Sets right component to edit outfit panel
    private void viewer(ActionEvent evt) {
        EditOut create = new EditOut(closet);
        splitJPanel.setRightComponent(create);
    }

    // Saves closet data
    // EFFECTS: Writes all content to Json object, displays message if successful or fails
    private void saver(ActionEvent evt) {
        Writer wr = new Writer(STORE);
        try {
            wr.open();
            wr.write(closet);
            wr.close();
            JOptionPane.showMessageDialog(null, "Data Saved!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Unable to write to file " + STORE);
        }
    }

    // Loads closet data
    // EFFECTS: Reads Json object and loads it, displays message if successful or fails
    private void loader(ActionEvent evt) {
        Reader wr = new Reader(STORE);
        try {
            closet = wr.read();
            JOptionPane.showMessageDialog(null, "Data Loaded!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unable to read to file " + STORE);
        }
    }
}
