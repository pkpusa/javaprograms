/* import 'MyClass' class from 'names' myPackage */

import myPackage.MyClass;
//import myPackage.abc;
import java.io.*;

class test implements MyClass
{
    String name;
    public void read()
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter your name :");
            name = br.readLine();
         
        }
        catch(Exception e)
        {
            System.out.println(e.toString());// e.printStack() it converts the error into String.           
        }
        


    }

    public void display()
    {
        System.out.println("name = "+name+" "+a);
    }

}

public class PrintName 
{
   public static void main(String args[]) 
   {       
      // Initializing the String variable 
      // with a value 
      String name = "GeeksforGeeks";
      test obj1 = new test();
      
      // Creating an instance of class MyClass in 
      // the package.
      //MyClass obj = new MyClass();

      obj1.read();
      obj1.display();
      
      //obj.getNames(name);
   }
}