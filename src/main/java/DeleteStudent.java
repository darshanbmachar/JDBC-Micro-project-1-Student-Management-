import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteStudent {
    public static void delete() {
        Connection con = null;
        PreparedStatement deleteMarksStmt = null;
        PreparedStatement deleteStudentStmt = null;
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "Darshan@708");

            System.out.print("Enter the student ID you want to delete: ");
            int id = sc.nextInt();

            // First delete from marks (child table)
            String deleteMarksSQL = "DELETE FROM marks WHERE student_id = ?";
            deleteMarksStmt = con.prepareStatement(deleteMarksSQL);
            deleteMarksStmt.setInt(1, id);
            deleteMarksStmt.executeUpdate();

            // Then delete from student (parent table)
            String deleteStudentSQL = "DELETE FROM student WHERE id = ?";
            deleteStudentStmt = con.prepareStatement(deleteStudentSQL);
            deleteStudentStmt.setInt(1, id);
            int affectedRows = deleteStudentStmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Student with ID " + id + " and their marks have been deleted successfully.");
            } else {
                System.out.println("No student found with ID " + id + ".");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                deleteMarksStmt.close();
                deleteStudentStmt.close();
                sc.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
