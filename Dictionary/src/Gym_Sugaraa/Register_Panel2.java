package Gym_Sugaraa;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
public class Register_Panel2 extends JPanel{
    
    final static DefaultTableModel model = new DefaultTableModel();
    static int dugaar;
    static JTable table;
    
    Register_Panel2(){
    
        setLayout(new BorderLayout());
        JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel pan2 = new JPanel(new BorderLayout());
        pan1.setBorder(BorderFactory.createTitledBorder("Хайлт"));
        pan2.setBorder(BorderFactory.createTitledBorder("Бүртгэл хүснэгт"));
        
        pan1.setPreferredSize(new Dimension(780,50));
        pan2.setPreferredSize(new Dimension(780,450));
        
        
        JButton search = new JButton("Хайх");
        JLabel lab1 = new JLabel("Хурдан хайлт :");
        JLabel lab2 = new JLabel("Баганаар хайлт :");
        JTextField fld1 = new JTextField();
        JTextField fld2 = new JTextField();
        JPanel empty1 = new JPanel();
        empty1.setPreferredSize(new Dimension(150,20));
        String a[]={"Тэнхимээр","Зэргээр","Овгоор","Нэрээр","Хүйсээр","Кодоор","Элссэн оноор","Зэргээр","Утсаар","Хаягаар","Зэргээр","Майл хаягаар","Төрсөн өдрөөр"};
        JComboBox combo1 = new JComboBox(a);
        combo1.setMaximumRowCount(5);
        search.setPreferredSize(new Dimension(70,20));
        combo1.setPreferredSize(new Dimension(120,20));
        fld1.setPreferredSize(new Dimension(100,20));
        fld2.setPreferredSize(new Dimension(100,20));
        
        
        
        add(pan1, BorderLayout.NORTH);
        
                pan1.add(lab1);
                pan1.add(fld1);
                pan1.add(empty1);
                pan1.add(lab2);
                pan1.add(fld2);
                pan1.add(combo1);
                pan1.add(search);
            
        add(pan2, BorderLayout.CENTER);
        
            table = new JTable(model);
            table.setRowSelectionAllowed(true);
            TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
        
            table.setRowSorter(rowSorter);
                    model.addColumn("Д/д:");
                    model.addColumn("Төрөл:");
                    model.addColumn("Овог:");
                    model.addColumn("Нэр:");
                    model.addColumn("Хүйс:");
                    model.addColumn("Төрсөн огноо:");
                    model.addColumn("Утас:");
                    model.addColumn("Эхлэх:");
                    model.addColumn("Дуусах:");
            
            table.setPreferredSize(new Dimension(600, 410));
            JScrollPane scp = new JScrollPane(table);
            scp.setPreferredSize(new Dimension(500, 410));
            pan2.add(scp);
            
        if(table.getSelectedRow()!=-1)
        {
            String id = table.getValueAt(table.getSelectedRow(), 0).toString();
            dugaar = Integer.parseInt(id);
            System.out.println("awd "+dugaar);
        }
        else
        {
            
        }
        
        registerREF();
        
        
        
    }
    public static void registerREF()
    {
        String query = "select * from gym_register";
        ResultSet result = Gym_Database.runQuery(query);
        try 
        {
            while(result.next())
            {
                model.addRow(new Object[]{
                    result.getString("reg_id"),
                    result.getString("reg_cate"),
                    result.getString("reg_lastname"),
                    result.getString("reg_firstname"),
                    result.getString("reg_sex"),
                    result.getString("reg_payment"),
                    result.getString("reg_phone"),
                    result.getString("reg_start"),
                    result.getString("reg_end")
                });
            }
        } 
        catch (SQLException e) 
        {
        }
    }
        
  
}