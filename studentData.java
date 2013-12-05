import java.util.Scanner;
import java.io.*;
public class studentData {
	private String [] studentName;

	public void loadStudents() {
		String csvFile = "class.csv";
		BufferedReader in = null;
		String line = "";
		String csvSplitBy = ",";

		try {
			in = new BufferedReader(new FileReader(csvFile));
			while ((line = in.readLine()) != null) {
 
		        	// use comma as separator
				studentName = line.split(csvSplitBy);
				System.out.println(studentName.length + " Students are in the AP Comp Sci class. ");
			}
		}
		catch (FileNotFoundException e) {
		e.printStackTrace(); } 
		catch (IOException e) {
		e.printStackTrace(); }
		finally {
			if (in != null) {
				try {
					in.close(); }
				catch (IOException e) {
				e.printStackTrace();
				}
			}
		}
	}
	public String getStudent() {
		int rand = (int)(Math.random()*(studentName.length));
		return studentName[rand];
	}
	public int studentNumber(){
		return studentName.length;
	}
	public void groupStudents(int x){
	String [] shuffledStudents = (String[])studentName.clone();
	int noOfGroups = shuffledStudents.length/x;
	int groupsPlusOne = 0;
	if (shuffledStudents.length%x > 0) {
		groupsPlusOne = shuffledStudents.length%x;
		System.out.println("Number of Groups = "+noOfGroups+" Groups that need one more "+ groupsPlusOne);	
	}
	String tempName;
	for (int i=shuffledStudents.length-1;i>=0;i--) {
		int rand = (int)(Math.random()*(i+1));
		tempName = shuffledStudents[i];
		shuffledStudents[i] = shuffledStudents[rand];
		shuffledStudents[rand] = tempName;
	}
	int arrayCounter = 0;
	System.out.println();
	for (int i = 1; i <=noOfGroups; i++) {
		System.out.print(" Group "+ i+ " " );
		int t=0;
			if (i <=groupsPlusOne) {
				t=x+1;
			}
				else {
				t=x;
				}
		for (int j = 1;j <= t ;j++) {
			System.out.print(shuffledStudents[arrayCounter]);
			arrayCounter++;
			if (i <=noOfGroups && j< t) {
				System.out.print(", ");
			}
		}
	System.out.println();	
	}
	}
}