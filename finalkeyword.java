import java.util.*;
import java.io.*;

final class exam
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

class student
{
    private int stuID;
    private String stdName;

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
        System.out.println("Course : MCA            "+"Student Id   :" +stuID);
        System.out.println("Class  : 3MCA           "+"Student Name :" + stdName);
        //System.out.println("=================================================");
    }

}

class hallticket extends student
{
    final float totalclass;
    //private float attendClass;
    //private float yellowForm;
    //private float medicalLeave;
    private float attendencePercentage;
    public int abc;


    hallticket()
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


    public void display(float attendClass, float yellowForm, float medicalLeave)throws IOException
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
                System.out.println("Your Hall Ticket is Blocked due to Low Attendence");
                System.out.println("Please Fill the Clearence Form");
                System.out.println("==============================================");
            }

            
            
            

        }
        catch(Exception e)
        {
            System.out.println(e.toString());// e.printStack() it converts the error into String.           
        }
        
    }



}

class finalkeyword
{
    public static void main(String []args)throws IOException
    {
        float attendClass;
        float yellowForm;
        float medicalLeave;
        String data;
        byte choice;
        exam obj = new exam();
        student obj2 = new student();
        hallticket obj3 = new hallticket();
        boolean loop = true;
        int validate = 0;
        
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
                obj2.read();
                obj2.display();
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
                obj3.display(attendClass,yellowForm,medicalLeave);
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