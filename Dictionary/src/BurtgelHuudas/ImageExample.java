package BurtgelHuudas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageExample extends JFrame{
    
    private ImageIcon image1;
    private JLabel label1;
    
    public ImageExample(){
    
        setLayout(new FlowLayout());
        
        JPanel j = new JPanel();
        image1 = new ImageIcon(getClass().getResource("gym.jpg"));
        
        label1 = new JLabel(image1);
        j.add(label1);
        add(j);
        
        
        pack();
        setVisible(true);
                
    }
    public static void main(String[] args) {
        new ImageExample();
    }
          
}
