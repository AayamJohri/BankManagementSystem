
import java.sql.*;

class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try {

            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Ayam@1610");
            s= c.createStatement();

        }catch (Exception e){
            System.out.println(e);
        }

    }
}

