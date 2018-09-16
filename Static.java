import java.io.*;
import java.util.Scanner;

//import Exam.calculation;

//import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;

class Exam
{
	private short studentRoll;
	private String stdName;

	//-----------Static data members
	
	static String stdCourse;
	static float stdPaper1;
	static float stdPaper2;
	static float stdPaper3;
	static float total;
	static float percentage;
	static char Grade;
	static float attend;
	static float result;
	static float endSem;
	static int exDate;
	private int Date;


	
	static
	{
		exDate = 000;
	}
	
	public Exam()
	{
		exDate++;
		Date = exDate;
	}
	
	public static void show()
	{
		System.out.println("\nSerial No :	"+exDate);
	}
	
	static class entered
	{
		public void entry()
		{
			System.out.println("\nExamination details entered successfully.");
		}
	}
	
	public void read() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("--------Entering exam schedule for June----------");
		System.out.println("Enter Roll NO :	");
		studentRoll = Short.parseShort(br.readLine());
		/*System.out.println("Enter paper stream(A/C/S):	");
		exPaperStream = (char)br.read();
		br.readLine();
		System.out.println("Enter Student Name ");
		exPaperDepartment = br.readLine();*/
		System.out.println("Enter Student  Name:	");
		stdName = br.readLine();
		System.out.println("Enter Student Course :	");
		stdCourse = br.readLine();
		System.out.println("Enter CIA I Marks(Out of 20) ");
		stdPaper1 = Float.parseFloat(br.readLine());
		System.out.println("Enter CIA II (Mid Sem Out of 50) Marks ");
		stdPaper2 = Float.parseFloat(br.readLine());
		System.out.println("Enter CIA III Marks ( Out of 20) ");
		stdPaper3 = Float.parseFloat(br.readLine());
		System.out.println("Enter END SEM Marks (Out of 100)");
		endSem = Float.parseFloat(br.readLine());

		System.out.println("Enter Attendence of Student :");
		attend =  Float.parseFloat(br.readLine());

	}


	
	public static void resultcal()
	{

		result = (stdPaper1 + stdPaper2 + stdPaper3 + endSem);
		total =  result/ 2;
		if(attend > 95)
		{
			total = total + 5;
		}
		if(attend > 90 && attend < 95)
		{
			total = total + 4;

		}
		if(attend > 85 && attend < 90)
		{
			total = total + 3;
		}

		if(attend > 80 && attend < 85)
		{
			total =  total + 3;
		}
		else
		{
			total = total + 0;
		}
		
		percentage = total;

		if(percentage >=75)
		{
			Grade = 'A';
		}
		if(percentage > 60 && percentage < 75)
		{
			Grade = 'B';

		}
		if(percentage > 50 && percentage < 60)
		{
			Grade = 'C';

		}
		if(percentage > 45 && percentage < 50)
		{
			Grade = 'D';

		}

	}


	
	public void display()
	{
		System.out.println("============================================");
		System.out.println("\t\tCHRIST (Deemed to be University");
		System.out.println("-----   June Examination Result   -----");
		System.out.println("============================================");
		System.out.println("S No		:	"+"MCA00"+Date);
		System.out.println("Roll NO 	:	"+"17472"+studentRoll);
		//System.out.println("Exam paper Stream:	"+exPaperStream);
		//System.out.println("Exam paper Department:	"+exPaperDepartment);
		System.out.println("Name  		:	"+stdName);
		System.out.println("Course 		:	"+stdCourse);
		System.out.println("Marks		:	"+result);
		System.out.println("Percentage	:	"+percentage+"%");
		if(stdPaper1 < 10 || stdPaper2 < 20 || stdPaper3 < 10)
		{
			System.out.println("You are Fail");
		}
		else{

			System.out.println("Grade : "+Grade);
		}
	}
}

public class Static
{
	public static void main(String[] args) throws IOException
	{
		int records = 1;
		int validate = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Exam [] obj1 = new Exam[10];
		Exam obj2 = new Exam();
		Exam.entered obj3 = new Exam.entered();
		//Exam.calculation obj4 = new Exam.calculation();
		boolean loop = true;
		byte op;
		while(loop)
		{
			System.out.println("\n\n1.Read\n2.Display\n4.Exit");
			System.out.println("Enter your choice:	");
			op = Byte.parseByte(br.readLine());
			switch(op)
			{
				case 1:
						System.out.println("How Many Records You want to Enter");
						records = Integer.parseInt(br.readLine());
						while(records != 0)
						{
							for(byte i=0;i<records;i++)
							{
						  	obj1[i] = new Exam();
						  	obj1[i].read();
						  	obj3.entry();
							}
							validate = 1;
							break;
						}
						System.out.println("****INVALID INPUT*****");
						
						break;

				case 2:
						if(validate == 1)
						{
							for(byte i=0;i<records;i++)
							{
								Exam.resultcal();
								//obj4.resultcal();
						  		obj1[i].display();

							}
							break;

						}
						else 
						{
							System.out.println("**** INPUT DATA FIRST *******\n\n");
							break;
						}
						
				case 3:
						obj2.show();
						break;
				case 4:
						loop = false;
			}
		}
	}
}