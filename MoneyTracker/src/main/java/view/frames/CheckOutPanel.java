package view.frames;

import javax.swing.*;
import java.awt.*;

public class CheckOutPanel extends JPanel {

    protected CheckOutRightPanel checkOutRightPanel;
    private CheckOutLeftPanel checkOutLeftPanel;

    public CheckOutPanel(){
        checkOutRightPanel = new CheckOutRightPanel();
        checkOutLeftPanel = new CheckOutLeftPanel();

        this.add(checkOutLeftPanel);
        this.add(checkOutRightPanel);


        this.setLayout(new GridLayout(1,1));
        this.setVisible(true);
    }
}
