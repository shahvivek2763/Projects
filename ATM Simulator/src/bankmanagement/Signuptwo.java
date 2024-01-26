package bankmanagement;

import java.awt.*;
import javax.swing.*;
// import java.util.*;
import java.awt.event.*;
// import java.sql.*;

public class Signuptwo extends JFrame implements ActionListener{

    String formno;
    JComboBox<String> religionCombobox,categorycombobox,incomecombobox,educationalcombobox,occupationcombobox;
    JTextField panTextField,adharTextField;
    JButton next;
    JRadioButton syesRadioButton,snoRadioButton,eyesRadioButton,enoRadioButton;
    Signuptwo(String formno){
        this.formno = formno;

        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(170,10,100,100);
        add(label);

        //page1 label
        JLabel page1 = new JLabel("Page 2: Additional Details");
        page1.setFont(new Font("Arial",Font.BOLD,22));
        page1.setBounds(290,40,400,30);
        add(page1);

        //religion
        JLabel religion = new JLabel("Religion:");
        religion.setBounds(100,140,200,30);
        religion.setFont(new Font("Arial",Font.BOLD,20));
        add(religion);

        //religion combobox
        String valregion[] = {"Hindu","Muslim","Sikh","CHristian","Other"};
        religionCombobox = new JComboBox<>(valregion);
        religionCombobox.setBounds(300,140,400,30);
        religionCombobox.setFont(new Font("Arial",Font.BOLD,15));
        add(religionCombobox);

        //category
        JLabel category = new JLabel("Category:");
        category.setBounds(100,190,200,30);
        category.setFont(new Font("Arial",Font.BOLD,20));
        add(category);

        //category combobox
        String valcategory[] = {"General","ST","SC","OBC","Other"};
        categorycombobox = new JComboBox<>(valcategory);
        categorycombobox.setBounds(300,190,400,30);
        categorycombobox.setFont(new Font("Arial",Font.BOLD,15));
        add(categorycombobox);

        //income
        JLabel income = new JLabel("Income:");
        income.setBounds(100,240,200,30);
        income.setFont(new Font("Arial",Font.BOLD,20));
        add(income);

        //income combobox
        String valincome[] = {"Null","<150000","<300000","<600000","Above 600000"};
        incomecombobox = new JComboBox<>(valincome);
        incomecombobox.setBounds(300,240,400,30);
        incomecombobox.setFont(new Font("Arial",Font.BOLD,15));
        add(incomecombobox);


        //educational
        JLabel educational = new JLabel("Educational:");
        educational.setBounds(100,290,200,30);
        educational.setFont(new Font("Arial",Font.BOLD,20));
        add(educational);

        //educational combobox
        String valeducational[] = {"Non Graduate","Graduate","Post Graduate","Other"};
        educationalcombobox = new JComboBox<>(valeducational);
        educationalcombobox.setBounds(300,290,400,30);
        educationalcombobox.setFont(new Font("Arial",Font.BOLD,15));
        add(educationalcombobox);


        //occupation
        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(100,340,200,30);
        occupation.setFont(new Font("Arial",Font.BOLD,20));
        add(occupation);

        //occupation jcombobox
       String valoccupation[] = {"Employed","Unemployed","Business","Other"};
        occupationcombobox = new JComboBox<>(valoccupation);
        occupationcombobox.setBounds(300,340,400,30);
        occupationcombobox.setFont(new Font("Arial",Font.BOLD,15));
        add(occupationcombobox);

        // pan
        JLabel pan = new JLabel("Pan Number:");
        pan.setBounds(100,390,200,30);
        pan.setFont(new Font("Arial",Font.BOLD,20));
        add(pan);

        //pan textfield
        panTextField = new JTextField();
        panTextField.setBounds(300,390,400,30);
        panTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(panTextField);

       
        //adhar
        JLabel adhar = new JLabel("Adhar Card No.:");
        adhar.setBounds(100,440,200,30);
        adhar.setFont(new Font("Arial",Font.BOLD,20));
        add(adhar);

        //adhar textfield
        adharTextField = new JTextField();
        adharTextField.setBounds(300,440,400,30);
        adharTextField.setFont(new Font("Arial",Font.BOLD,15));
        add(adharTextField);

        //senior
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setBounds(100,490,200,30);
        senior.setFont(new Font("Arial",Font.BOLD,20));
        add(senior);

        //senior radio button
        syesRadioButton = new JRadioButton("Yes");
        syesRadioButton.setBounds(300,490,120,30);
        syesRadioButton.setBackground(Color.white);
        add(syesRadioButton);

        snoRadioButton = new JRadioButton("No");
        snoRadioButton.setBounds(450,490,120,30);
        snoRadioButton.setBackground(Color.white);
        add(snoRadioButton);

        ButtonGroup seniorButtonGroup = new ButtonGroup();
        seniorButtonGroup.add(syesRadioButton);
        seniorButtonGroup.add(snoRadioButton);


        //existacc
        JLabel existacc = new JLabel("Existing Account:");
        existacc.setBounds(100,540,200,30);
        existacc.setFont(new Font("Arial",Font.BOLD,20));
        add(existacc);

        //existence radio
        eyesRadioButton = new JRadioButton("Yes");
        eyesRadioButton.setBounds(300,540,120,30);
        eyesRadioButton.setBackground(Color.white);
        add(eyesRadioButton);

        enoRadioButton = new JRadioButton("No");
        enoRadioButton.setBounds(450,540,120,30);
        enoRadioButton.setBackground(Color.white);
        add(enoRadioButton);

        ButtonGroup existaccButtonGroup = new ButtonGroup();
        existaccButtonGroup.add(eyesRadioButton);
        existaccButtonGroup.add(enoRadioButton);

        //next button
        next = new JButton("NEXT");
        next.setBounds(550,640,100,30);
        next.setFont(new Font("Arial",Font.BOLD,20));
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setLayout(null);
        setTitle("Additional Details PAge No. 2");
        setSize(800,800);
        setVisible(true);
        setLocation(350,10);
    }

    public void actionPerformed(ActionEvent ae) {
        
        String religion = (String)religionCombobox.getSelectedItem();
        String category = (String)categorycombobox.getSelectedItem();
        String income = (String)incomecombobox.getSelectedItem();
        String educational = (String)educationalcombobox.getSelectedItem();
        String occupation = (String)occupationcombobox.getSelectedItem();
        String pan = panTextField.getText();
        String adhar = adharTextField.getText();
        String senior = null;
        if(syesRadioButton.isSelected()){
            senior = "Yes";
        }
        else if(snoRadioButton.isSelected()){
            senior = "No";
        }
        String existing = null;
        if(eyesRadioButton.isSelected()){
            existing = "Yes";
        }
        else if(enoRadioButton.isSelected()){
            existing = "No";
        }
    
        
        try{
            Conn con = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+educational+"','"+occupation+"','"+pan+"','"+adhar+"','"+senior+"','"+existing+"')";
            con.st.executeUpdate(query);

            //signup3
            setVisible(false);
            new Signupthree(formno).setVisible(true);
        }
    catch(Exception e){
        System.out.println(e);
    }
    }
    
    public static void main(String[] args) {
        new Signuptwo("");
    }

    
}
