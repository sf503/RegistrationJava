package Gym_Sugaraa;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Gym_Login extends JFrame implements Gym_Interface{
    
    public Gym_Login()
    {
        super("Нэвтрэх цонх");
        
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        
        JLabel lblUser = new JLabel("Хэрэглэгчийн нэр :");
        JLabel lblPass = new JLabel("Нууц үг :");
        
        JTextField txtUser = new JTextField();
        JPasswordField pass = new JPasswordField();
        
        JButton nevtreh = new JButton("Нэвтрэх");
        
        lblUser.setPreferredSize(new Dimension(130,20));
        lblPass.setPreferredSize(new Dimension(130,20));
        txtUser.setPreferredSize(new Dimension(130,20));
        pass.setPreferredSize(new Dimension(130,20));
        nevtreh.setPreferredSize(new Dimension(130,20));
        
        add(lblUser);
        add(txtUser);
        add(lblPass);
        add(pass);
        add(nevtreh);
        
        nevtreh.addActionListener(ae->
        {
            String userName = txtUser.getText();
            char[] Pass  = pass.getPassword();
            String userPass = String.copyValueOf(Pass);
            
            try 
            {
                ResultSet rs = Gym_Database.runQuery("SELECT * FROM gym_user where user_name='"+userName+"' and user_pass='"+userPass+"'");
                if (rs.next()) 
                {
                    new Gym_Main();
                    this.dispose();
                } 
                else
                {
                    JOptionPane.showMessageDialog(this,"Хэрэглэгчийн нэр эсвэл нууц үг буруу байна.");
                }
            }
            catch(SQLException e)
            {
            }
            
            
        });
            
        setSize(280, 120);
        setLocation((screen_width-300)/2,(screen_height-300)/2);
        setVisible(true);
        setResizable(false);
        
    }
    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> {
            new Gym_Login();
        });
    }
}
