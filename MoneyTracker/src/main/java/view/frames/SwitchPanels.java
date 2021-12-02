package view.frames;

import view.ViewFrame;

import javax.swing.*;

public class SwitchPanels {
    ViewFrame f = new ViewFrame();

    public SwitchPanels(){

    }

    public void switchPanels(JPanel panel){
        /*switch (panel) {
            case 1:
                f.removeAll();
                f.add(registrationPanel);
                f.repaint();
                f.revalidate();
                break;
            case 2:
                f.removeAll();
                f.add(mainPanel);
                f.repaint();
                f.revalidate();
                break;
        }*/
        f.removeAll();
        f.add(panel);
        f.repaint();
        f.revalidate();
    }

}
