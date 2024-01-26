package bankmanagement;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    JButton signinButton,clearButton,signupButton;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login(){

        //Title
        setTitle("AUTOMATED TELLER MACHINE");

        //need to layout null(so we can set ourself position) beacuse it has its own layout
        setLayout(null);

        //first image position and fonts 
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        //first label
        JLabel text = new JLabel("Welcome to ATM");
        text.setBounds(200,40,400,40);
        text.setFont(new Font("Algeria",Font.BOLD,35));
        add(text);

        //cardno label
        JLabel cardno = new JLabel("Card No.");
        cardno.setBounds(120,140,400,40);
        cardno.setFont(new Font("Algeria",Font.BOLD,25));
        add(cardno);

        //cardtextfield
        cardTextField = new JTextField();
        cardTextField.setBounds(300,140,250,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        //pin no. label
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Algeria",Font.BOLD,25));
        pin.setBounds(120,200,400,40);
        add(pin);
        
        //pintextfield
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,200,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        //signin button
        signinButton = new JButton("Sign In");
        signinButton.setBounds(300,260,100,30);
        signinButton.setBackground(Color.BLACK);
        signinButton.setForeground(Color.white);
        signinButton.addActionListener(this);
        add(signinButton);

        //clear button
        clearButton = new JButton("Clear");
        clearButton.setBounds(450,260,100,30);
        clearButton.setBackground(Color.BLACK);
        clearButton.setForeground(Color.white);
        clearButton.addActionListener(this);
        add(clearButton);

        //signup button
        signupButton = new JButton("Sign Up");
        signupButton.setBounds(300,320,250,30);
        signupButton.setBackground(Color.BLACK);
        signupButton.setForeground(Color.white);
        signupButton.addActionListener(this);
        add(signupButton);

        getContentPane().setBackground(Color.white);
        
        //for panel
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        
    }

    //Action Performed if we click that button
     @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == signinButton){
            Conn con = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs = con.st.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect cardnumber or pin");
                }
            }
                catch(Exception e){
                    System.out.println(e);
                }
            
        }
        else if(ae.getSource() == clearButton){
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource() == signupButton){
            setVisible(false);
            new Signupone().setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }

}
