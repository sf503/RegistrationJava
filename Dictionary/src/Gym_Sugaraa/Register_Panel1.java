package Gym_Sugaraa;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Register_Panel1 extends JPanel{
    
    int dugaar;
    JPanel cards, card1, card2;
    Register_Panel1(){
    
        setLayout(new BorderLayout());
        
        JPanel btnPan = new JPanel(new FlowLayout());
        JPanel cardPan = new JPanel(new BorderLayout());
        
        btnPan.setPreferredSize(new Dimension(400,50));
        cardPan.setPreferredSize(new Dimension(400,410));
        
        JButton btnAdd = new JButton("Бүртгэл нэмэх");
        JButton btnEdit = new JButton("Бүртгэл засах");
        
        cards = new JPanel(new CardLayout());
        
        
        add(btnPan, BorderLayout.NORTH);
                btnPan.add(btnAdd);
                btnPan.add(btnEdit);
        add(cardPan, BorderLayout.CENTER);
                
                cardPan.add(cards, BorderLayout.CENTER);
                CardLayout c1 = (CardLayout)(cards.getLayout());
                
                btnAdd.addActionListener(ae->{
                    btnAdd();
                    c1.first(cards);
                });
                
                
                btnEdit.addActionListener(ae->{
                    if(Register_Panel2.table.getSelectedRow()!=-1)
                    {
                        String id = Register_Panel2.table.getValueAt(Register_Panel2.table.getSelectedRow(), 0).toString();
                        dugaar = Integer.parseInt(id);

                        btnEdit();
                        c1.last(cards);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Та засах мөрөө сонгоно уу...");
                    }
                    
                });
        btnAdd(); 
    }
    public void btnAdd()
    {
        Panel1_Add obj1 = new Panel1_Add();
        card1 = new JPanel(new BorderLayout());
        card1.add(obj1);
        cards.add(card1);
    }
    public void btnEdit()
    {
        Panel1_Edit obj2 = new Panel1_Edit(dugaar);
        card2 = new JPanel(new BorderLayout());
        card2.add(obj2);
        cards.add(card2);
    }
}
