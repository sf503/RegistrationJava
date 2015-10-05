package Gym_Sugaraa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class Main_South extends JPanel{
    
    public Main_South()
    {
        setLayout(new BorderLayout());
        
        JPanel pan1 = new JPanel();
        pan1.setPreferredSize(new Dimension(1200,20));
        pan1.setBackground(Color.red);
        
        add(pan1, BorderLayout.PAGE_START);
        
    }
}
