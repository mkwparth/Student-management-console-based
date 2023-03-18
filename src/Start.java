import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start
{
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the Student Management application.");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("Press 1 for ADD student");
            System.out.println("Press 2 for DELETE student");
            System.out.println("Press 3 for DISPLAY student");
            System.out.println("press 4 for exit app");

            int c = Integer.parseInt(br.readLine());
            if(c==1){
                //add student
                System.out.println("Enter Your Name:");
                String name = br.readLine();

                System.out.println("enter phone no:");
                String phone= br.readLine();

                System.out.println("enter your city");
                String city= br.readLine();

//          create student object to store student data
                Student st = new Student(name,phone,city);
                System.out.println(st);

                boolean answer= StudentDao.insetStudentToDB(st);
                if(answer){
                    System.out.println("student Data added Successfully");
                }else{
                    System.out.println("Something Went Wrong");
                }

            } else if (c == 2) {
                System.out.println("Enter student Id");
                int userId = Integer.parseInt(br.readLine());



                //delete student
                boolean answer = StudentDao.deleteStudent(userId);
                if(answer){
                    System.out.println("student Data deleted Successfully");
                }else{
                    System.out.println("Something Went Wrong");
                }
            } else if (c == 3) {
                //display student

                StudentDao.showAllStudent();
            } else if (c == 4) {
                break;
            }else{
                System.out.println("Please enter valid input [1,2,3,4]");
            }

        }

        System.out.println("Thank You For using My application ");
    }
}
