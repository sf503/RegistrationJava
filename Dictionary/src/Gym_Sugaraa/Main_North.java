package Gym_Sugaraa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Main_North extends JPanel{
    
    Main_North()
    {
        setLayout(new BorderLayout());
        
        JPanel pan1 = new JPanel();
        pan1.setPreferredSize(new Dimension(1200,50));
        pan1.setBackground(Color.red);
        
        add(pan1, BorderLayout.PAGE_START);
        
        
    }
}
