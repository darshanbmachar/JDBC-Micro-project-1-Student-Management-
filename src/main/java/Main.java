import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----------------------Student MAnagement System-------------------------");
        System.out.println("                       1.Search Student");
        System.out.println("                       2.add student");
        System.out.println("                       3.Add marks");
        System.out.println("                       4.View Result");
        System.out.println("                       5. Delete student");
        System.out.println("                   Select aboue option.........");
        int choose = sc.nextInt();
        SearchStudent searchStudent = new SearchStudent();
        addStudent addStu = new addStudent();
        viewResule view = new viewResule();
        InsertMarks insertmarks = new InsertMarks();
        switch (choose) {
            case 1-> searchStudent.search();
            case 2-> addStu.add();
            case 3-> insertmarks.insert();
            case 4-> view.result();
            case 5-> DeleteStudent.delete();
        }
    }
}
