import java.util.*;
import java.io.*;

final class examRoutine
{
    final String date[] = {"12/07/2018","13/07/2018","16/07/2018","17/07/2018","18/07/2018"};
    final String paper[] = {"Java Theory", "Computer Architecture","Operating System","Software Engineering","Research Problem"};
    final String paperCode[] = {"MCA231","MCA234","MCA235","MCA236","MCA238"};
    
    public String data;

    /*public void read()throws IOException
    {
        
    }*/
    final void display(String data)throws IOException
    {
        System.out.println("Date        Subject Code        Paper\n");
        for(byte i =0; i < 5; i++)
        {

            if(date[i].equals(data))
            {
                System.out.println(date[i]+"    "+paperCode[i]+"    "+paper[i]);
                break;
            }
            
            
        }
        System.out.println("");

    }

    final void show()
    {
        System.out.println("Date        Subject Code        Paper\n");
        for(byte i =0; i < 5; i++)
        {
            System.out.println(date[i]+"    "+paperCode[i]+"    "+paper[i]);
        }
        System.out.println("");
    }


}


 abstract class student
{
    public int stuID;
    public String stdName;

    student()
    {
        stuID = 1747246;
        stdName = "Prakash Kumar";
    }


    public void read()throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Enter Your Roll No");
        stuID = Integer.parseInt(br.readLine());
        System.out.println("Enter Your Name");
        stdName = br.readLine();
    }

    public void display()throws IOException
    {
        System.out.println("=================================================");
        System.out.println("          Student Id   :" +stuID);
        System.out.println("          Student Name :" + stdName);
        //System.out.println("=================================================");
    }

    /* Declaration of abstract classes */

    //abstract float attendanceCal(float attendClass, float yellowForm, float medicalLeave);

    //abstract float fineCal();



}

 class examinee extends student
{
    final float totalclass;
    //private float attendClass;
    //private float yellowForm;
    //private float medicalLeave;
    public float attendencePercentage;
    public int abc;
    float fine =0;


    examinee()
    {
        
        totalclass = 400;
        //attendClass = 0;
        //yellowForm = 0;
        //medicalLeave = 0;
        abc = 0;
    }

    public void read()throws IOException
    {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            super.read();
           /* System.out.println("Enter No of Class Attended :    ");
            attendClass = Float.parseFloat(br.readLine());
            System.out.println("Enter No of Yellow Form :    ");
            yellowForm = Float.parseFloat(br.readLine());
            System.out.println("Enter No of Medical Leave :    ");
            medicalLeave = Float.parseFloat(br.readLine());*/


        }
        catch(Exception e)
        {
            System.out.println(e.toString());// e.printStack() it converts the error into String.           
        }
        
        
    }
    public void display()throws IOException
    {
    try
        {
            super.display();
        }
        catch(Exception e)
        {
            System.out.println(e.toString());// e.printStack() it converts the error into String.           
        }
    }


    public float attendanceCal(float attendClass, float yellowForm, float medicalLeave)
    {
        try
        {
            
            attendencePercentage = (attendClass + yellowForm)/totalclass;
            attendencePercentage = attendencePercentage*100;
            if(attendencePercentage>= 85)
            {
                super.display();
                System.out.println("Attendence  :   "+attendencePercentage+"%");
                System.out.println("=================================================");
                abc = 1;
                
            }
            else
            {
                abc = 0;
                
                System.out.println("==============================================");
                System.out.println("Attendence  :   "+attendencePercentage+"%");
                System.out.println("Your Hall Ticket is Blocked due to Low Attendence");
                System.out.println("Please Fill the Clearence Form");
                System.out.println("==============================================");
            }

            
            
            

        }
        catch(Exception e)
        {
            System.out.println(e.toString());// e.printStack() it converts the error into String.           
        }
        
        return attendencePercentage;
    }

    public void fineCal()
    {  
    
        
        if(attendencePercentage >= 85)
        {
            fine = 0;

        }
        if(attendencePercentage >= 80 && attendencePercentage < 85)
        {
            fine = 1000;
        }
        if(attendencePercentage >= 75 && attendencePercentage < 80)
        {
            fine = 2000;
        }
        if(attendencePercentage < 75)
        {
            fine = 5000;
        }
        //return fine;
    }
}

