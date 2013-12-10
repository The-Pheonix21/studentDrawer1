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
	   String [] shuffledStudents =  (String[])studentName.clone();
    int noOfGroups = shuffledStudents.length/x;
    int groupsPlusOne = 0;
    int noToAdd = 0;
    boolean addGroup = false;
    if (shuffledStudents.length%x > 0) {
        groupsPlusOne = shuffledStudents.length%x;
         if (((double)(groupsPlusOne)/x)> .5){
            // System.out.println("groupsPlusOne/x = "+((double)(groupsPlusOne)/x));
             noOfGroups+=1;  
             addGroup = true; 
             groupsPlusOne = 0;
            }else if(((double)(groupsPlusOne)/x)< .5 && groupsPlusOne>0){
                noToAdd = groupsPlusOne/noOfGroups;
            }
         // System.out.println("No of Groups = "+noOfGroups+" Groups that need one more: "+ groupsPlusOne);
    }
      String tempName;
    for (int i = shuffledStudents.length-1; i >= 0; i--){
           int rand = (int)(Math.random()*(i+1));
            tempName = shuffledStudents[i];
            shuffledStudents[i] = shuffledStudents[rand];
            shuffledStudents[rand] = tempName;
    }
    int arrayCounter = 0;
    System.out.println();
   for (int i = 1; i <= noOfGroups; i++){
     System.out.print(" Group "+ i+ " " );
     int t = x+noToAdd;
     if (i == 1 && addGroup==false && groupsPlusOne > 0 && groupsPlusOne%noOfGroups > 0){
        t+=1;
     }
     
     for (int j = 1; j<= t; j++){
        if(arrayCounter < shuffledStudents.length){
            System.out.print(shuffledStudents[arrayCounter]);
            arrayCounter++;
            if (i<=noOfGroups && j< t && arrayCounter < shuffledStudents.length){
                System.out.print(", ");
            }   
        }
     }
     System.out.println();
   }
 }
}