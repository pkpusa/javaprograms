import java.io.*;
import java.util.*;

class student implements Serializable
{
	public int sno = 1;
	public String name;
	public int regno;
	public float mark1, mark2, mark3,total;
	
	public void read()throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Student Name");
		name = br.readLine();
		System.out.println("Enter Registration No");
		regno = Integer.parseInt(br.readLine());
		System.out.println("Enter Subject 1 Marks");
		mark1 = Float.parseFloat(br.readLine());
		System.out.println("Enter Subject 2 Marks");
		mark2 = Float.parseFloat(br.readLine());
		System.out.println("Enter Subject 3 Marks");
		mark3 = Float.parseFloat(br.readLine());
	
	}	
	
	public void display()throws IOException
	{
		sno = sno++;
		total = mark1 + mark2 + mark3;
		System.out.println(regno+"	"+name+"	"+mark1+"	"+mark2+"	"+mark3+"	"+total);
	}
	
	public void dispdes()throws IOException
	{
		//sno = sno++;
		total = mark1 + mark2 + mark3;
		
		//System.out.println(regno+"	"+name+"	"+mark1+"	"+mark2+"	"+mark3+"	"+total);
	}
	
}


public class serilizable
{
	public static void main(String[]args)throws IOException
	{
		int option;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean loop = true;
		student[] obj = new student[5];
		while(loop)
		{
		System.out.println("1.Press 1 to Enter Student Details ");
		System.out.println("2.Press 2 to Show Student Details");
		System.out.println("3.Press 3 to show marks in Decending Order");
		System.out.println("Press 4 to Exit");
		
		option = Integer.parseInt(br.readLine());
		
		
		switch(option)
		{
			case 1:
				try
				{
					
					FileOutputStream f1 = new FileOutputStream("std.txt");
					ObjectOutputStream o1 = new ObjectOutputStream(f1);
				
					for( int i = 0; i < 5; i++)
					{
						obj[i] = new student();
						obj[i].read();
					
						o1.writeObject(obj[i]);
					
					}
				
				}
				catch(Exception e)
				{
					
				}
				
			break;
			case 2:
				try
				{
					System.out.println("RegNO	Name 	Sub1	Sub2	Sub3	Total");
					System.out.println("==============================================");
					student[] obj2 = new student[5];
					FileInputStream f3 = new FileInputStream("std.txt");
					//ileInputStream f2 = new FileIntputStream("std.txt");
					//ObjectIntputStream o2 = new ObjectIntputStream(f2);
					ObjectInputStream o2 = new ObjectInputStream(f3);
				
					for( int i = 0; i < 5; i++)
					{
						//student[i] obj = new student();
						//obj2[i].read();
					
						//o1.writeObject(obj[i]);
						
						obj2[i] = (student)o2.readObject();
						
						obj2[i].display();
					}
				
				}
				catch(Exception e)
				{
					
				}
				break;
				case 3:
				
					try{
						
					System.out.println("RegNO	Name 	Sub1	Sub2	Sub3	Total");
					System.out.println("==============================================");
					student[] obj2 = new student[5];
					student[] temp = new student[5];
					FileInputStream f3 = new FileInputStream("std.txt");
					//ileInputStream f2 = new FileIntputStream("std.txt");
					//ObjectIntputStream o2 = new ObjectIntputStream(f2);
					ObjectInputStream o2 = new ObjectInputStream(f3);
				
					for( int i = 0; i< 5; i++)
					{
						
						for(i = i+1; i<5; i ++)
						{
							obj2[i] = (student)o2.readObject();
							if(obj2[i].total >obj2[i+1].total)
							{
							temp[i] = obj2[i];
							obj2[i] = obj2[i+1];
							obj2[i+1] = temp[i];
							obj2.display();
							//System.out.println(obj2[i].name+"	"+obj2[i].total);
							}
							
						else
						{
							
							
							//student[i] obj = new student();
						//obj2[i].read();
						
						//o1.writeObject(obj[i]);
						
						/*obj2[i] = (student)o2.readObject();
						System.out.println(obj2[i].name+"	"+obj2[i].total);
						obj2[i].dispdes();
						if(obj2[i].total >obj2[i+1].total)
						{
							temp[i] = obj2[i];
							obj2[i] = obj2[i+1];
							obj2[i+1] = temp[i];
							System.out.println(obj2[i].name+"	"+obj2[i].total);
						}*/
						
						
						}
					}
					
					}
					
					}
					catch(Exception e)
					{
						
					}
					break;
				case 4:
				
					loop = false;
				
		}
		
		}
	}
		
				
					
}	