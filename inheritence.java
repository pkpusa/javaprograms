import java.util.Scanner;
import java.io.*;

class User
{
	protected String userType;
    private int userPassword;

    public User()
    {
        userType = "Faculty";
        userPassword = 12345;
    }

    User(String userType)
    {
        this.userType = userType;
        userPassword = -1;
    }
    User(String type, int pwd)
    {
        this(type);
        userPassword = pwd;
	}
	
	public void read()
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        try
        {
            System.out.println("\t==Details==\nEnter the user type:	");
            userType = br.readLine();
            System.out.println("Enter the user Password:	");
            userPassword = Integer.parseInt(br.readLine()); 
        }
        catch(Exception e)
        {
            System.out.println(e.toString());// e.printStack() it converts the error into String.           
        }
    }
    public void Display()
    {
        System.out.println("\t==Details==\nUser Type:\t"+userType);
        System.out.println("User password:\t"+userPassword);
    }
}

class Faculty extends User
{
    private int facID;
    private String facDepartment;

    public Faculty()
    {
        facID = 1747247;
        facDepartment = "Computer Science";
    }
    Faculty(String userType, int facID, String facDepartment)
    {
        //Account new = new Account(name);// ***Constructor can not be inherited..*** 
        super(userType); 
        this.facID = facID;
        this.facDepartment = facDepartment;
    }
	
	public void read()
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            super.read();
            System.out.println("Enter the Faculty ID:	");
            facID  = Integer.parseInt(br.readLine()); 
            System.out.println("Enter the Faculty department"	);
            facDepartment = br.readLine(); 
        }
        catch(Exception e)
        {
            System.out.println(e.toString());// e.printStack() it converts the error into String.           
        }
    }
    public void Display()
    {
        super.Display();
        //System.out.println("cName");// ERROR, because cName is private. It cannot be accessed by another class. 
        System.out.println("Faculty ID:\t"+facID);
        System.out.println("Faculty Department:\t"+facDepartment);
    }
}

class Invigilator extends Faculty
{
    private byte invigDate;
    private short invigRoomNo;
    private String invigTime;

    public Invigilator()
    {
        invigDate = 12;
        invigRoomNo = 402;
        invigTime = "4:30 AM";
    }

    public Invigilator(String type, int fid, String fdept, byte idate, short iroom, String itime )
    {
        super(type, fid, fdept);
        invigDate = idate;
        invigRoomNo = iroom;
        invigTime = itime;
    }
	
	public void read()
    {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            super.read();
            System.out.println("Enter the Invigilation date:	");
            invigDate = Byte.parseByte(br.readLine()); 
            System.out.println("Enter the invigilation room number:	");
            invigRoomNo = Short.parseShort(br.readLine());
            System.out.println("Enter the Invigilation time:	");
            invigTime = br.readLine(); 
        }
        catch(Exception e)
        {
            System.out.println(e.toString());// e.printStack() it converts the error into String.           
        }
    }
    public void Display()
    {
        super.Display();
        //System.out.println("Customer name:\t"+cName);
        System.out.println("Invigilation date:\t"+invigDate);
        System.out.println("invigilation room number:\t"+invigRoomNo);
        System.out.println("Invigilation time:\t"+invigTime);
    }
}

public class inheritence
{
    public static void main( String []args) throws IOException
    {
		Invigilator obj = new Invigilator();
		obj.read();
		obj.Display();
    }
}