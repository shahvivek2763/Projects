package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
// import java.util.*;
import java.util.Date;
// import java.sql.*;

public class Withdraw extends JFrame implements ActionListener{

    String pinnumber;
    JTextField amountTextField;
    JButton WithdrawButton,backButton;

    Withdraw(String pinnumber){
        this.pinnumber = pinnumber;

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setSize(800,800);
        setVisible(true);
        setLocation(350,10);

        //amount you want to Withdraw
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(170,300,400,20);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        add(text);

        //amount textfield
        amountTextField = new JTextField();
        amountTextField.setFont(new Font("Raleway",Font.BOLD,16));
        amountTextField.setBounds(170,350,320,25);
        add(amountTextField);

        //Withdraw buuton
        WithdrawButton = new JButton("Withdraw");
        WithdrawButton.setBounds(355,485,150,30);
        WithdrawButton.addActionListener(this);
        add(WithdrawButton);

        //back button
        backButton = new JButton("Back");
        backButton.setBounds(355,520,150,30);
        backButton.addActionListener(this);
        add(backButton);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == WithdrawButton){
            String amount = amountTextField.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null, "Enter an amount to Withdraw");
            }
            else{
                try{
                Conn con = new Conn();
                String query = "insert into bank values ('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                con.st.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+ " Withdraw Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource() == backButton){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdraw("");
    }
}
