import java.io.*;
import java.util.Scanner;

/* PROGRAM 3
    
PROGRAM TO IMPLEMENT USAGE OF THE KEYWORDS THIS AND SUPER.

1. Design a three level inheritance program.
2. Implement any three uses of this keyword.
3. Implement any three uses of super keyword.



==  byte    1 byte  -128 to 127
==  short   2 bytes -32,768 to 32,767
==  int 4 bytes -2,147,483,648 to 2,147,483, 647
==  long    8 bytes -9,223,372,036,854,775,808 to 
    9,223,372,036,854,775,807
==  float   4 bytes approximately ±3.40282347E+38F 
    (6-7 significant decimal digits) 
==  Java implements IEEE 754 standard
==  double  8 bytes approximately ±1.79769313486231570E+308
    (15 significant decimal digits)
==  char    2 byte  0 to 65,536 (unsigned)
    boolean not precisely defined*  true or false
*/

class Investment{
    static byte id = 0;
    byte stdId;
    boolean holosticpassed;
    String stdName;
    Short yearValid;

    void getData()throws IOException
    {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stdId = id;
        System.out.println("Is the Student passed Holistic Education Exam ? ");
        holosticpassed = Boolean.parseBoolean(br.readLine());
        //sc.nextLine();
        System.out.println("Name of Student ? ");
        stdName = br.readLine();
       // sc.nextLine();
        System.out.println("Registration Id ");
        yearValid = Short.parseShort(br.readLine());
        System.out.println("");
        //sc.close();

    }

    void putData()throws IOException
    {
        System.out.println("________________________________________");
        System.out.println("");
        System.out.println("S.No : "+stdId);
        System.out.println("Name : "+stdName);
        System.out.println("Registration Id  : "+yearValid);
    }
    Investment()
    {
        id ++;
        stdId = -1;
        holosticpassed = false;
        stdName = "NONE ASSIGNED";
    }


}

class exam extends Investment{
    byte stdId;

    exam()
    {
        super();
        this.stdId = -1;
    }

    void getData()
    {
        try{
        super.getData();
        //Scanner sc = new Scanner(System.in);
        this.stdId = super.stdId; 
    }
    catch(Exception e)
    {
        System.out.println(e.toString());// e.printStack() it converts the error into String.           
    }
    }

    void putData()
    {
        try{
        super.putData();  
        
    }
    catch(Exception e)
    {
        System.out.println(e.toString());// e.printStack() it converts the error into String.           
    }
    }

    void shareCapital()
    {
        System.out.println("YOU ELIGIBLE FOR EXAM \n\nYOUR HALL TICKET WILL BE MAILED YOU SHORTLY");
    }

} 

class hallTicket extends exam{
    Double classTotal;
    Long classAttended;
    Double attendPercent;

    hallTicket()
    {
        super();
        classAttended = 0L;
    }

    hallTicket(Double classTotal)
    {
        this();
        this.classTotal = classTotal;
    }

    void putData()
    {
        super.putData();
        //System.out.println("Cash Amount Paid: "+this.classTotal);
        //System.out.println("Advance Paid: "+this.classAttended);
    }

    void getData()
    {
        try
        {
        super.getData();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
        System.out.println("Class Attended ");
       // classTotal = sc.nextDouble();
        classTotal = Double.parseDouble(br.readLine());
        System.out.println("Yellow Form for Leave");
        classAttended = Long.parseLong(br.readLine());
    }
    catch(Exception e)
    {
        System.out.println(e.toString());// e.printStack() it converts the error into String.           
    }
    }

    void amountInterest(Long attendPercent)
    {
        this.attendPercent = ((classTotal+classAttended)/400);
        this.attendPercent = this.attendPercent*100;
        System.out.println("Attendence Percentage = "+this.attendPercent);
        super.shareCapital();
    }

}

class thisAndSuperKeywords
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean loop = true;
        byte ch;
        Long tempAmount;
        hallTicket ci = new hallTicket(50000D);
        while(loop)
        {
            System.out.println("");
            System.out.println("");
            System.out.println("+++ EXAM MANAGEMENT SYSTEM +++");
            System.out.println("1. Enter Data");
            System.out.println("2. Get Data");
            System.out.println("3. Check For Hall Ticket ");
            System.out.println("4. Exit");
            System.out.println("");
            System.out.println("Please enter a choice (1-3)");
            ch = Byte.parseByte(br.readLine());
            switch(ch)
            {
             case 1:
             {
                 ci.getData();
                 break;
             }
             case 2:
             {
                 ci.putData();
                 break;
             }
             case 3:
             {
                 //Scanner sc = new Scanner(System.in);
                 System.out.println("Please enter the  NO of Classes ");

                 tempAmount = Long.parseLong(br.readLine());
    
                 ci.amountInterest(tempAmount);
                 break;
             }
             case 4:
             {
                 loop = false;
                 break;
             }
             }
        }
    }
}
