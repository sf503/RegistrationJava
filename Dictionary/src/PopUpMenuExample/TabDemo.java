package PopUpMenuExample;
import java.awt.*;
import javax.swing.*;
 
public class TabDemo extends JFrame{
    JTabbedPane tab;
    JPanel pan1,pan2;
 
    public TabDemo() 
    {
        tab = new JTabbedPane();
        
        pan1 = new JPanel();
        pan1.setBackground(Color.red);
        pan2 = new JPanel();
        pan2.setBackground(Color.blue);
        
        JButton btn = new JButton("BUTTON");
        pan1.add(btn);
        
        tab.addTab("Tab with JButtons", null,pan1,"First pane");
        tab.addTab("Tab with JTextField", null,pan2,"First pane");
        add(tab,BorderLayout.CENTER);
        
        btn.addActionListener(ae->{
            tab.setSelectedIndex(1);
        });
        setSize(300,300);
        setVisible(true);
    }
 
    public static void main(String[] args) {
     
                TabDemo t = new TabDemo();
                t.setDefaultCloseOperation(2);
    }

}
