package RegistrationJava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class BurtgelZasah extends JPanel{
    

    BurtgelZasah(int dugaar)
    {
        setBorder(BorderFactory.createTitledBorder("Бүртгэл засах"));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setSize(425,610);
        setVisible(true);
        
        JPanel sexp = new JPanel();
        JPanel pan = new JPanel();
        //pan.setBackground(Color.red);
        pan.setPreferredSize(new Dimension(405,20));
        JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //pan1.setBackground(Color.blue);
        pan1.setPreferredSize(new Dimension(405,40));
        
        
        JButton edit = new JButton("Засах");
        JButton clear = new JButton("Цэвэрлэх");
        
        JLabel lbl1 = new JLabel("Харъяалагдах тэнхим :");
        JLabel lbl2 = new JLabel("Зэрэг :");
        JLabel lbl3 = new JLabel("Овог ***:");
        JLabel lbl4 = new JLabel("Нэр *** :");
        JLabel lbl5 = new JLabel("Оюутны код *** :");
        JLabel lbl6 = new JLabel("Хүйс :");
        JLabel lbl7 = new JLabel("Элссэн он *** :");
        JLabel lbl8 = new JLabel("Гар утас :");
        JLabel lbl9 = new JLabel("Гэрийн хаяг :");
        JLabel lbl10 = new JLabel("Майл хаяг :");
        JLabel lbl11 = new JLabel("Төрсөн өдөр :");
        
        JComboBox combo1 = new JComboBox();             
        JComboBox combo2 = new JComboBox();                     
        
        JTextField fld1 = new JTextField();
        JTextField fld2 = new JTextField();
        JTextField fld3 = new JTextField();
        JTextField fld4 = new JTextField();
        JTextField fld5 = new JTextField();
        JTextField fld6 = new JTextField();
        JTextField fld7 = new JTextField();
        
        JRadioButton rd1 = new JRadioButton("Эр");
        JRadioButton rd2 = new JRadioButton("Эм");
        ButtonGroup sex = new ButtonGroup();
        sex.add(rd1);
        sex.add(rd2);
        
        sexp.add(rd1);
        sexp.add(rd2);
        sexp.setLayout(new FlowLayout(FlowLayout.LEFT));
        sexp.setPreferredSize(new Dimension(200,30));
        
        JTextArea ta1 = new JTextArea();
        
        lbl1.setPreferredSize(new Dimension(200,30));
        lbl2.setPreferredSize(new Dimension(200,30));
        lbl3.setPreferredSize(new Dimension(200,30));
        lbl4.setPreferredSize(new Dimension(200,30));
        lbl5.setPreferredSize(new Dimension(200,30));
        lbl6.setPreferredSize(new Dimension(200,30));
        lbl7.setPreferredSize(new Dimension(200,30));
        lbl8.setPreferredSize(new Dimension(200,30));
        lbl9.setPreferredSize(new Dimension(200,30));
        lbl10.setPreferredSize(new Dimension(200,30));
        lbl11.setPreferredSize(new Dimension(200,30));
        
        combo1.setPreferredSize(new Dimension(200,30));
        combo2.setPreferredSize(new Dimension(200,30));
        
        fld1.setPreferredSize(new Dimension(200,30));
        fld2.setPreferredSize(new Dimension(200,30));
        fld3.setPreferredSize(new Dimension(200,30));
        fld4.setPreferredSize(new Dimension(200,30));
        fld5.setPreferredSize(new Dimension(200,30));
        fld6.setPreferredSize(new Dimension(200,30));
        fld7.setPreferredSize(new Dimension(200,30));
        
        ta1.setPreferredSize(new Dimension(200,100));
        
        edit.setPreferredSize(new Dimension(130,30));
        clear.setPreferredSize(new Dimension(130,30));
        
        pan1.add(edit);
        pan1.add(clear);
        
        add(lbl1);
        add(combo1);
        add(lbl2);
        add(combo2);
        add(lbl3);
        add(fld1);
        add(lbl4);
        add(fld2);
        add(lbl5);
        add(fld3);
        add(lbl6);
        add(sexp);
        add(lbl7);
        add(fld4);
        add(lbl8);
        add(fld5);
        add(lbl9);
        add(ta1);
        add(lbl10);
        add(fld6);
        add(lbl11);
        add(fld7);
        add(pan);
        add(pan1);
        
        try
        { 
            String s = "SELECT * FROM tenhim";
            String s1 = "SELECT * FROM zereg"; 
            ResultSet rs = DatabaseTools.runQuery(s); 
            ResultSet rs1 = DatabaseTools.runQuery(s1);
            while(rs.next()) 
            { 
                combo1.addItem(rs.getString(2)); 
            }
            while(rs1.next()) 
            { 
                combo2.addItem(rs1.getString(2)); 
            } 
        }
        catch(Exception e)
        { 
        }
        
        
        String query1 = "select * from register where reg_id = "+dugaar+"";
        ResultSet rs = DatabaseTools.runQuery(query1);
        try 
        {
            while(rs.next())
            {
                fld1.setText(rs.getString("reg_ovog"));
                fld2.setText(rs.getString("reg_ner"));
                fld3.setText(rs.getString("reg_code"));
                fld4.setText(rs.getString("reg_elssenOn"));
                fld5.setText(rs.getString("reg_utas"));
                fld6.setText(rs.getString("reg_mail"));
                fld7.setText(rs.getString("reg_bday"));
                ta1.setText(rs.getString("reg_address"));
                String gay=rs.getString("reg_huis");
                if(gay.equals("Эр"))
                {
                    rd1.setSelected(true);
                }
                else
                    rd2.setSelected(true);
            }
        } 
        catch (Exception e) 
        {
        }
                edit.addActionListener(ae->
                {
                    if (fld1.getText().equals("") ||
                        fld2.getText().equals("") ||
                        fld3.getText().equals("") ||
                        fld4.getText().equals("")    )
                    {
                        JOptionPane.showMessageDialog(null, "Таны (***)-р тэмдэглэсэн хэсгийг заавал бөглөнө үү!");
                    }
                    else
                    {
                        String comb1 = combo1.getSelectedItem().toString();
                        String comb2 = combo2.getSelectedItem().toString();
                        String ovog = fld1.getText();
                        String ner = fld2.getText();
                        String code = fld3.getText();
                        String huis;
                            if(rd1.isSelected())
                                huis ="Эр";
                            else
                                huis ="Эм";
                        String elssenOn = fld4.getText();
                        String utas = fld5.getText();
                        String address = ta1.getText();
                        String mail =fld6.getText();
                        String bday = fld7.getText();

                        String query = "update register SET reg_tenhim='"+comb1+"', reg_zereg='"+comb2+"', reg_ovog='"+ovog+"', reg_ner='"+ner+"', reg_code='"+code+"', reg_huis='"+huis+"', reg_elssenOn='"+elssenOn+"', reg_utas='"+utas+"', reg_address='"+address+"', reg_mail='"+mail+"', reg_bday='"+bday+"' where reg_id='"+dugaar+"'";
                        DatabaseTools.runQuery(query);
                        JOptionPane.showMessageDialog(null, "Амжилттай засагдлаа.");

                        Tsonh.model.setRowCount(0);
                        Tsonh.refresh();
                    }
                });
                
        clear.addActionListener(ae->
        {
            fld1.setText("");
            fld2.setText("");
            fld3.setText("");
            fld4.setText("");
            fld5.setText("");
            fld6.setText("");
            fld7.setText("");
            ta1.setText("");
            sex.clearSelection();
        });
    }
}