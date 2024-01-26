package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Ministatement extends JFrame implements ActionListener {
    String pinnumber;

    Ministatement(String pinnumber){
        this.pinnumber = pinnumber;

        setTitle("Mini Statement");
        setLayout(null);
        setSize(400,600);
        getContentPane().setBackground(Color.white);
        setVisible(true);

       
        JLabel bank = new JLabel("Local Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

         JLabel text = new JLabel();
        text.setBounds(20,140,400,200);
        add(text);

         JLabel balance = new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        try{
            Conn con = new Conn();
            ResultSet rs = con.st.executeQuery("select * from login where pin = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number "+ rs.getString("cardnumber").substring(0,4)+"XXXXXXXX"+rs.getString("cardnumber").substring(12,16));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn con =new Conn();
            int bal=0;
            
           ResultSet rs = con.st.executeQuery("select * from bank where pin = '"+pinnumber+"'");
           while(rs.next()){
                text.setText(text.getText()+ "<html>"+ rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                 if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            
           
            balance.setText("Your Current account balance is Rs "+bal);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent ae){

    }
    public static void main(String[] args) {
        new Ministatement("");
    }
}
