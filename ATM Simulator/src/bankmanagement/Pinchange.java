package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
    String pinnumber;
    JTextField pinTextField,repinTextField;
    JButton changeButton,backButton;

    Pinchange(String pinnumber){
        this.pinnumber = pinnumber;

        setSize(900,900);
        setLayout(null);
        setLocation(300,0);
        setVisible(true);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,280,500,35);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        add(text);

        JLabel pintext = new JLabel("NEW PIN");
        pintext.setBounds(165,320,180,25);
        pintext.setFont(new Font("Raleway",Font.BOLD,16));
        add(pintext);

        pinTextField = new JTextField();
        pinTextField.setBounds(330,320,180,25);
        pinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        add(pinTextField);

        JLabel repintext = new JLabel("Enter NEW PIN");
        repintext.setBounds(165,360,180,25);
        repintext.setFont(new Font("Raleway",Font.BOLD,16));
        add(repintext);

        repinTextField = new JTextField();
        repinTextField.setBounds(330,360,180,25);
        repinTextField.setFont(new Font("Raleway",Font.BOLD,16));
        add(repinTextField);

        changeButton = new JButton("Change pin");
        changeButton.setBounds(350,450,200,30);
        changeButton.setFont(new Font("Raleway",Font.BOLD,20));
        changeButton.addActionListener(this);
        add(changeButton);

        backButton = new JButton("Back");
        backButton.setBounds(350,450,200,30);
        backButton.setFont(new Font("Raleway",Font.BOLD,20));
        backButton.addActionListener(this);
        add(backButton);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == changeButton){
        try{
            String pin = pinTextField.getText();
            String repin = repinTextField.getText();

            if(!pin.equals(repin)){
                JOptionPane.showMessageDialog(null,"Entered pin doesn't match");
                return;
            }
             if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Pin");
                return;
            }
            if(repin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-Enter Repin");
                return;
            }
            Conn con = new Conn();
            String query1 = "update bank set pin = '"+repin+"' where pin = '"+pinnumber+"'";
            String query2 = "update login set pin = '"+repin+"' where pin = '"+pinnumber+"'";
            String query3 = "update signupthree set pin = '"+repin+"' where pin = '"+pinnumber+"'";

            con.st.executeUpdate(query1);
            con.st.executeUpdate(query2);
            con.st.executeUpdate(query3);

            JOptionPane.showMessageDialog(null, "PIN changed successfully");

            setVisible(false);
            new Transaction(repin).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
    }
    else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Pinchange("").setVisible(true);;
    }
}
