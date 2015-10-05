package Gym_Sugaraa;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Gym_Main extends JFrame implements Gym_Interface{
    
    
    public Gym_Main(){
    
        super("Бялдаржуулах төвийн бүртгэлийн систем");
        
        setLayout(new BorderLayout());
        
        
        Main_North obj1 = new Main_North();
        add(obj1, BorderLayout.NORTH);
        
        Main_Center obj2 = new Main_Center();
        add(obj2, BorderLayout.CENTER);
        
        
        Main_South obj3 = new Main_South();
        add(obj3, BorderLayout.SOUTH);
        
        setLocation((screen_width-1200)/2, (screen_height-600)/2);
        setSize(1200, 600);
        setVisible(true);
        setResizable(false);
        
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        MKiT_UITools._setSubstanceLookAndFeel();
        SwingUtilities.invokeLater(()->{
            
            Gym_Main main = new Gym_Main();
            
            main.setDefaultCloseOperation(2);
                    
        });
    }
          
}
