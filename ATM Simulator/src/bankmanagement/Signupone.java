package bankmanagement;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
// import java.sql.*;

public class Signupone extends JFrame implements ActionListener{

    long random;
    JDateChooser dateChooser;
    JTextField nameTextField,fnameTextField,dobTextField,emailTextField,addressTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton marriedRadioButton,unmarriedRadioButton,otherRadioButton,maleRadioButton,femaleRadioButton;
    Signupone(){
        

        Random rand = new Random();
        random = Math.abs((rand.nextLong() % 9000L) + 1000L);

        //application label
        JLabel formno = new JLabel("Application Form No. "+random);
        formno.setFont(new Font("Arial",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        //page1 label
        JLabel page1 = new JLabel("Page 1: Personal Details");
        page1.setFont(new Font("Arial",Font.BOLD,22));
        page1.setBounds(290,80,400,30);
        add(page1);

        //name
        JLabel name = new JLabel("Name:");
        name.setBounds(100,140,200,30);
        name.setFont(new Font("Arial",Font.BOLD,20));
        add(name);

        //name textfield
        nameTextField = new JTextField();
        nameTextField.setBounds(300,140,400,30);
        nameTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(nameTextField);

        //fname
        JLabel fname = new JLabel("Father Name:");
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Arial",Font.BOLD,20));
        add(fname);

        //fname textfield
        fnameTextField = new JTextField();
        fnameTextField.setBounds(300,190,400,30);
        fnameTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(fnameTextField);

        //dob
        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Arial",Font.BOLD,20));
        add(dob);

        //dob textfield
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,240,200,30);
        add(dateChooser);


        //gender
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100,290,200,30);
        gender.setFont(new Font("Arial",Font.BOLD,20));
        add(gender);

        //gender radiobutton
        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(300,290,120,30);
        maleRadioButton.setBackground(Color.white);
        add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(450,290,120,30);
        femaleRadioButton.setBackground(Color.white);
        add(femaleRadioButton);

        ButtonGroup genderbutton = new ButtonGroup();
        genderbutton.add(femaleRadioButton);
        genderbutton.add(maleRadioButton);


        //email
        JLabel email = new JLabel("Email Address:");
        email.setBounds(100,340,200,30);
        email.setFont(new Font("Arial",Font.BOLD,20));
        add(email);

        //email textfield
        emailTextField = new JTextField();
        emailTextField.setBounds(300,340,400,30);
        emailTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(emailTextField);

        // marital
        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(100,390,200,30);
        marital.setFont(new Font("Arial",Font.BOLD,20));
        add(marital);

        //marital radio
        marriedRadioButton = new JRadioButton("Married");
        marriedRadioButton.setBounds(300,390,120,30);
        marriedRadioButton.setBackground(Color.white);
        add(marriedRadioButton);

        unmarriedRadioButton = new JRadioButton("Unmarried");
        unmarriedRadioButton.setBounds(450,390,120,30);
        unmarriedRadioButton.setBackground(Color.white);
        add(unmarriedRadioButton);

        otherRadioButton = new JRadioButton("Other");
        otherRadioButton.setBounds(600,390,120,30);
        otherRadioButton.setBackground(Color.white);
        add(otherRadioButton);

        ButtonGroup gendeButtonGroup = new ButtonGroup();
        gendeButtonGroup.add(marriedRadioButton);
        gendeButtonGroup.add(unmarriedRadioButton);
        gendeButtonGroup.add(otherRadioButton);

        //address
        JLabel address = new JLabel("Address:");
        address.setBounds(100,440,200,30);
        address.setFont(new Font("Arial",Font.BOLD,20));
        add(address);

        //address textfield
        addressTextField = new JTextField();
        addressTextField.setBounds(300,440,400,30);
        addressTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(addressTextField);

        //city
        JLabel city = new JLabel("City:");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("Arial",Font.BOLD,20));
        add(city);

        //city textfield
        cityTextField = new JTextField();
        cityTextField.setBounds(300,490,400,30);
        cityTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(cityTextField);

        //state
        JLabel State = new JLabel("State:");
        State.setBounds(100,540,200,30);
        State.setFont(new Font("Arial",Font.BOLD,20));
        add(State);

        //state textfield
        stateTextField = new JTextField();
        stateTextField.setBounds(300,540,400,30);
        stateTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(stateTextField);

        //pincode
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setBounds(100,590,200,30);
        pincode.setFont(new Font("Arial",Font.BOLD,20));
        add(pincode);

        //pincode textfield
        pincodeTextField = new JTextField();
        pincodeTextField.setBounds(300,590,400,30);
        pincodeTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(pincodeTextField);

        //next button
        next = new JButton("NEXT");
        next.setBounds(550,640,100,30);
        next.setFont(new Font("Arial",Font.BOLD,20));
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("Automated Teller Machine");
        setSize(800,800);
        setVisible(true);
        setLocation(350,10);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;//long
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(maleRadioButton.isSelected()){
            gender = "Male";
        }
        else if(femaleRadioButton.isSelected()){
            gender = "Female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if(marriedRadioButton.isSelected()){
            marital = "Married";
        }
        else if(unmarriedRadioButton.isSelected()){
            marital = "Unmarried";
        }
        else if(otherRadioButton.isSelected()){
            marital = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        try{
            Conn con = new Conn();
            String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
            con.st.executeUpdate(query);

            setVisible(false);
            new Signuptwo(formno).setVisible(true);
        }
    catch(Exception e){
        System.out.println(e);
    }
    }
    
    public static void main(String[] args) {
        new Signupone();
    }

    
}
