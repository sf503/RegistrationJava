package RegistrationJava;

import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Tsonh extends JFrame implements BurtgelInterface
{
    final static DefaultTableModel model = new DefaultTableModel();
    int dugaar;
    JTable table;
    JPanel cards,card1,card2;
    
    public Tsonh(){
        
        super("Оюутан бүртгэлийн систем");
        
        setLayout(null);
        JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pan2 = new JPanel();
        JPanel pan3 = new JPanel(new BorderLayout());
        JPanel pan4 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //pan1.setBackground(Color.red);
        //pan2.setBackground(Color.green);
        
        pan1.setBounds(20, 20, 950, 50);
        pan2.setBounds(20, 80, 950, 480);
        pan3.setBounds(990, 20, 425, 600);
        pan4.setBounds(20,570,950,50);
        
        pan1.setBorder(BorderFactory.createTitledBorder("Хайлт"));
        pan2.setBorder(BorderFactory.createTitledBorder("Хүснэгт"));
        
        JButton add = new JButton("Бүртгэл нэмэх");
        JButton edit = new JButton("Бүртгэл засах");
        
        JButton search = new JButton("Хайх");
        JButton delete = new JButton("Бүртгэл устгах");
        JLabel lab1 = new JLabel("Хурдан хайлт :");
        JLabel lab2 = new JLabel("Баганаар хайлт :");
        JTextField fld1 = new JTextField();
        JTextField fld2 = new JTextField();
        
        String a[]={"Тэнхимээр","Зэргээр","Овгоор","Нэрээр","Хүйсээр","Кодоор","Элссэн оноор","Зэргээр","Утсаар","Хаягаар","Зэргээр","Майл хаягаар","Төрсөн өдрөөр"};
        JComboBox combo1 = new JComboBox(a);
        combo1.setMaximumRowCount(5);
        
        
        add.setPreferredSize(new Dimension(120,30));
        edit.setPreferredSize(new Dimension(120,30));
        delete.setPreferredSize(new Dimension(150,40));
        lab1.setPreferredSize(new Dimension(100,20));
        lab2.setPreferredSize(new Dimension(100,20));
        JPanel empty1 = new JPanel();
        empty1.setPreferredSize(new Dimension(120,20));
        fld1.setPreferredSize(new Dimension(200,20));
        fld2.setPreferredSize(new Dimension(150,20));
        combo1.setPreferredSize(new Dimension(150,20));
        search.setPreferredSize(new Dimension(70,20));
        
        
        add(pan1);
                pan1.add(lab1);
                pan1.add(fld1);
                pan1.add(empty1);
                pan1.add(lab2);
                pan1.add(fld2);
                pan1.add(combo1);
                pan1.add(search);
            
        add(pan2);
                table = new JTable(model);
                table.setRowSelectionAllowed(true);
                TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        
                table.setRowSorter(rowSorter);
                        model.addColumn("Д/д:");
                        model.addColumn("Тэнхим:");
                        model.addColumn("Зэрэг:");
                        model.addColumn("Овог:");
                        model.addColumn("Нэр:");
                        model.addColumn("Код:");
                        model.addColumn("Хүйс:");
                        model.addColumn("Элссэн он:");
                        model.addColumn("Утас:");
                        model.addColumn("Хаяг:");
                        model.addColumn("Майл хаяг:");
                        model.addColumn("Төрсөн өдөр:");
            
                table.setPreferredSize(new Dimension(900, 450));
                JScrollPane scp = new JScrollPane(table);
                scp.setPreferredSize(new Dimension(920, 450));
                pan2.add(scp);
                
        add(pan3);
                JPanel btns = new JPanel(new FlowLayout(FlowLayout.CENTER,50,10));
                cards = new JPanel(new CardLayout());

                btns.setBounds(0, 0, 425, 50);
                //cards.setBounds(0, 200, 425, 400);
                
                
                btns.add(add);
                btns.add(edit);
        
                pan3.add(btns,BorderLayout.NORTH);
                pan3.add(cards, BorderLayout.CENTER);
                
        add(pan4);
                pan4.add(delete);
        
        search.addActionListener(ae->{
            
            
        });
                
        add.addActionListener(ae->
        {
            nemeh();
            CardLayout cl = (CardLayout)(cards.getLayout());
            cl.first(cards);
        });
        edit.addActionListener(e->
        {
            if(table.getSelectedRow()!=-1)
            {
                String id = table.getValueAt(table.getSelectedRow(), 0).toString();
                dugaar = Integer.parseInt(id);
                

                zasah();
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.last(cards);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Та засах мөрөө сонгоно уу...");
            }
        });
        delete.addActionListener(e->
        {
            if(table.getSelectedRow()!=-1)
            {
                String id = table.getValueAt(table.getSelectedRow(), 0).toString();
                dugaar = Integer.parseInt(id);
                int reply = JOptionPane.showConfirmDialog(null,"Та "+dugaar+" ID-тай хэрэглэгчийг устгах уу?", "Устгах", JOptionPane.YES_NO_OPTION);
                if(reply==0)
                {
                    String query1 ="delete from register where reg_id ="+dugaar+"";
                    DatabaseTools.runQuery(query1);
                    JOptionPane.showMessageDialog(null, "Амжилттай устлаа.");
                }
                
                Tsonh.model.setRowCount(0);
                refresh();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Та устгах мөрөө сонгоно уу...");
            }
        });
        
        
        fld1.getDocument().addDocumentListener(new DocumentListener()
        {
            @Override
            public void insertUpdate(DocumentEvent e) 
            {
                String text = fld1.getText();
                if (text.trim().length() == 0) 
                {
                    rowSorter.setRowFilter(null);
                } 
                else 
                {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) 
            {
                String text = fld1.getText();
                if (text.trim().length() == 0) 
                {
                    rowSorter.setRowFilter(null);
                } 
                else 
                {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) 
            {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        
        refresh();
        
        setBounds((screen_width-1500)/2, (screen_height-800)/2, 1440, 670);
        setVisible(true);
        setResizable(false);
    }
    
    public void nemeh ()
    {
        BurtgelNemeh nem = new BurtgelNemeh();
        card1 = new JPanel(new BorderLayout());
        card1.add(nem);
        cards.add(card1);
    }
    public void zasah ()
    {
        BurtgelZasah zas = new BurtgelZasah(dugaar);
        card2 = new JPanel(new BorderLayout());
        card2.add(zas);
        cards.add(card2);
    }
    public static void refresh()
    {
        String query = "select * from register";
        ResultSet result = DatabaseTools.runQuery(query);
        try 
        {
            while(result.next())
            {
                model.addRow(new Object[]{
                    result.getString("reg_id"),
                    result.getString("reg_tenhim"),
                    result.getString("reg_zereg"),
                    result.getString("reg_ovog"),
                    result.getString("reg_ner"),
                    result.getString("reg_code"),
                    result.getString("reg_huis"),
                    result.getString("reg_elssenOn"),
                    result.getString("reg_utas"),
                    result.getString("reg_address"),
                    result.getString("reg_mail"),
                    result.getString("reg_bday")
                });
            }
        } 
        catch (SQLException e) 
        {
        }
    }
        
    
    public static void main(String[] args) {
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        MKiT_UITools._setSubstanceLookAndFeel();
        SwingUtilities.invokeLater(() -> {
            new Tsonh();
        });
    }
}