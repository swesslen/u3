package view;

import controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomBikeFrame extends JFrame implements ActionListener {
    private JPanel mainPanel;

    private Controller controller;

    public CustomBikeFrame(Controller controller) {
        mainPanel = new JPanel(new GridLayout(1, 1));
        setSize(600, 400);
        this.setContentPane(mainPanel);
        setupPanel();
        this.setTitle("Customize your own bike!");
        this.setVisible(true);
        this.setResizable(false);
        this.controller = controller;
    }

    public void setupPanel() {
        /*
           TODO: Skapa ny motorcykel här och spara den.
            */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
           TODO: Skapa ny motorcykel här och spara den.
            */
    }
}
