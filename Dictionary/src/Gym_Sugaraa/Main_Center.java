package Gym_Sugaraa;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Main_Center extends JPanel{
    JTabbedPane tab;
    JPanel panel1,panel2,panel3;
    
    public Main_Center(){
    
        setLayout(new BorderLayout());
        
        tab = new JTabbedPane();
        panel1 = new JPanel(new BorderLayout());
        panel2 = new JPanel(new BorderLayout());
        panel3 = new JPanel();
        
        Center_Home ch = new Center_Home();
        panel1.add(ch, BorderLayout.CENTER);
        
        
        
        Register_Panel1 reg1 = new Register_Panel1();
        Register_Panel2 reg2 = new Register_Panel2();
        panel2.add(reg1, BorderLayout.WEST);
        panel2.add(reg2, BorderLayout.EAST);
        
        
        panel3.setBackground(Color.BLACK);
        
        
        tab.addTab("Эхлэл",panel1);
        tab.addTab("Бүртгэл",panel2);
        tab.addTab("Хэрэглэгч",panel3);
            
        add(tab);
                    
    }
}
