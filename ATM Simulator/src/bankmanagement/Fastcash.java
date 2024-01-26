package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener {

    String pinnumber;
    JButton rs100button,rs500button,rs1000button,rs2000button,rs5000button,rs10000button,backbutton;
    Fastcash(String pinnumber){
        this.pinnumber = pinnumber;

        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        setVisible(true);
        
        //label
        JLabel Fastcash = new JLabel("Please select your amount for withdrawl");
        Fastcash.setFont(new Font("Raleway",Font.BOLD,20));
        Fastcash.setBounds(150,200,500,30);
        add(Fastcash);

        //buttons
        rs100button = new JButton("Rs 100");
        rs100button.setBounds(100,300,200,30);
        rs100button.setFont(new Font("Raleway",Font.BOLD,20));
        rs100button.addActionListener(this);
        add(rs100button);

        rs500button = new JButton("Rs 500");
        rs500button.setBounds(350,300,200,30);
        rs500button.setFont(new Font("Raleway",Font.BOLD,20));
        rs500button.addActionListener(this);
        add(rs500button);

        rs1000button = new JButton("Rs 1000");
        rs1000button.setBounds(100,350,200,30);
        rs1000button.setFont(new Font("Raleway",Font.BOLD,20));
        rs1000button.addActionListener(this);
        add(rs1000button);

        rs2000button = new JButton("Rs 2000");
        rs2000button.setBounds(350,350,200,30);
        rs2000button.setFont(new Font("Raleway",Font.BOLD,20));
        rs2000button.addActionListener(this);
        add(rs2000button);

        rs5000button = new JButton("Rs 5000");
        rs5000button.setBounds(100,400,200,30);
        rs5000button.setFont(new Font("Raleway",Font.BOLD,20));
        rs5000button.addActionListener(this);
        add(rs5000button);

        rs10000button = new JButton("10,000");
        rs10000button.setBounds(350,400,200,30);
        rs10000button.setFont(new Font("Raleway",Font.BOLD,20));
        rs10000button.addActionListener(this);
        add(rs10000button);

        backbutton = new JButton("Back");
        backbutton.setBounds(350,450,200,30);
        backbutton.setFont(new Font("Raleway",Font.BOLD,20));
        backbutton.addActionListener(this);
        add(backbutton);

    }

     @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == backbutton){
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
       }
      else{
        String amount = ((JButton)ae.getSource()).getText().substring(3);
        Conn con = new Conn();
        try{
            ResultSet rs = con.st.executeQuery("select * from bank where pin = '"+pinnumber+"'");
            int balance = 0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if(ae.getSource() == backbutton && balance < Integer.parseInt(amount)){
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }
            Date date = new Date();
            String query = "insert into bank values ('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
            con.st.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Rs " +amount+ "Debited Successfully");;
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        catch(Exception e){
            System.out.println(e);
        }
      }
    }
    
    public static void main(String[] args) {
        new Fastcash("");
    }
   
}
