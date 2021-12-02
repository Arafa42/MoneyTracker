package view;



import view.frames.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewFrame extends JFrame {

    MainPanel mainPanel;



    public ViewFrame(){super("MoneyTracker");}

    public void initialize()
    {
        this.setSize(900, 500);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        GridLayout layout = new GridLayout();
        this.setLayout(layout);



        mainPanel = new MainPanel();

        this.add(mainPanel);
        this.setVisible(true);
    }

    public void switchPanels(){
        this.removeAll();
    }
}