package PopUpMenuExample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class TreeDemo  extends  JFrame{
    
    DefaultMutableTreeNode root;
    JTree tree;
    
    public TreeDemo(){
    
        super("Мод жишээ");
        setLayout(null);
        JPanel pan1 = new JPanel();
        //pan1.setBackground(Color.red);
        pan1.setBounds(0,0,300,200);
        
        JPanel pan2 = new JPanel(new FlowLayout());
        pan2.setBounds(0,200,300,100);
        
        root= new DefaultMutableTreeNode("Хичээл : sw01");
        DefaultMutableTreeNode lection = new DefaultMutableTreeNode("Лекц");
        DefaultMutableTreeNode sem = new DefaultMutableTreeNode("Семинар");
        DefaultMutableTreeNode grade = new DefaultMutableTreeNode("Дүн");
        DefaultMutableTreeNode yavts = new DefaultMutableTreeNode("Явц");
        DefaultMutableTreeNode shalgalt = new DefaultMutableTreeNode("Шалгалт");
        
        grade.add(yavts);
        grade.add(shalgalt);
        
        root.add(lection);
        root.add(sem);
        root.add(grade);
        tree = new JTree(root);
        
        
        
        tree.addTreeSelectionListener(new TreeSelectionListener() {

            @Override
            public void valueChanged(TreeSelectionEvent e) {
                
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
                
                if(node.isLeaf())
                    System.out.println("Навч сонгогдож байна." + node.toString());
                else
                    System.out.println("Зангилаа сонгогдож байна.");
            }
        });
        
        
        JButton add = new JButton("Нэмэх");
        add.setPreferredSize(new Dimension(100,50));
        add.addActionListener(ae->{
            
            DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
            DefaultMutableTreeNode bd = new DefaultMutableTreeNode("Бие даалт");
            model.insertNodeInto(bd, root, 0);
        });
        
        JButton add1 = new JButton("Нэм");
        add.setPreferredSize(new Dimension(100,50));
        add.addActionListener(ae->{
            
            TreePath currentPath = tree.getSelectionPath();
            if(currentPath !=null)
            {
                DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
                DefaultMutableTreeNode bd = new DefaultMutableTreeNode("Навчин дээрхи");
                model.insertNodeInto(bd, (DefaultMutableTreeNode)currentPath.getLastPathComponent(), 0);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Шинээр оруулах зангилааг сонгоно уу");
            }
        });
        
        JScrollPane s = new JScrollPane(tree);
        pan1.add(s);
        add(pan1);
        
        pan2.add(add);
        pan2.add(add1);
        add(pan2);
        
        setBounds(300, 300, 300, 300);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        
        new TreeDemo();
    }
}
