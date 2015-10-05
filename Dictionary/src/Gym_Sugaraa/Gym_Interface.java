package Gym_Sugaraa;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Toolkit;

public interface Gym_Interface {
    
    
    Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
    final int screen_width = (int)resolution.getWidth();
    final int screen_height = (int)resolution.getHeight();
    
}
