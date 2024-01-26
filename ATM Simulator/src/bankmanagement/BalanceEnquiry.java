package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener{

    JButton backButton;
    String pinnumber;
     int balance = 0;

    BalanceEnquiry(String pinnumber){
        this.pinnumber = pinnumber;

        setSize(900,900);
        setLayout(null);
        setLocation(300,0);
        setVisible(true);

        //display balance here because we didnt click on any button  so thr query will run under the  constructor
         Conn con = new Conn();
        try{
            ResultSet rs = con.st.executeQuery("select * from bank where pin = '"+pinnumber+"'");
           
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        JLabel text1 = new JLabel("Your current account balanace is Rs "+balance);
        text1.setBounds(170,300,400,30);
        // text1.setFont(new Font("Algeria",Font.BOLD,25));
        add(text1);

        backButton = new JButton("Back");
        backButton.setBounds(355,520,150,30);
        backButton.setFont(new Font("Raleway",Font.BOLD,20));
        backButton.addActionListener(this);
        add(backButton);

    }

    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
        
    }
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
