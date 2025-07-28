import java.lang.ref.PhantomReference;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertMarks {
    public void insert(){
        Connection con = null;
        PreparedStatement ptst = null;
        Scanner sc = new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school" ,"root" ,"Darshan@708");

            String sql = "insert into marks values(?,?,?,?,?)";
            ptst = con.prepareStatement(sql);
            System.out.println("Enter a student ID");
            int id = sc.nextInt();
            System.out.println("Enter marks for bellow subject");
            System.out.println("Maths:");
            int maths = sc.nextInt();
            System.out.println("Science");
            int science = sc.nextInt();
            System.out.println("English:");
            int english = sc.nextInt();
            System.out.println("Social:");
            int social = sc.nextInt();

            ptst.setInt(1,id);
            ptst.setInt(2,maths);
            ptst.setInt(3,science);
            ptst.setInt(4,english);
            ptst.setInt(5,social);


            int NOC=ptst.executeUpdate();
            System.out.println("Student " + id + " inserted " + NOC);


        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
                ptst.close();
                sc.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
