import java.util.Scanner;
import java.io.*;

class Paper
{
	private int courseID;
	private short stdRoll;
	private char stdGender;
	private String stdName;
	private String stdCourse;
	private String resultStatus;
	private byte stdMarks;
	private boolean stdType;
	private String resDescription;
	
	
	public Paper(int cID)
	{
		courseID = cID;
		stdRoll = 0000;
		stdGender = 'M';
		stdName = "STUDENT NAME";
		stdCourse = "MCA";
		resultStatus = "FAIL/PASS";
		stdMarks = 77;
		stdType = false;
		resDescription = "NULL";
	}
	
	public Paper()
	{
		courseID = 1234;
		stdRoll = 246;
		stdGender = 'M';
		stdName = "STUDENT NAME";
		stdCourse = "MCA";
		resultStatus = "FAIL/PASS";
		stdMarks = 77;
		stdType = false;
		resDescription = "NULL";
	}
	
	public void read() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("----Enter paper details----");
		System.out.println("Enter course  ID:	");
		courseID = Integer.parseInt(br.readLine());
		System.out.println("Enter roll  No:	");
		stdRoll = Short.parseShort(br.readLine());
		System.out.println("Enter student Gender (M/F/O):	");
		stdGender = (char)br.read();
		br.readLine();
		System.out.println("Enter name of Student:	");
		stdName = br.readLine();
		System.out.println("Enter paper course:	");
		stdCourse = br.readLine();
		System.out.println("Enter result Status:	");
		resultStatus = br.readLine();
		System.out.println("Enter marks Percentage:	");
		stdMarks = Byte.parseByte(br.readLine());
		System.out.println("Is he/She a Regular Student ?(true/false):	");
		stdType = Boolean.parseBoolean(br.readLine());
		System.out.println("Enter Result Description :	");
		resDescription = br.readLine();
	}
	
	public void display()
	{
		System.out.println("--------Paper details---------");
		System.out.println("Course ID:	"+courseID);
		System.out.println("Student ROll NO :	"+stdRoll);
		System.out.println("Student Gender:	"+stdGender);
		System.out.println("Student Name :	"+stdName);
		System.out.println("Course :	"+stdCourse);
		System.out.println("Result Status:	"+resultStatus);
		/*System.out.println("Percentege Obtained :	"+stdMarks+"%");
		if(stdType = true)
		{
			System.out.println("Student Type :	"+ "Regular Student");
		}
		else
		{
			System.out.println("Student Type :	" + "Distance Student " );
		}*/
		
		System.out.println("Result Description :	"+resDescription);
	}
	
	public void display(String facultyName, String facultyPass)
	{
		System.out.println("------------  Student Details -------------");
		System.out.println("Course ID:	"+courseID);
		System.out.println("Student ROll NO :	"+stdRoll);
		System.out.println("Student Gender:	"+stdGender);
		System.out.println("Student Name :	"+stdName);
		System.out.println("Course :	"+stdCourse);
		System.out.println("Result Status:	"+resultStatus);
		System.out.println("Percentege Obtained :	"+stdMarks+"%");
		if(stdType = true)
		{
			System.out.println("Student Type :	"+ "Regular Student");
		}
		else
		{
			System.out.println("Student Type :	" + "Distance Student " );
		}
		
		System.out.println("Result Description :	"+resDescription);
	

		
		
	}
}

public class Exam
{
	public static void main(String []args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Paper obj = new Paper();
		boolean loop = true;
		boolean flag = true;
		String nam, pass;
		byte op;
		int validate = 0;
		while(loop)
		{
            System.out.println("*******Examinaton Mangemnt System*********");
			System.out.println("-----------Menu----------");
			System.out.println("Press 0 to See the Default Format of Report Card :");
			System.out.println("1. For Students");
			System.out.println("2. For Faculty");
			//System.out.println("3. Retrieve paper details by paper ID.");
			//System.out.println("4. Display paper details in a department.");
			System.out.println("3. Exit.");
			System.out.println("\n\nEnter your choice:	");
			op = Byte.parseByte(br.readLine());
			switch(op)
			{
				case 0:
				{

						obj.display();
						break;
				}
				case 1:
						System.out.println("Enter Roll NO :");
						validate = 1;
						obj.read();
						if(validate == 1 )
						{
							obj.display();
							break;
						}
						else 
						{
							System.out.println("*** INPUT DATA FIRST ******");
							break;
						}

				case 2:
						System.out.println("Enter Faculty Id :");
						nam = br.readLine();
						System.out.println("Enter Password :");
						pass = br.readLine();
						validate = 1;
						obj.read();
						if(validate == 1 )
						{
							obj.display(nam, pass);
							break;
						}
						else 
						{
							System.out.println("*** INPUT DATA FIRST ******");
							break;
						}
						
				/*case 3:
						Paper  obj1 = new Paper(12);
						obj1.display();
						break;
				case 4:
						obj.display("Computer Science");
						break;*/

				
				case 3:
						loop = false;
						System.out.println("\n\nProgram is exiting...");
			}
		}
	}
}