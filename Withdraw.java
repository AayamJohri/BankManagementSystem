import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    JButton withdraw,back;
    JTextField amount;
    String pinnumber;
    Withdraw(String pinnumber){
        this.pinnumber=pinnumber;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);

        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("Enter the amount you want to Withdraw:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount=new JTextField();
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,485,150,30);
        image.add(withdraw);
        withdraw.addActionListener(this);

        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        image.add(back);
        back.addActionListener(this);

        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==withdraw){
            String number=amount.getText();
            Date date=new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withdraw");
            }else {
                try {
                    Conn conn=new Conn();

                    String query="insert into bank values('"+pinnumber+"','"+date+"', 'Withdraw','"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }

            }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Withdraw("");
    }
}
