/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym_Sugaraa;


import javax.swing.JFrame;
import javax.swing.UIManager;

public class MKiT_UITools {
    
    public static void _setSubstanceLookAndFeel()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        try 
        {
            //UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceCremeCoffeeLookAndFeel");
            //UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceNebulaBrickWallLookAndFeel");
            //UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceNebulaLookAndFeel");
            //UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceRavenGraphiteLookAndFeel");
            //UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlueSteelLookAndFeel");
            //UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceSaharaLookAndFeel");
            //UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel");
            //UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceLookAndFeel");
            UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel");
            
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
}

