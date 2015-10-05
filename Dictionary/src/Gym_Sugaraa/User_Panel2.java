package Gym_Sugaraa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class User_Panel2 extends JPanel{
    
    User_Panel2(){
    
        setLayout(new BorderLayout());
        JPanel pan1 = new JPanel(new BorderLayout());
        pan1.setPreferredSize(new Dimension(800,450));
        pan1.setBackground(Color.BLACK);
        
        add(pan1);
    }
}
