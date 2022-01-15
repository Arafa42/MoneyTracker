package view.frames;
import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public static MainRightPanel mainRightPanel;
    private MainLeftPanel mainLeftPanel;

    public MainPanel(){
        mainRightPanel = new MainRightPanel();
        mainLeftPanel = new MainLeftPanel();
        this.add(mainLeftPanel);
        this.add(mainRightPanel);
        this.setLayout(new GridLayout(1,1));
        this.setVisible(true);
    }
}