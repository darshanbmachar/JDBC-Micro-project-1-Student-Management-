import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class addStudent {
    public void add(){
        Connection con = null;
        PreparedStatement ptst = null;
        Scanner sc = new Scanner(System.in);
        try {
            //loading the driveres
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Establishing connection

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school" ,"root" , "Darshan@708");

            //create mideum
            String sql = "insert into student values (?,?,?,?)";
            ptst = con.prepareStatement(sql);
            System.out.println("Enter a studnt ID");
            int id = sc.nextInt();
            System.out.println("Enter a student name");
            String name = sc.next();
            System.out.println("Enter a student age");
            int age = sc.nextInt();
            System.out.println("Enter a student class");
            String Stuclass = sc.next();

            ptst.setInt(1,id);
            ptst.setString(2,name);
            ptst.setInt(3,age);
            ptst.setString(4,Stuclass);

            int NOC = ptst.executeUpdate();
            System.out.println(NOC+" is inserted");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
                ptst.close();
                sc.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
