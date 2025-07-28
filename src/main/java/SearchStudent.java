import java.sql.*;
import java.util.Scanner;

public class SearchStudent {

    public void search(){
        Connection con = null;
        Statement stmt = null;
        PreparedStatement ptst= null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/school" ,"root" , "Darshan@708");
            String sql = "Select * from student where id = ?";
            ptst = con.prepareStatement(sql);
            System.out.println("Enter a student id which you need to search");
            int Id = sc.nextInt();
            ptst.setInt(1,Id);

            rs = ptst.executeQuery();

            if(rs.next()){
                System.out.println("ID: "+ rs.getInt("id"));
                System.out.println("Name: "+rs.getString("name"));
                System.out.println("age: "+rs.getInt("age"));
                System.out.println("Class: "+rs.getString("class"));
            }
            else{
                System.out.println("Student not found");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
