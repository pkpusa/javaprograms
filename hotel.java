import java.util.Scanner;
import java.io.*;

class Customer		// class customer using buffer reader method of input
{
	private String custName;
	private long custAccNo;
	private byte custAge;
	private short custMinBal;
	//private float custBalance;
	private char custGender;
	private boolean custPan;
	private int custPhone;
	private int gst;
	
	
	public void read()throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the customer name:	");
		custName=br.readLine();
		System.out.println("Enter the Booking ID ");
		custAccNo=Long.parseLong(br.readLine());
		do{
			
		System.out.println("Enter the customer age:  ");
		custAge=Byte.parseByte(br.readLine());
		}while(custAge < 18);		// Relational Operators 
		
			
		System.out.println("Enter the Paid Amount :  ");
		custMinBal=Short.parseShort(br.readLine());

		int i = (custMinBal + (custMinBal*(10/100)));
		gst = i;	//Use of Operators
		
		System.out.println("Enter customer gender:   ");
		custGender=(char)br.read(); 
		br.readLine();
		System.out.println("Married/ Umarried \nEnter 1 for Yes, 0 for No :");
		custPan=Boolean.parseBoolean(br.readLine());
		System.out.println("Enter the customer phone no:	");
		custPhone=Integer.parseInt(br.readLine());
	}
	public void display()
	{
		System.out.println("Customer Name:	"+custName);
		System.out.println("Customer Booking Id :	"+custAccNo);
		System.out.println("Customer age:	"+custAge);
		System.out.println("Client Room Charges:	"+custMinBal);
		System.out.println("Bill After Tax & Services :	"+ gst);
		System.out.println("Customer Gender:	"+custGender);
		System.out.println("Matrial Status :	"+custPan);
		System.out.println("Customer Phone number:	"+custPhone);
	}

}


class Employee			// Class Employee using scanner input method

{
	private String empName;
	private long empId;
	private byte empAge;
	private short custMinBal;
	private float empSalary;
	private char empGender;
	private boolean empType;
	private int empPhone;
	
	
	public void input()throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Name : 	");
		empName = sc.nextLine();
		System.out.println("Enter the Employee ID ");
		empId = sc.nextLong();
		System.out.println("Enter the Employee age:  ");
		empAge = sc.nextByte();
		System.out.println("Enter the Salary of Employee :  ");
		empSalary =  sc.nextFloat();
		System.out.println("Enter Employee gender:   ");
		empGender = sc.next().charAt(0);
		System.out.println("Employee Type Permenant/ Daily wage \nEnter 1 for Permenant , 0 for No :");
		empType = sc.nextBoolean();
		System.out.println("Enter the EMployee phone no:	");
		empPhone = sc.nextInt();
		
	}
	public void show()
	{
		System.out.println("Employee  Name:	"+empName);
		System.out.println("Employee ID :	"+ empId);
		System.out.println("Employee age:	"+empAge);
		//System.out.println("Customer minimum Balance:	"+custMinBal);
		System.out.println("Employee Salary :	"+empSalary);
		System.out.println("Employee  Gender:	"+empGender);
		System.out.println("Employee Type:	"+empType);
		System.out.println("Employee Phone number:	"+empPhone);
	}

}
public class hotel		// main class Hotel, 
{
	public final static void clearConsole()
	{
    try
    {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows"))
        {
            Runtime.getRuntime().exec("cls");
        }
        else
        {
            Runtime.getRuntime().exec("clear");
        }
    }
    catch (final Exception e)
    {
        //  Handle any exceptions.
    }
	}
	public static void main(String []args) throws IOException
	{
		
		

		
		
		//Customer obj=new Customer();
		//obj.read();
		//obj.display();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		byte choice, c_choice,e_choice;
		//int minBalInfo=0;
		boolean loop=true;
		Customer [] obj=new Customer[1];
		Employee [] obj2=new Employee[1];

		//short bal=Short.parseShort(args[0]);

		//Customer obj=new Customer();
		restart:
		while(loop)
		{
			System.out.println("***************************************************");
			System.out.println("-----	HOTEL MANAGEMENT SYSTEM 	----\n\n");
			System.out.println("***************************************************");
			System.out.println("1.For Client");
			System.out.println("2.For Staffs");
			System.out.println("3.Exit ");
			System.out.println("Enter your choice:	");
			System.out.println("______________________________________________________");

			choice = Byte.parseByte(br.readLine());
			
			switch(choice)
			{
				case 1:
				{	
				
					while(loop)
					{
						clearConsole();
						//System("clear");
						System.out.println("1.Enter Client Details ");
						System.out.println("2.Display Clients");
						System.out.println("3.Back to Main Menu ");
						System.out.println("4.Exit");
						c_choice = Byte.parseByte(br.readLine());
					
						switch(c_choice)
						{
							case 1:
							{
								//obj.read();
								for(byte i=0;i<1;i++)
								{
									obj[i]=new Customer();
									obj[i].read();
								}
								break;
							}	
							case 2:
							{
								//obj.display();
								for(byte i=0;i<1;i++)
								{
									obj[i].display();
								}
								break;
							}
							case 3:
							{
								continue restart;
							}	
							case 4:
							{
								loop = false;
							}
						}
					
					}
				}
				
				case 2:
				{
					while(loop)
					{
						
						System.out.println("1.Enter Employee Details ");
						System.out.println("2.Display ");
						System.out.println("3.Back to Main Menu ");
						System.out.println("4.Exit");
					
						e_choice = Byte.parseByte(br.readLine());
					
						switch(e_choice)
						{
							case 1:
							{
								//obj.read();
								for(byte i=0;i<1;i++)
								{
									obj2[i]=new Employee();
									obj2[i].input();
								}
								break;
							}	
							case 2:
							{
								//obj.display();
								for(byte i=0;i<1;i++)
								{
									obj2[i].show();	
								}
								break;
							}
							case 3:
							{
								continue restart;
							
							}
							case 4:
							{
							loop = false;
							}
						}
					
					}
				}
				
				
				case 3:
				{
					loop = false;
				}
				
			}	
		
		}
		
	}
	
}



					
							
			






