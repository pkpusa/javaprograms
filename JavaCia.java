import java.util.*;
import java.io.*;

class Student implements Serializable
{
	private String name;
	public double regNo;
	private double marks0;
	private double marks1;
	private double marks2;
	public int slNo;
	public double total;
	
	
	public void read() throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter name:");
		name = br.readLine();
		System.out.println("-------------------------------");
		
		System.out.println("Enter registration number:");
		regNo = Double.parseDouble(br.readLine());
		System.out.println("-------------------------------");
		
		System.out.println("Enter marks1:");
		marks0 = Double.parseDouble(br.readLine());
		System.out.println("-------------------------------");
		
		System.out.println("Enter marks2:");
		marks1 = Double.parseDouble(br.readLine());
		System.out.println("-------------------------------");
		
		System.out.println("Enter marks3:");
		marks2 = Double.parseDouble(br.readLine());
		System.out.println("-------------------------------");
	}
	
	public void display() throws IOException
	{
		System.out.println(slNo+"		"+name+"		"+regNo+"		"+marks0+"		"+marks1+"		"+marks2);
	}
	
	public void totalCalculation() throws IOException
	{
		total = marks0+marks1+marks2;
	}
	
	public void output() throws IOException
	{
		System.out.println(slNo+"		"+name+"		"+regNo+"		"+marks0+"		"+marks1+"		"+marks2+"			"+total);
	}
}

class JavaCia
{
	public static void main(String args[]) throws IOException, Exception
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			boolean flag = true;
			Student obj[] = new Student[5];
			do
			{
				System.out.println("CHOOSE ONE:\n\n1. Enter data\n2. Display data\n3. Display output\n4. Exit\n\nYOUR CHOICE:");
				int choice = Integer.parseInt(br.readLine());
				switch(choice)
				{
					case 1:
					FileOutputStream fo = new FileOutputStream("student");
					ObjectOutputStream oo = new ObjectOutputStream(fo);
					for(int i = 0;i < 5;i++)
					{
						obj[i] = new Student();
						obj[i].read();
						oo.writeObject(obj[i]);
					}
					oo.close();
					break;
					case 2:
					System.out.println("--------------------------------------------\nSl. No		Name		Reg No		Marks1		Marks2		Marks3\n");
					for(int i = 0;i < 5;i++)
					{
						
						obj[i].slNo = i+1;
						obj[i].display();
						System.out.println("--------------------------------------------");
					}
					break;
					case 3:
					FileInputStream fi = new FileInputStream("student");
					ObjectInputStream oi = new ObjectInputStream(fi);
					Student obj1[] = new Student[5];
					for(int i= 0;i < 5;i++)
					{
						obj1[i] = (Student)oi.readObject();
						obj1[i].totalCalculation();
					}
					for(int a = 0;a < 5;a++)
					{
						for(int b = (a+1);b < 5;b++)
						{
							if(obj1[a].total < obj1[b].total)
							{
								Student x = new Student();
								x = obj1[a];
								obj1[a] = obj1[b];
								obj1[b] = x;
							}
							else if(obj1[a].total == obj1[b].total)
							{
								if(obj1[a].regNo > obj1[b].regNo)
								{
									Student x = new Student();
									x = obj1[a];
									obj1[a] = obj1[b];
									obj1[b] = x;
								}
							}
						}
					}
					System.out.println("--------------------------------------------\nSl. No		Name		Reg No		Marks1		Marks2		Marks3		Total Marks\n");
					for(int i= 0;i < 5;i++)	
					{
						
						obj1[i].slNo = i+1;
						obj1[i].output();
						System.out.println("--------------------------------------------");
					}
					break;
					case 4:
					flag = false;
					break;
					default:
					System.out.println("Invalid choice");
				}
			}while(flag);
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}