class exam extends examinee
{
    private String examName;
    private String paperName;
    float fine;
    private float attendence;


    exam()
    {
        examName = "MID -  SEM EXAMINATION";
        paperName ="4MCA";
        //super.intrestCalc();
        //this.fine = fine;
    }
   

    public void display()throws IOException
    {
        super.display();

    }
    
   // super.intrestCalc();
    /*public void display()
    {
        super.intrestCalc();
        System.out.println("Naam        Number");
        System.out.println(koiNaam+"    "+koivalue);
        
    }*/

    public void Clearence()throws IOException
    {

        
        attendence = super.attendencePercentage;
        super.fineCal();

        if(fine == 2000f)
        {
            System.out.println("Your fine Amount is Rs 2000.00 /-");
        }
        else if(fine == 1000f)
        
            System.out.println("Your fine Amount is Rs 1000.00 /-");
        else if(fine == 0)
        {
            System.out.println("fdfdshifhishisvisbd");
        }
        
        else
        
            System.out.print(" Sorry ! You are not Allowed to Give Exam ");
        

    }
}

class abstractkeyword
{
    public static void main(String []args)throws IOException
    {
        float attendClass;
        float yellowForm;
        float medicalLeave;
        String data;
        byte choice;
        examRoutine obj = new examRoutine();
        //student obj2 = new student();
        examinee obj3 = new examinee();
        boolean loop = true;
        int validate = 0;
        float fines;

        exam alldisp = new exam();

        alldisp.display();
        
        //obj.read();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(loop)
        {
        System.out.println("\n\n\t**Welcome User**");    
        System.out.println("1.Press 1 to See Examination Routine");
        System.out.println("2.Press 2 to Fill Student Details");
        System.out.println("3.Press 3 to Generate Hall Ticket");
        System.out.println("4.Press 4 to Exit");
        
        System.out.println("Enter Choice(1-4) :");
        choice = Byte.parseByte(br.readLine());

        switch(choice)
        {
            case 1:
            {
                System.out.println("enter date");
                data = br.readLine();
                obj.display(data);
                break;

            }

            case 2:
            {
                validate = 1;
                obj3.read();
                obj3.display();
                break;   

            }

            case 3:

            {
                if(validate == 1)
                {

                
                System.out.println("Enter No of Class Attended :    ");
                attendClass = Float.parseFloat(br.readLine());
                System.out.println("Enter No of Yellow Form :    ");
                yellowForm = Float.parseFloat(br.readLine());
                System.out.println("Enter No of Medical Leave :    ");
                medicalLeave = Float.parseFloat(br.readLine());
                System.out.println("===============================================");
                System.out.println("\tCHRIST (Deemed to be University )\n\tMid - Sem EXAMINATION");
                obj3.attendanceCal(attendClass,yellowForm,medicalLeave);
                obj3.fineCal();
                //alldisp.Clearence();
                if(obj3.fine == 2000)
                {
                    System.out.println("Please pay fine amount 3000 /-");
                    continue;
                }
                

                if(obj3.fine == 1000)
                {
                    System.out.println("Please pay Fine amount 1000 /-");
                    continue;
                }
                if(obj3.fine == 0)
                {
                    obj3.abc =1;
                    System.out.println("");
                    obj.show();
                    continue;

                }

                
                if(obj3.abc == 1)
                {
                    obj.show();
                    System.out.println("=============================================");
                    break;
                }
                
                
                }
                else{
                    System.out.print("INPUT DATA FIRST\n\n");
                    break;
                }

            }

            case 4:
            {
                loop = false;
            }
        }

    }
      

        
    }
}