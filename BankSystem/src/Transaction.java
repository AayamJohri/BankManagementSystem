import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction extends JFrame implements ActionListener {

    JButton deposit,withdraw,fastCash,miniStatement,pinChange,balanceEnquiry,exit;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw=new JButton("Cash Withdraw");
        withdraw.setBounds(355,415,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastCash=new JButton("Fast Cash");
        fastCash.setBounds(170,450,150,30);
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement=new JButton("Mini-Statement");
        miniStatement.setBounds(355,450,150,30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange=new JButton("Pin Change");
        pinChange.setBounds(170,485,150,30);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balanceEnquiry=new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355,485,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit=new JButton("Exit");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        //setUndecorated(true);//
        setVisible(true);


    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            System.exit(0);
        } else if (ae.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource()==withdraw) {
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }  else if (ae.getSource()==fastCash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource()==pinChange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if (ae.getSource()==balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource()==miniStatement) {

            new MiniStatement(pinnumber).setVisible(true);
        }


    }
    public static void main(String[] args) {
        new Transaction("");
    }
}
