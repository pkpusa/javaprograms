import java.io.*;

class threadprog

{

    public static void main(String args[])

    {

        MyThread thread1 = new MyThread("thread1: ");

        MyThread thread2 = new MyThread("thread2: ");
		
        MyThread thread3 = new MyThread("thread3: ");
        
        MyThread thread4 = new MyThread("thread4: ");

        MyThread thread5 = new MyThread("thread5: ");

        thread1.start();

        thread2.start();
		
        thread3.start();
        
        thread4.start();

        thread5.start();

        boolean thread1IsAlive = true;

        boolean thread2IsAlive = true;
		
        boolean thread3IsAlive = true;
        
        boolean thread4IsAlive = true;

        boolean thread5IsAlive = true;

        do {

           if (thread1IsAlive && !thread1.isAlive()) {

               thread1IsAlive = false;

               System.out.println("\nThread 1 is dead.\n");

           }

           if (thread2IsAlive && !thread2.isAlive()) {

               thread2IsAlive = false;

               System.out.println("\nThread 2 is dead.\n");

           }
		   
		   if (thread3IsAlive && !thread3.isAlive()) {

               thread3IsAlive = false;

               System.out.println("\nThread 3 is dead.\n");

           }

           if (thread4IsAlive && !thread4.isAlive()) {

            thread4IsAlive = false;

            System.out.println("\nThread 4 is dead.\n");

        }

        if (thread5IsAlive && !thread5.isAlive()) {

            thread5IsAlive = false;

            System.out.println("\nThread 5 is dead.\n");

        }

        } while(thread1IsAlive || thread2IsAlive || thread3IsAlive || thread4IsAlive || thread5IsAlive);

    }

}

 

class MyThread extends Thread

{



static String message1[] =

{"***********","Wishing ","Happy","Happy","Teachers","Day","to the","best ", "Teacher","we", "Have","***********"};




public MyThread(String id)

    {

        super(id);

    }

 

    public void run()

    {

        SynchronizedOutput.displayList(getName(),message1);

    }

 

    void randomWait()

    {

        try {

           sleep(500);//((long)(500*Math.random()));

        } catch (InterruptedException x) {

           System.out.println("Interrupted!");

        }

    }

}

 

class SynchronizedOutput

{

public static synchronized void displayList(String name,String list[])	//without synchronized not organised in order

{

for(int i=0;i<list.length;++i) {

MyThread t = (MyThread) Thread.currentThread();

t.randomWait();

System.out.println(name+list[i]);

}

}

}