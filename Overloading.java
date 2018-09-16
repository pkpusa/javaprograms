4import java.util.Scanner;
import java.io.*;

class Paper
{
	private int paperID;
	private short paperExamID;
	private char paperStream;
	private String paperDepartment;
	private String paperCourse;
	private String paperName;
	private byte paperTime;
	private boolean paperType;
	private String paperDescription;
	
	
	public Paper(int pID)
	{
		paperID = pID;
		paperExamID = 1234;
		paperStream = 'S';
		paperDepartment = "Computer science";
		paperCourse = "MCA";
		paperName = "JAVA";
		paperTime = 3;
		paperType = false;
		paperDescription = "NULL";
	}
	
	public Paper()
	{
		paperID = 11;
		paperExamID = 564;
		paperStream = 'S';
		paperDepartment = "Mathematics";
		paperCourse = "MSC Maths";
		paperName = "Graph Theory";
		paperTime = 2;
		paperType = true;
		paperDescription = "NULL";
	}
	
	public void read() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("----Enter paper details----");
		System.out.println("Enter paper ID:	");
		paperID = Integer.parseInt(br.readLine());
		System.out.println("Enter paper exam ID:	");
		paperExamID = Short.parseShort(br.readLine());
		System.out.println("Enter paper stream(A/C/S):	");
		paperStream = (char)br.read();
		br.readLine();
		System.out.println("Enter paper department:	");
		paperDepartment = br.readLine();
		System.out.println("Enter paper course:	");
		paperCourse = br.readLine();
		System.out.println("Enter paper Name:	");
		paperName = br.readLine();
		System.out.println("Enter paper time in hours:	");
		paperTime = Byte.parseByte(br.readLine());
		System.out.println("Is it a theory paper?(true/false):	");
		paperType = Boolean.parseBoolean(br.readLine());
		System.out.println("Enter paper description:	");
		paperDescription = br.readLine();
	}
	
	public void display()
	{
		System.out.println("--------Paper details---------");
		System.out.println("Paper ID:	"+paperID);
		System.out.println("Paper Exam ID:	"+paperExamID);
		System.out.println("Paper stream:	"+paperStream);
		System.out.println("Paper Department:	"+paperDepartment);
		System.out.println("Paper course:	"+paperCourse);
		System.out.println("Paper Name:	"+paperName);
		System.out.println("Paper time:	"+paperTime+" hours");
		System.out.println("Theory paper:	"+paperType);
		System.out.println("Paper description:	"+paperDescription);
	}
	
	public void display(String pDep)
	{
		if(pDep == "Computer Science")
			System.out.println("\n\n"+pDep+" has 6 papers");
		else if(pDep == "Mathematics")
			System.out.println("\n\n"+pDep+" has 5 papers");
	}
}

public class Overloading
{
	public static void main(String []args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Paper obj = new Paper();
		boolean loop = true;
		boolean flag = true;
		byte op;
		while(loop)
		{
			System.out.println("-----------Menu----------");
			System.out.println("1. Read paper details.");
			System.out.println("2. Display paper details.");
			System.out.println("3. Retrieve paper details by paper ID.");
			System.out.println("4. Display paper details in a department.");
			System.out.println("5. Exit.");
			System.out.println("\n\nEnter your choice:	");
			op = Byte.parseByte(br.readLine());
			switch(op)
			{
				case 1:
						obj.read();
						break;
				case 2:
						obj.display();
						break;
				case 3:
						Paper  obj1 = new Paper(12);
						obj1.display();
						break;
				case 4:
						obj.display("Computer Science");
						break;
				case 5:
						loop = false;
						System.out.println("\n\nProgram is exiting...");
			}
		}
	}
}