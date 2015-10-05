
package Gym_Sugaraa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
public class User_Panel1 extends JPanel{
    
    User_Panel1(){
    
        setLayout(new BorderLayout());
        JPanel pan1 = new JPanel(new BorderLayout());
        pan1.setPreferredSize(new Dimension(400,450));
        pan1.setBackground(Color.green);
        
        add(pan1);
    }
}
