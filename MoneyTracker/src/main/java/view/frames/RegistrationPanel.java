package view.frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPanel extends JPanel {

    SwitchPanels switchPanels = new SwitchPanels();
    JButton backButton;
    public RegistrationPanel(){

        JLabel label = new JLabel("Registration");
        backButton = new JButton("Back");
        this.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainPanel mainpanel =  new MainPanel();
                switchPanels.switchPanels(mainpanel);
            }
        });
        this.add(label);
        this.add(backButton);
    }
}
