
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

        JButton Login,SignUp,clear;
        JTextField CardTextField;
        JPasswordField PinTextField;
    Login(){
        setTitle("Automatic Tailor Machine");

        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text= new JLabel("Welcome to ATM ");
        add(text);
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);

        JLabel CardNo= new JLabel("Card No : ");
        add(CardNo);
        CardNo.setFont(new Font("Railway",Font.BOLD,28));
        CardNo.setBounds(120,150,150,30);

        CardTextField=new JTextField();
        CardTextField.setBounds(300,150,230,30);
        CardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(CardTextField);

        JLabel Pin= new JLabel("PIN :");
        add(Pin);
        Pin.setFont(new Font("Railway",Font.BOLD,28));

        Pin.setBounds(120,220,250,30);

        PinTextField=new JPasswordField();
        PinTextField.setBounds(300,220,230,30);
        PinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(PinTextField);

        Login=new JButton("SIGN IN");
        Login.setBounds(300,300,100,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        add(Login);
        Login.addActionListener(this);

        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);
        clear.addActionListener(this);

        SignUp=new JButton("SIGN UP");
        SignUp.setBounds(300,350,230,30);
        SignUp.setBackground(Color.BLACK);
        SignUp.setForeground(Color.WHITE);
        add(SignUp);
        SignUp.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==clear){
            CardTextField.setText("");
            PinTextField.setText("");
        } else if (ae.getSource()==Login) {
                Conn conn=new Conn();
                String cardnumber=CardTextField.getText();
                String pinnumber=PinTextField.getText();
                String query="select * from login where card_number = '"+cardnumber+"'and pin_number ='"+pinnumber+"'";

                try {
                    ResultSet rs=conn.s.executeQuery(query);
                    if (rs.next()){
                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);
                    }else {
                        JOptionPane.showMessageDialog(null,"Incorrect CardNo. or PIN");
                    }
                }catch (Exception e){
                    System.out.println(e);
                }


        } else if (ae.getSource()==SignUp) {
                setVisible(false);
                new SignUpOne().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login();

    }
}
