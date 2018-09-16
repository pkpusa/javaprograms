import java.util.Scanner;
import java.io.*;

class Sale
{
    public String stdName;
    public Float attendance;
    public byte remarks;
    public short yearofExam;
    public long rollNO;
    public Character gender;
    public String registrationNumber;
    public Boolean fines;
    public String department;
    public String course;

    public void read_Sale(String sample) throws IOException
    {   /*Reading data for class Sale */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //OR    Scanner sc = new Scanner(System.in);
        System.out.println("Student Name :");
        stdName = br.readLine();
        System.out.println("Attendance Percentage ");
        attendance = Float.parseFloat(br.readLine());
        System.out.println("Remarks (Scale of 1-10):");
        remarks = Byte.parseByte(br.readLine());
        System.out.println("Year of Birth :");
        yearofExam = Short.parseShort(br.readLine());
        System.out.println("Roll Number :");
        rollNO = Long.parseLong(br.readLine());
        System.out.println("Gender ('M' for male/ 'F' for female):");
        gender = (char)br.read();
        br.readLine();
       // System.out.println("Registration Number:");
        registrationNumber = sample;
        System.out.println("Repeat Exam ( Press 1 for Yes ");
        fines = Boolean.parseBoolean(br.readLine());
        System.out.println("Department:");
        department = br.readLine();
        System.out.println("Class :");
        course = br.readLine();
    }

    public void disp_Sale()
    {   /*Displaying data for class Sale */
        System.out.println("\nCondition is as below:\n");
        System.out.println("Student Name :"+ stdName);
        System.out.println("Attendance :"+ attendance);
        System.out.println("Remarks :"+ remarks);
        System.out.println("Year of Birth :"+ yearofExam);
        System.out.println("Roll Number :"+ rollNO);
        System.out.println("Gender "+ gender);
        System.out.println("Registration Number:"+ registrationNumber);
        System.out.println("Fines :"+ fines);
        System.out.println("Department:"+ department);
        System.out.println("Class :"+ course);
    }

    public void dep()
    {
        if(yearofExam>2000)
        {
            if(remarks<10 && remarks>=5)
            {
                if(rollNO != 0)
                {
                    System.out.println("\nYou are Eligible For Exam ");
                  //  System.out.println("\nEstimated Depreciation");
                  //  int cost = (((2018-yearofExam)*10000)-(remarks*10));
                  //  System.out.println(""+cost);
                }
            }
        } 
        else
        {
            System.out.println("\nSorry ! You are not eligible .");
        }
    }

    public void dep2()
    {
        if(yearofExam>2000)
        {
            if(remarks<10 && remarks>=5)
            {
                if(rollNO != 0)
                {
                    System.out.println("\nYou are Eligible for Exam");
                    System.out.println("\nEstimated Depreciation");
                    int cost = (((2018-yearofExam)*10000)-(remarks*10));
                    System.out.println(""+cost);
                }
            }
        } 
        else
        {
            System.out.println("\nSorry ! You are not Eligible.");
        }
    }

/*     public void read() throws IOException
    {
        Scanner sc=new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Cosmmetic Condition (Brief Description):");
        stdName = sc.next();
        System.out.println("Odometer Reading (Decimal Value):");
        attendance = sc.nextFloat();
        System.out.println("Tyre Condition (Scale of 1-10):");
        remarks = sc.nextByte();
        System.out.println("Year of Purchase:");
        yearofExam = sc.nextShort();
        System.out.println("Insurance Number:");
        rollNO = sc.nextLong();
        System.out.println("Battery Condition (Grade):");
        gender = sc.next().charAt(0);
        System.out.println("Registration Number:");
        registrationNumber = sc.nextInt();
        System.out.println("Mode of Payment (1/0 Cash or Card):");
        fines = Boolean.parseBoolean(br.readLine());
        System.out.println("department:");
        department = sc.next();
        System.out.println("course:");
        course = sc.next();

    } */
}

public class prog2
{
    public static void main (String [] args) throws IOException
        {   /*Main Body */
   //         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Scanner scanner = new Scanner(System.in);
            Sale obj1[] = new Sale[100];
            int option=0,i=1,validates=0;
 control:   while(i==1)
                {   /* Menu for the program */
                    System.out.println("\nPress 1 to use Buffer Reader,\n\n Press 2 to check if you are eligible for exam of Not ,\n\n Press 3 to calculate depreciation \n\nPress 4 to exit:");
                    do {
                        while (!scanner.hasNextInt()) {
                            String input = scanner.next();
                            System.out.printf("\"%s\" is not a valid number.\n", input);
                        }
                        option = scanner.nextInt();
                        if(option < 0)
                        {
                            System.out.printf("\"%d\" is not a valid number.\n", option);
                        }
                    } while (option < 0);
                    //option = Integer.parseInt(br.readLine());
                    switch(option)
                    {
                        case 1:
                        {
                             validates = 1;
                            for(int k=0;k< args.length;k++)
                            {
                                System.out.println("\nRead Here->");
                                String sam = args[k];
                                obj1[k] = new Sale();
                            obj1[k].read_Sale(sam);
                            }
                            System.out.println("\nDisplay Here->");
                            for(int k=0;k< args.length;k++)
                            {
                            obj1[k].disp_Sale();
                            }
/*                             if(obj1.yearofExam>1985)
                            {
                                if(obj1.remarks<10 && obj1.remarks>=5)
                                {
                                    if(obj1.rollNO != 0)
                                    {
                                        System.out.println("\nThis car can be purchased");
                                        System.out.println("\nEstimated Depreciation");
                                        int cost = (((2018-obj1.yearofExam)*10000)-(obj1.remarks*10));
                                        System.out.println(""+cost);
                                    }
                                }
                            } 
                            else
                            {
                                System.out.println("\nThis car cannot be purchased!");
                            }
                            */
                            break;
                        }
                        case 2:
                        {
                            if(validates==1)
                            {
                                for(int k=0;k< args.length;k++)
                                {
                                System.out.println("\nRead Here->");
                                obj1[k].dep();
                                }
                                break;
                            }
                            else{
                                System.out.println("\nInput data first!");
                                break;
                            }
                        }
                        case 3:
                        {
                            if(validates==1)
                            {
                            for(int k=0;k< args.length;k++)
                            {
                            System.out.println("\nRead Here->");
                            System.out.println("\nEstimated Depreciation:");
                            obj1[k].dep2();
                            }
                            break;
                        }
                        else{
                            System.out.println("\nInput data first!");
                            break;
                        }
                        }
                        case 4:
                        {
                            break control;
                        }
                        default:
                        {
                            break;
                        }
                    }
                }
            System.out.println("Thanks for using the system!");
        }
}