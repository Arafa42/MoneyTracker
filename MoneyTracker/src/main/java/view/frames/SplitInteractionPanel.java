package view.frames;

import javax.swing.*;
import java.awt.*;

public class SplitInteractionPanel extends JPanel {
    public SplitInteractionPanel(){
        JLabel split = new JLabel("Split");
        split.setFont(new Font("Arial", Font.PLAIN, 15));
        split.setSize(100, 20);
        split.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(split,BorderLayout.PAGE_START);

        JRadioButton even = new JRadioButton("even");
        even.setFont(new Font("Arial", Font.PLAIN, 15));
        even.setSelected(true);
        even.setSize(75, 20);
        even.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(even,BorderLayout.CENTER);


        JRadioButton uneven = new JRadioButton("uneven");
        uneven.setFont(new Font("Arial", Font.PLAIN, 15));
        uneven.setSelected(false);
        uneven.setSize(80, 20);
        uneven.setHorizontalAlignment(SwingConstants.LEFT);
        this.add(uneven,BorderLayout.CENTER);

        ButtonGroup gengp = new ButtonGroup();
        gengp.add(even);
        gengp.add(uneven);



    }
}
