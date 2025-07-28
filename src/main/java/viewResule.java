import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class viewResule {

    public void result() {
        Connection con = null;
        PreparedStatement ptst = null;
        Scanner sc = new Scanner(System.in);
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school" , "root" , "Darshan@708");

            String sql = "SELECT \n" +
                    "    s.id, \n" +
                    "    s.name, \n" +
                    "    s.class, \n" +
                    "    m.math, \n" +
                    "    m.science, \n" +
                    "    m.english, \n" +
                    "    m.social,\n" +
                    "    (m.math + m.science + m.english + m.social) AS total_marks\n" +
                    "FROM \n" +
                    "    Student s\n" +
                    "JOIN \n" +
                    "    Marks m ON s.id = m.student_id\n" +
                    "WHERE \n" +
                    "    s.id = ?";
            ptst = con.prepareStatement(sql);
            System.out.println("Enter a student id");
            int id = sc.nextInt();
            ptst.setInt(1,id);
            rs=ptst.executeQuery();

            if(rs.next()){
                System.out.println("ID: "+ rs.getInt("id"));
                System.out.println("Name: "+rs.getString("name"));
                System.out.println("Class: "+rs.getString("class"));
                System.out.println("Math: "+rs.getInt("math"));
                System.out.println("Science: "+rs.getInt("science"));
                System.out.println("English: "+rs.getInt("english"));
                System.out.println("Social: "+rs.getInt("social"));
                System.out.println("Total: "+rs.getInt("total_marks"));
            }
            else{
                System.out.println("Student not found");
            }
        }catch (Exception e) {
            e.printStackTrace();

        }finally {
            try{
                ptst.close();
                sc.close();
                rs.close();
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
