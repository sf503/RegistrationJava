package Gym_Sugaraa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Panel1_Add extends JPanel{

    Panel1_Add() {
        
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Бүртгэл нэмэх"));
        JPanel pan = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JPanel huisPanel = new JPanel();
        JPanel emptyPanel = new JPanel();
        JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        emptyPanel.setPreferredSize(new Dimension(400,20));
        
        
        
        
        JButton btnSave = new JButton("Хадгалах");
        JButton btnClear = new JButton("Цэвэрлэх");
        
        JLabel lab1 = new JLabel("Хичээллэх төрөл : *** ");
        JLabel lab2 = new JLabel("Овог : *** ");
        JLabel lab3= new JLabel("Нэр : *** ");
        JLabel lab4 = new JLabel("Хүйс: ");
        JLabel lab5 = new JLabel("Төлбөр: ");
        JLabel lab6 = new JLabel("Утас : ");
        JLabel lab7 = new JLabel("Хугацаа эхлэх: ");
        JLabel lab8 = new JLabel("Хугацаа дуусах: ");
        
        JComboBox combo1 = new JComboBox();
        
        JTextField fld1 = new JTextField();
        JTextField fld2 = new JTextField();
        JTextField fld3 = new JTextField();
        JTextField fld4= new JTextField();
        JTextField fld5 = new JTextField();
        JTextField fld6 = new JTextField();
        JTextField fld7 = new JTextField();
        
        JRadioButton rd1 = new JRadioButton("Эр");
        JRadioButton rd2 = new JRadioButton("Эм");
        ButtonGroup sex = new ButtonGroup();
        sex.add(rd1);
        sex.add(rd2);
        JPanel sexpan = new JPanel();
        sexpan.add(rd1);
        sexpan.add(rd2);
        sexpan.setLayout(new FlowLayout(FlowLayout.LEFT));
        sexpan.setPreferredSize(new Dimension(180,30));
        
        btnSave.setPreferredSize(new Dimension(130,20));
        btnClear.setPreferredSize(new Dimension(130,20));
        
        lab1.setPreferredSize(new Dimension(180,35));
        lab2.setPreferredSize(new Dimension(180,35));
        lab3.setPreferredSize(new Dimension(180,35));
        lab4.setPreferredSize(new Dimension(180,35));
        lab5.setPreferredSize(new Dimension(180,35));
        lab6.setPreferredSize(new Dimension(180,35));
        lab7.setPreferredSize(new Dimension(180,35));
        lab8.setPreferredSize(new Dimension(180,35));
        
        combo1.setPreferredSize(new Dimension(180,35));
        
        fld1.setPreferredSize(new Dimension(180,35));
        fld2.setPreferredSize(new Dimension(180,35));
        fld3.setPreferredSize(new Dimension(180,35));
        fld4.setPreferredSize(new Dimension(180,35));
        fld5.setPreferredSize(new Dimension(180,35));
        fld6.setPreferredSize(new Dimension(180,35));
        fld7.setPreferredSize(new Dimension(180,35));
        
        pan1.add(btnSave);
        pan1.add(btnClear);
        pan.add(lab1);
        pan.add(combo1);
        pan.add(lab2);
        pan.add(fld1);
        pan.add(lab3);
        pan.add(fld2);
        pan.add(lab4);
        pan.add(sexpan);
        pan.add(lab5);
        pan.add(fld4);
        pan.add(lab6);
        pan.add(fld5);
        pan.add(lab7);
        pan.add(fld6);
        pan.add(lab8);
        pan.add(fld7);
        pan.add(emptyPanel);
        pan.add(pan1);
        
        add(pan);
        
        
        try
        { 
            String str = "SELECT * FROM gym_category";
            ResultSet result = Gym_Database.runQuery(str);
            while(result.next()) 
            { 
                combo1.addItem(result.getString(2)); 
            }
        }
        catch(Exception e)
        { 
        }
        
        
        btnSave.addActionListener(ae->
        {
            if( fld1.getText().equals("") ||
                fld2.getText().equals("") )
            {
                JOptionPane.showMessageDialog(null, "Та ( * ) -р тэмдэглэсэн хэсгийг заавал бөглөнө үү?");
            }
            else
            {
                String comb1 = combo1.getSelectedItem().toString();
                String ovog = fld1.getText();
                String ner = fld2.getText();
                String huis;
                    if(rd1.isSelected())
                        huis ="Эр";
                    else
                        huis ="Эм";
                String tolbor = fld4.getText();
                String utas = fld5.getText();
                String start = fld6.getText();
                String end = fld7.getText();
                
                String query = "insert into gym_register(reg_cate, reg_lastname, reg_firstname, reg_sex, reg_payment, reg_phone, reg_start, reg_end)"
                                        + "values('"+comb1+"','"+ovog+"','"+ner+"','"+huis+"','"+tolbor+"','"+utas+"','"+start+"','"+end+"')";
                        
                Gym_Database.runQuery(query);
                JOptionPane.showMessageDialog(null, "Амжилттай нэмэгдлээ");
                
                Register_Panel2.model.setRowCount(0);
                Register_Panel2.registerREF();
            }
        });
        btnClear.addActionListener(ae->
        {
            fld1.setText("");
            fld2.setText("");
            fld4.setText("");
            fld5.setText("");
            fld6.setText("");
            fld7.setText("");
            sex.clearSelection();
        });
        
        
    }
}
