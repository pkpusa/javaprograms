import java.util.Scanner;
import java.io.*;

class Customer
{
	private String custName;
	private long custAccNo;
	private byte custAge;
	private short custMinBal;
	private float custBalance;
	private char custGender;
	private boolean custPan;
	private int custPhone;
	
	
	
	byte search(long acno)
		{
			if(custAccNo == acno)
			return 1;
		else 
			return 0;
		}

	byte search(String name)
	{
		if(custName == name)
		{
			return 1;
		}
		else{
			return 0;
		}
		
	}


	byte search(float balance, char gend)
		{ 
			if(custBalance >= balance && custGender == gend)
				return 1;

			else 

				return 0;
		}
	
	public Customer()
	{
		custName = "NA";
		custAccNo = 1000;
		custAge = 20;
		custMinBal = 1500;
		custBalance = 1500;
		custGender = 'm';
		custPan = true;
		custPhone = 91;
	}
	
	public Customer(String cname, long caccno)
	{
		custName = cname;
		custAccNo = caccno;
		custAge = 18;
		custMinBal = 1000;
	}
	public void read()throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the customer name:	");
		custName=br.readLine();
		/*System.out.println("Enter the customer account number:	");
		custAccNo=Long.parseLong(br.readLine());
		System.out.println("Enter the customer age:	");
		custAge=Byte.parseByte(br.readLine());
		System.out.println("Enter the minimum balance:	");
		custMinBal=Short.parseShort(br.readLine());
		System.out.println("Enter customer gender:	");
		custGender=(char)br.read(); 
		br.readLine();
		System.out.println("Enter customer Pan-card status:	");
		custPan=Boolean.parseBoolean(br.readLine());
		System.out.println("Enter the customer phone no:	");
		custPhone=Integer.parseInt(br.readLine());*/
	}
	public void display()
	{
		System.out.println("Customer Name:	"+custName);
		System.out.println("Customer Account number:	"+custAccNo);
		System.out.println("Customer age:	"+custAge);
		System.out.println("Customer minimum Balance:	"+custMinBal);
		System.out.println("Customer balance:	"+custBalance);
		System.out.println("Customer Gender:	"+custGender);
		System.out.println("Customer Pan status:	"+custPan);
		System.out.println("Customer Phone number:	"+custPhone);
	}

	public void minBalInfo(short m)throws IOException
	{
		if(custMinBal < m)
		{
			display();
		}
	}
}
public class Datatype
{
	public static void main(String []args) throws IOException
	{
		
		
		
		//Customer obj=new Customer();
		//obj.read();
		//obj.display();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		byte ch;
		int minBalInfo=0;
		boolean loop=true;
		Customer [] obj=new Customer[3];

		//short bal=Short.parseShort(args[0]);

		//Customer obj=new Customer();
		while(loop)
		{
			System.out.println("1.Read");
			System.out.println("2.Display");
			System.out.println("3.Min balance Info");
			System.out.println("Search");
			System.out.print("Exit");
			System.out.println("Enter your choice:	");

			ch=Byte.parseByte(br.readLine());

			switch(ch)
			{
				case 1:
						//obj.read();
						for(byte i=0;i<3;i++)
						{
							obj[i]=new Customer();
							obj[i].read();
						}
						break;
				case 2:
						//obj.display();
						for(byte i=0;i<3;i++)
						{
							obj[i].display();	
						}
						break;
				case 3:
						for(byte i=0;i<3;i++)
						{
							obj[i].minBalInfo(Short.parseShort(args[0]));//external casting
						}
						break;
						
				case 4:
				{
					long accountno;
					byte c1;
					System.out.println("Enter account no you want to search");
					accountno =Long.parseLong(br.readLine());
					
					
					for(byte i= 0; i < 3; i++)
					{
				       c1=obj[i].search(accountno);		
						if(c1 == 1)
						{
							System.out.println("Account  found");
							break;
						}
						else
						{
							System.out.print("Not Found");
							break;
						}
					}	
					
				}
				case 5:
					{
						//loop=false;
						
						String name;
						byte c2;
						
						System.out.println("Enter a name to search ");
						name = br.readLine();
						for(byte i = 0; i < 3; i++)
						{
							c2 = obj[i].search(name);
							if(c2 == 1)
							{
								System.out.println("Account  found");
								break;
							}
							else
							{
								System.out.println("NOt found");
								break;
							}
	
								
							
						}	
						
						
						
						
					}
			}
		} 
		//Customer obj = new Customer("stupid", 1000090);
		//Customer obj = new Customer();
		//obj.display();
	}
}







