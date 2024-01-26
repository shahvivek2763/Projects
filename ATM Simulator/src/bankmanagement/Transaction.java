package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {

    String pinnumber;
    JButton depositbutton,cashwithdrawbutton,fastcashbutton,ministatementbutton,pinchangebutton,balanceenquirybutton,exitbutton;
    Transaction(String pinnumber){
        this.pinnumber = pinnumber;

        setSize(900,900);
        setLocation(300,0);
        setLayout(null);
        setVisible(true);
        
        //label
        JLabel transaction = new JLabel("Please select your transaction");
        transaction.setFont(new Font("Raleway",Font.BOLD,20));
        transaction.setBounds(150,200,500,30);
        add(transaction);

        //buttons
        depositbutton = new JButton("Deposit");
        depositbutton.setBounds(100,300,200,30);
        depositbutton.setFont(new Font("Raleway",Font.BOLD,20));
        depositbutton.addActionListener(this);
        add(depositbutton);

        cashwithdrawbutton = new JButton("Cash Withdraw");
        cashwithdrawbutton.setBounds(350,300,200,30);
        cashwithdrawbutton.setFont(new Font("Raleway",Font.BOLD,20));
        cashwithdrawbutton.addActionListener(this);
        add(cashwithdrawbutton);

        fastcashbutton = new JButton("Fast Cash");
        fastcashbutton.setBounds(100,350,200,30);
        fastcashbutton.setFont(new Font("Raleway",Font.BOLD,20));
        fastcashbutton.addActionListener(this);
        add(fastcashbutton);

        ministatementbutton = new JButton("Mini Statement");
        ministatementbutton.setBounds(350,350,200,30);
        ministatementbutton.setFont(new Font("Raleway",Font.BOLD,20));
        ministatementbutton.addActionListener(this);
        add(ministatementbutton);

        pinchangebutton = new JButton("Pin Change");
        pinchangebutton.setBounds(100,400,200,30);
        pinchangebutton.setFont(new Font("Raleway",Font.BOLD,20));
        pinchangebutton.addActionListener(this);
        add(pinchangebutton);

        balanceenquirybutton = new JButton("Balance Enquiry");
        balanceenquirybutton.setBounds(350,400,200,30);
        balanceenquirybutton.setFont(new Font("Raleway",Font.BOLD,20));
        balanceenquirybutton.addActionListener(this);
        add(balanceenquirybutton);

        exitbutton = new JButton("Exit");
        exitbutton.setBounds(350,450,200,30);
        exitbutton.setFont(new Font("Raleway",Font.BOLD,20));
        exitbutton.addActionListener(this);
        add(exitbutton);

    }

     @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource() == exitbutton){
        System.exit(0);
       }
       else if(ae.getSource() == depositbutton){
        setVisible(false);
        new Deposit(pinnumber).setVisible(true);
       }
       else if(ae.getSource() == cashwithdrawbutton){
        setVisible(false);
        new Withdraw(pinnumber).setVisible(true);
       }
        else if(ae.getSource() == fastcashbutton){
        setVisible(false);
        new Fastcash(pinnumber).setVisible(true);
       }
        else if(ae.getSource() == pinchangebutton){
        setVisible(false);
        new Pinchange(pinnumber).setVisible(true);
       }
        else if(ae.getSource() == balanceenquirybutton){
        setVisible(false);
        new BalanceEnquiry(pinnumber).setVisible(true);
       }
        else if(ae.getSource() == ministatementbutton){
        // setVisible(false);
        new Ministatement(pinnumber).setVisible(true);
       }
    }
    
    public static void main(String[] args) {
        new Transaction("");
    }
   
}
