import java.lang.*;

import java.util.*;

// Thread A( for arithematic operations)

class Table{  
synchronized void printTable(int n){//method not synchronized  //if method is synchronized it will gv the output in the order...
for(int i=1;i<=5;i++){				//one thread will execute and then another thread will gets executed
	System.out.println(n*i);  		//so....synchronization block also possible
     try{  
      Thread.sleep(400);  
     }catch(Exception e){System.out.println(e);}  
   }  
  
 }  
} 
class A1 extends Thread

{
Table t;
A1(Table t){  
this.t=t;  
}  

  int i,j;

 A1(int x,int y)

 {

   i=x;

   j=y;

 }

  public void run()

 {
	 System.out.println("THREAD ARITHEMATIC OPERATIONS\n");



  System.out.println( "DIFFERENCE \n "+(i-j));

  System.out.println(" PRODUCT \n "+(i*j));

  System.out.println("END \n");
  System.out.println("THREAD TRIGNOMETRIC OPERATIONS");
   }

}

// Thread B (for trignometric operations)

class B1 extends Thread

{
Table t;
B1(Table t)
{
	this.t=t;
}
  int i;

 B1(int x)

 {

   i=x;

 }

   public void run()

 {
			
  

      System.out.println("SINE +i ="+Math.sin(i));

      System.out.println("COSINE +i="+Math.cos(i));

      System.out.println("TAN +i ="  +Math.tan(i));
      System.out.println("SQUARE OF  = "+i+"   "+Math.sqrt(i));

      System.out.println("END");
	  
}
}
class Multi extends Thread
{
	public void run()
	{
		System.out.println("Both the Threads Started");
	}
	
	public void prime()
	{   int count = 0;
        System.out.println("List of prime numbers from 1 to 10000:\n----------------------------------\n\n");
        System.out.println("**************************************************************************\n\n");
		for(int i = 3;i < 10000;i++)
		{
			int flag = 1;
			for(int j = 2;j < i;j++)
			{
				if((i % j) == 0)
				{
					flag = 0;
					break;
				}
			}
			if(flag == 1){
                System.out.println(i);
                count++;
            }
                
                
        }
        System.out.println("Total number of Prime Numbers are :  "+count);
        System.out.println("**************************************************************************\n\n");
	}
	
	public void palindrome()
	{
        System.out.println("List of palindrome numbers from 1 to 10000:\n");
        System.out.println("**************************************************************************\n\n");
        int count = 0;
		for(int i = 1;i < 10000;i++)
		{
			int n = i;
			int x = 0;
			int r;
			while(n != 0)
			{
				r = n % 10;
				x = (x * 10) + r;
				n = n / 10;
			}
            if(x == i)
            {
                System.out.println(i);
                count++;
            }   
        }
        System.out.println("Total number of PlainDrome  Numbers are :  "+count);
        System.out.println("**************************************************************************\n\n");
	}
}


// MAIN CLASS



class OperateThread

{

  public static void main(String args[])throws IOException

 {

   Scanner s=new Scanner(System.in);

    System.out.println("ENTER VALUES FOR ARITHEMATIC  OPERATIONS");

   int x=s.nextInt();

   int y=s.nextInt();

  System.out.println("ENTER VALUES FOR TRIGNOMETRIC OPERATIONS");

  int z=s.nextInt();

Table obj = new Table();//only one object  
   A1 a=new A1(x,y);

    B1 b=new B1(z);

   

   a.start();

   b.start();

    }


    boolean flag = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do
		{
            System.out.println("***************************************************************************");
            System.out.println("\n1Press 1 to Print Prime number");
            System.out.println("\n1Press 2 to Print Plaindrome number");
            System.out.println("\n1Press 3 for exit");
            System.out.println("***************************************************************************");
            
            
			int choice = Integer.parseInt(br.readLine());
			switch(choice)
			{
				case 1:
				Multi t1 = new Multi();
				t1.run();
				t1.prime();
				break;
				case 2:
				Multi t2 = new Multi();
				t2.run();
				t2.palindrome();
				break;
				case 3:
				flag = false;
				break;
				default:
				System.out.println("Invalid Choice");
			}
		}while(flag);

}
