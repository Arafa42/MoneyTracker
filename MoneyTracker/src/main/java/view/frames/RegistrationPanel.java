package view.frames;
import javax.swing.*;
import java.awt.*;

public class RegistrationPanel extends JPanel {
    private RegistrationLeftPanel registrationLeftPanel;
    public static RegistrationRightPanel registrationRightPanel;

    public RegistrationPanel(){
        registrationLeftPanel = new RegistrationLeftPanel();
        registrationRightPanel = new RegistrationRightPanel();
        this.add(registrationLeftPanel);
        this.add(registrationRightPanel);
        this.setLayout(new GridLayout(1,1));
        this.setVisible(true);
    }

}
