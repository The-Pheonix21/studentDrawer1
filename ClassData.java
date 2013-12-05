import java.util.Scanner;
import java.io.*;

public class ClassData{
	studentData myClassData = new studentData();
	public static void main(String[] args) {
        ClassData runMenu = new ClassData();
        runMenu.classChoice();
        // System.out.println("\tYour current balance is " + myInquiry.getBalance());
	}
	public void classChoice (){
    // used ATMMachine code to set up menu
		myClassData.loadStudents();
 	 Scanner classRead = new Scanner(System.in);
        int selectMyItem = 0;
        String selectMyString;
        String cont;
     while (selectMyItem < 4) {
        System.out.println("\t====================================================");
        System.out.println("\tWelcome to this simple Class Program");
        System.out.println("\t====================================================");
        System.out.println();
        System.out.println("\tPlease select an option");
        System.out.println("\tPress [1] To get a Count of Students");
        System.out.println("\tPress [2] Randomly Draw a Name");
        System.out.println("\tPress [3] Group Students");
        System.out.println("\tPress [4] Exit");
                
        System.out.print(" What would you like to do? ");
        selectMyString = classRead.nextLine();
        selectMyItem = Integer.parseInt(selectMyString);
        if(selectMyItem>5)
            {
                System.out.println("\tPlease select correct number.");
            }  else{
                switch (selectMyItem)
                    {
                       case 1:
                        System.out.println("\n\tTotal number of students in class: "+ myClassData.studentNumber());
                        break;
                       case 2:
                        System.out.print("\n\tStudent name is: " + myClassData.getStudent());
                        System.out.println();
                        break;
                       case 3:
                        System.out.println();
                        System.out.println("Group students by:");
                        System.out.println("\tPress [2] to group by two.");
                        System.out.println("\tPress [3] to group by three.");
                        System.out.println("\tPress [4] to group by four.");
                        System.out.println("\tPress [5] to group by five.");
                        System.out.println("\tPress [6] to group by six.");
                        System.out.println("\tPress [7] to group by seven.");
                        System.out.println("\tPress [8] to group by four.");
                        System.out.println("\tPress [9] to group by five.");
                        System.out.print(" Group by what number? ");
                        String newGroup = classRead.nextLine();
                        int groupNo = Integer.parseInt(newGroup);
                        System.out.println(groupNo);
                        myClassData.groupStudents(groupNo);
                        break;
                        default:
                        System.out.print("\tProgram exited.");
                        break;
                                
                    }
                    if (selectMyItem < 4){
                    System.out.println("\n\n");
                    System.out.print("Would you like to select another option? Y or N - ");
                        cont = classRead.nextLine();
                        if (!cont.equalsIgnoreCase("Y"))
                            selectMyItem=4;
                    }
            }                
        }
 }
}