import java.io.*;

class ThreadSynchronization

{

    public static void main(String args[])

    {

        MyThread thread1 = new MyThread("thread1: ");

        MyThread thread2 = new MyThread("thread2: ");
		
		MyThread thread3 = new MyThread("thread3: ");

        thread1.start();

        thread2.start();
		
		thread3.start();

        boolean thread1IsAlive = true;

        boolean thread2IsAlive = true;
		
		boolean thread3IsAlive = true;

        do {

           if (thread1IsAlive && !thread1.isAlive()) {

               thread1IsAlive = false;

               System.out.println("Thread 1 is dead.");

           }

           if (thread2IsAlive && !thread2.isAlive()) {

               thread2IsAlive = false;

               System.out.println("Thread 2 is dead.");

           }
		   
		   if (thread3IsAlive && !thread3.isAlive()) {

               thread3IsAlive = false;

               System.out.println("Thread 3 is dead.");

           }

        } while(thread1IsAlive || thread2IsAlive || thread3IsAlive);

    }

}

 

class MyThread extends Thread

{

static String message[] =

{ "Java is an", "object-oriented,", "class-based,", "concurrent,", "secured", "and", "general-purpose", "computer-programming language."};

 

    public MyThread(String id)

    {

        super(id);

    }

 

    public void run()

    {

        SynchronizedOutput.displayList(getName(),message);

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