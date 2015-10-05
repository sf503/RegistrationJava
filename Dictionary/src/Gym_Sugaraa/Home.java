package Gym_Sugaraa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JPanel{
    
    Home(){
    
        setLayout(new BorderLayout());
        JPanel pan = new JPanel(new BorderLayout());
        pan.setPreferredSize(new Dimension(1200,450));
        
        ImageIcon image = new ImageIcon(getClass().getResource("gym.jpg"));
        JLabel label1 = new JLabel(image);
        pan.add(label1);
        
        add(pan);
    }
}