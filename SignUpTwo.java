import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignUpTwo extends JFrame implements ActionListener {

    JTextField panTextField,aadharTextField;

    JComboBox religion,category,income,education,occupation;
    JButton next;
    JRadioButton syes,sno,eyes,eno;

    String formNo;
    SignUpTwo(String formNo){
        this.formNo=formNo;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2:");

        JLabel additionalDetails=new JLabel("Page 2 Additional Details:");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String varReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        religion=new JComboBox(varReligion);
        religion.setBackground(Color.WHITE);
        religion.setBounds(300,140,400,30);
        add(religion);

        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        String varCategory[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox(varCategory);
        category.setBackground(Color.WHITE);
        category.setBounds(300,190,400,30);
        add(category);

        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String incomeCategory[]={"null","<1,50,000","2,50,000","<5,00,000","upto 10,00,000"};
        income=new JComboBox(incomeCategory);
        income.setBackground(Color.WHITE);
        income.setBounds(300,240,400,30);
        add(income);

        JLabel email=new JLabel("Educational:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,290,200,30);
        add(email);

        JLabel emails=new JLabel("Qualification:");
        emails.setFont(new Font("Raleway",Font.BOLD,20));
        emails.setBounds(100,315,200,30);
        add(emails);

        String educationValue[]={"Non-Graduate","Graduate","Post-Graduate","Doctrate","Other"};
        education=new JComboBox(educationValue);
        education.setBackground(Color.WHITE);
        education.setBounds(300,315,400,30);
        add(education);

        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,200,30);
        add(marital);

        String occupationValue[]={"Salaried","Self-Employed","Business","Retried","Student","Other"};
        occupation=new JComboBox(occupationValue);
        occupation.setBackground(Color.WHITE);
        occupation.setBounds(300,390,400,30);
        add(occupation);

        JLabel pan=new JLabel("PAN No.:");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100,440,200,30);
        add(pan);

        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300,440,400,30);
        add(panTextField);

        JLabel aadhar=new JLabel("Aadhar No.:");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100,490,200,30);
        add(aadhar);

        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300,490,400,30);
        add(aadharTextField);

        JLabel senior=new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,540,200,30);
        add(senior);

        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup marritalGroup=new ButtonGroup();
        marritalGroup.add(syes);
        marritalGroup.add(sno);

        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existGroup=new ButtonGroup();
        existGroup.add(eyes);
        existGroup.add(eno);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,630,80,30);
        add(next);
        next.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(750,720);
        setLocation(350,10);
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae) {

        String sreligion =(String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation=(String) education.getSelectedItem();
        String soccupation=(String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();


        try {
                Conn c = new Conn();
                String query = "insert into signuptwo value('" + formNo + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + saadhar + "', '" + seniorcitizen + "', '" + existingaccount + "' )";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignUpThree(formNo).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}
