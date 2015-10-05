package RegistrationJava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class BurtgelNemeh extends JPanel{
    
    public UtilDateModel model;
    public JDatePanelImpl datePanel;
    public JDatePickerImpl datePicker;
    
    BurtgelNemeh()
    {
        setBorder(BorderFactory.createTitledBorder("Бүртгэл нэмэх"));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setSize(410,600);
        setVisible(true);
        
        JPanel sexp = new JPanel();
        JPanel pan = new JPanel();
        //pan.setBackground(Color.red);
        pan.setPreferredSize(new Dimension(405,20));
        JPanel pan1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        //pan1.setBackground(Color.blue);
        pan1.setPreferredSize(new Dimension(405,40));
        
        
        JButton save = new JButton("Хадгалах");
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
        
        save.setPreferredSize(new Dimension(130,30));
        clear.setPreferredSize(new Dimension(130,30));
        
        
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
        JPanel panel=new JPanel();
        panel.setPreferredSize(new Dimension(200,30));
        panel.add(datePicker);
        
        
        
        pan1.add(save);
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
        add(panel);
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
        
        save.addActionListener(ae->
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

                String query = "insert into register(reg_tenhim, reg_zereg, reg_ovog, reg_ner, reg_code, reg_huis, reg_elssenOn, reg_utas, reg_address, reg_mail, reg_bday)"
                                          + "values('"+comb1+"','"+comb2+"','"+ovog+"','"+ner+"','"+code+"','"+huis+"','"+elssenOn+"','"+utas+"','"+address+"','"+mail+"','"+bday+"')";
                DatabaseTools.runQuery(query);
                JOptionPane.showMessageDialog(null, "Амжилттай нэмэгдлээ.");

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