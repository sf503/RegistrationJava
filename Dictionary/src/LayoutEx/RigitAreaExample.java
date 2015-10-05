package LayoutEx;

import java.awt.Dimension;

import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


public class RigitAreaExample extends JFrame {

    public RigitAreaExample() {

        initUI();
    }

    public final void initUI() {

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBorder(new EmptyBorder(new Insets(40, 60, 40, 60)));

        panel.add(new JButton("Button"));
        panel.add(Box.createRigidArea(new Dimension(10, 5)));
        panel.add(new JButton("Button"));
        panel.add(Box.createRigidArea(new Dimension(10, 5)));
        panel.add(new JButton("Button"));
        panel.add(Box.createRigidArea(new Dimension(1000, 5)));
        panel.add(new JButton("Button"));

        add(panel);

        pack();

        setTitle("RigidArea");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                RigitAreaExample ex = new RigitAreaExample();
                ex.setVisible(true);
            }
        });
    }
}