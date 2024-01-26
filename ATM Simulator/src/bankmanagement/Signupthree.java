package bankmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signupthree extends JFrame implements ActionListener{

    String formno;
    JRadioButton accButton1,accButton2,accButton3,accButton4;
    JCheckBox atmcard,mobilebanking,chequebook,internetbanking,emailalerts,estatement,confirmCheckBox;
    JButton cancelButton,submitButton;
    Signupthree(String formno){
        this.formno = formno;

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("Additional Details PAge No. 2");
        setSize(800,800);
        setVisible(true);
        setLocation(350,10);

        //page1 label
        JLabel page3 = new JLabel("Page 3: Account Details");
        page3.setFont(new Font("Arial",Font.BOLD,22));
        page3.setBounds(280,40,400,40);
        add(page3);

        //account type
        JLabel acctype = new JLabel("Account Type");
        acctype.setFont(new Font("Raleway",Font.BOLD,22));
        acctype.setBounds(100,140,200,30);
        add(acctype);

        //radiobutton for account
        accButton1 = new JRadioButton("Saving Account");
        accButton1.setBounds(100,180,250,20);
        accButton1.setFont(new Font("Raleway",Font.BOLD,16));
        accButton1.setBackground(Color.white);
        add(accButton1);

        accButton2 = new JRadioButton("Fixed Deposit ");
        accButton2.setBounds(350,180,250,20);
        accButton2.setFont(new Font("Raleway",Font.BOLD,16));
        accButton2.setBackground(Color.white);
        add(accButton2);
        
        accButton3 = new JRadioButton("Current Account ");
        accButton3.setBounds(100,220,250,20);
        accButton3.setFont(new Font("Raleway",Font.BOLD,16));
        accButton3.setBackground(Color.white);
        add(accButton3);

        accButton4 = new JRadioButton("Recuurent Account ");
        accButton4.setBounds(350,220,250,20);
        accButton4.setFont(new Font("Raleway",Font.BOLD,16));
        accButton4.setBackground(Color.white);
        add(accButton4);

        ButtonGroup accButtonGroup = new ButtonGroup();
        accButtonGroup.add(accButton1);
        accButtonGroup.add(accButton2);
        accButtonGroup.add(accButton3);
        accButtonGroup.add(accButton4);

        //card details
        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);

        JLabel cardno = new JLabel("XXXX-XXXX-XXXX-7789");
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        cardno.setBounds(330,300,300,30);
        add(cardno);

        JLabel carddetails = new JLabel("Your 16 Digit Card Number");
        carddetails.setFont(new Font("Raleway",Font.BOLD,15));
        carddetails.setBounds(100,330,330,30);
        add(carddetails);

        //pin details
        JLabel pin = new JLabel("Card Number");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);

        JLabel pinno = new JLabel("XXXX");
        pinno.setFont(new Font("Raleway",Font.BOLD,22));
        pinno.setBounds(330,370,300,30);
        add(pinno);

        JLabel pindetails = new JLabel("4 Digit Password ");
        pindetails.setFont(new Font("Raleway",Font.BOLD,15));
        pindetails.setBounds(100,400,200,30);
        add(pindetails);

        //service
        JLabel service = new JLabel("Service Required: ");
        service.setBounds(100,450,200,30);
        service.setFont(new Font("Raleway",Font.BOLD,22));
        add(service);

        //checkboxes
        atmcard = new JCheckBox("ATM CARD");
        atmcard.setBounds(100,500,200,30);
        atmcard.setFont(new Font("Raleway",Font.BOLD,15));
        add(atmcard);

        internetbanking = new JCheckBox("INTERNET BANKING:");
        internetbanking.setBounds(330,500,200,30);
        internetbanking.setFont(new Font("Raleway",Font.BOLD,15));
        add(internetbanking);

        mobilebanking = new JCheckBox("MOBILE BANKING:");
        mobilebanking.setBounds(100,550,200,30);
        mobilebanking.setFont(new Font("Raleway",Font.BOLD,15));
        add(mobilebanking);

        emailalerts = new JCheckBox("EMAIL ALERTS: ");
        emailalerts.setBounds(330,550,200,30);
        emailalerts.setFont(new Font("Raleway",Font.BOLD,15));
        add(emailalerts);

        chequebook = new JCheckBox("CHEQUE BOOK: ");
        chequebook.setBounds(100,600,200,30);
        chequebook.setFont(new Font("Raleway",Font.BOLD,15));
        add(chequebook);

        estatement = new JCheckBox("E-STATEMENT");
        estatement.setBounds(330,600,200,30);
        estatement.setFont(new Font("Raleway",Font.BOLD,15));
        add(estatement);

        //confirmation
        confirmCheckBox = new JCheckBox();
        confirmCheckBox.setBounds(100,650,20,30);
        confirmCheckBox.setFont(new Font("Raleway",Font.BOLD,8));
        add(confirmCheckBox);

        JLabel confirm = new JLabel("I hereby declares that the above entered details correct to the best of my knowledge");
        confirm.setBounds(130,650,500,30);
        confirm.setFont(new Font("Raleway",Font.BOLD,12));
        add(confirm);

        //cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(200,700,100,30);
        cancelButton.setFont(new Font("Arial",Font.BOLD,20));
        cancelButton.addActionListener(this);
        add(cancelButton);

        //submit button
        submitButton = new JButton("NEXT");
        submitButton.setBounds(400,700,100,30);
        submitButton.setFont(new Font("Arial",Font.BOLD,20));
        submitButton.addActionListener(this);
        add(submitButton);
    }
  
    @Override
    public void actionPerformed(ActionEvent ae) {
    
       if(ae.getSource() == submitButton){
        String accounttype = null;
        if(accButton1.isSelected()){
            accounttype = "Saving Account";
        }
        else if(accButton2.isSelected()){
            accounttype = "Fixed Deposit Account";
        }
        else if(accButton3.isSelected()){
            accounttype = "Current Account";
        }
        else if(accButton4.isSelected()){
            accounttype = "Reccurent Account";
        }
        Random random = new Random();
        String cardnumber = "" + Math.abs((random.nextLong()%90000000)+5040936000000000L);
        String pinnumber = "" + Math.abs((random.nextLong()%9000L)+1000L);

        String facility = "";
        if(atmcard.isSelected()){
            facility = facility + "Atm Card";
        }
        else if(mobilebanking.isSelected()){
            facility = facility + "Mobile Banking";
        }
        else if(chequebook.isSelected()){
            facility = facility + "Cheque Book";
        }
        else if(internetbanking.isSelected()){
            facility = facility + "Internet Banking";
        }
        else if(emailalerts.isSelected()){
            facility = facility + "Email Alerts";
        }
        else if(estatement.isSelected()){
            facility = facility + "E-Statements";
        }
        try {
            if(accounttype.equals("")){
                JOptionPane.showMessageDialog(null,"Account type is required");
            }
            else{
                Conn con = new Conn();
                String query1 = "insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber +"')";
                
                con.st.executeUpdate(query1);
                con.st.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Card number: "+cardnumber+"\n Pin number"+pinnumber);

                //signup1 object
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
       
     
    }
      else if(ae.getSource() == cancelButton ){
        setVisible(false);
        new Login().setVisible(true);
       }

    }

      public static void main(String[] args) {
        new Signupthree(" ");
    }
}
