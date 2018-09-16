import java.io.*;
import java.util.Scanner;

class BufferedWriterE
{
	String dName;
	String dBloodgroup;
	String rBlood;
	String rName;
	String date;


	public void read()throws IOException
	{
		FileWriter wr = new FileWriter("file.txt");

		BufferedWriter br  =  new BufferedWriter(wr);

		BufferedReader rb = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("\n");
			System.out.println("\t\t This is asking for Donor and Acceptors Blood Details Using BUFFEREDWRITER class ");
			System.out.println("-------------------------------------------------------------------");
			System.out.println(" Enter the Donor Name: ");
			dName = rb.readLine();

			System.out.println(" Enter the Donor Blood Group : ");
			dBloodgroup= rb.readLine();

			System.out.println(" Enter the Acceptor Name : ");
			rName = rb.readLine();

			System.out.println(" Enter the Acceptor Blood group	: ");
			rBlood= rb.readLine();

			System.out.println(" Enter your Date of Blood received : ");
			date= rb.readLine();

			br.write(dName);
			br.write('\t');
			br.write('\t');
			br.write(dBloodgroup);
			br.write('\t');
			br.write('\t');
			br.write('\t');
			br.write(rName);
			br.write('\t');
			br.write('\t');
			br.write(rBlood);
			br.write('\t');		
			br.write(date);
			

			br.close();
			System.out.println("\n");
			System.out.println("Your records are written successfully");

	}
	
}


class BufferedReaderE extends BufferedWriterE
{
	public void disp()throws IOException
	{
			System.out.println("\n");
			System.out.println("\t This is for displaying Donor and Acceptor Details Using BUFFEREDREADER class");
			System.out.println("-------------------------------------------------------------------");
		FileReader fr = new FileReader("file.txt");

		BufferedReader br1 = new BufferedReader(fr);

		System.out.println("donorName ||donorBloodgroup ||AcceptorsNAme ||Acceptor Blood group ||DATE");

               	int l=0;  
                while((l=br1.read())!=-1){  
                System.out.print((char)l +""); 
            }

		br1.close();
		fr.close();
	}
	
}

class DataOutput
{
	byte num;
	String[] psg = new String[2];
	char[] gen = new char[2];


	public void reader()throws IOException
	{
			System.out.println("\n");
			System.out.println("\t This is asking for Acceptors Details Using DATAOUTPUTSTREAM class");
			System.out.println("-------------------------------------------------------------------");

		DataOutputStream out = new DataOutputStream(new FileOutputStream("invoice.txt"));

		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);


		System.out.println(" Enter the Number of Blood required : ");
		num = Byte.parseByte(br2.readLine());

		for(byte i = 0; i < num; i++)
		{
			System.out.println("---------------------------------------------------------");
			System.out.println(" Enter the Acceptor Name : ");
			psg[i] = sc.next();
			System.out.println(" Enter the Acceptor Gender : ");
			gen[i] = sc.next().charAt(0);
			
			out.writeChar('\t');
			out.writeChars(psg[i]);
			out.writeChar('\t');
//out.writeChar('\n');
		
			out.writeChar(gen[i]);
		
		out.writeChar('\n');
			//out.writeChar('\t');
		}
		out.close();
			System.out.println("\n");
			System.out.println("Your records are written successfully");
	}
}

class DataInput extends DataOutput
{
	public void displ()throws IOException
	{
			System.out.println("\n");
			System.out.println("\t This is for displaying Acceptor Details Using DATAINPUTSTREAM class");
			System.out.println("-------------------------------------------------------------------");
	    InputStream in = new FileInputStream("invoice.txt");

	    DataInputStream inst = new DataInputStream(in);
      System.out.println("\tName ||\tgender");
	    int count = in.available();

	    byte[] ary = new byte[count];

	    inst.read(ary);

	    for (byte bt : ary)
	    {  
	      char k = (char) bt;  
	      System.out.print(k+"");
	 	}
	}
}

class Writer
{
byte num;
	char ch;
	String dise;
	String age;

	public void reading()throws IOException
	{
            FileWriter w = new FileWriter("inp.txt");  
            

			Scanner sc = new Scanner(System.in);

			System.out.println("\n");
			
			System.out.println("\t This is asking for Acceptor health Details Details Using WRITER class");
			System.out.println("-------------------------------------------------------------------");
			System.out.println(" Do you wish to give you health details  with us ? ");
			ch = sc.next().charAt(0);
			if(ch == 'y')
			{
				System.out.println(" Enter the Disease  : ");
				dise = sc.next();

				System.out.println(" Enter the  age of Acceptor: ");
				age = sc.next();


			}
			else
			{
				System.exit(0);
			}
				
				w.write('\t');
				w.write(dise);
				w.write('\t');
				w.write('\t');
				w.write('\t');
				
				w.write(age);
                 w.write('\t');
		
				w.close();
			System.out.println("\n");
			System.out.println("Your records are written successfully");
	}
}

class Reader extends Writer
{
	public void display()throws IOException
	{
			System.out.println("\n");
			System.out.println("\t This is for Acceptor health Details Using READER class");
			System.out.println("-------------------------------------------------------------------");
		FileReader reader = new FileReader("inp.txt");
  System.out.println("\tDisease ||\tage");
         int data = reader.read(); 

         while (data != -1)
          {  
                System.out.print((char) data);  
                data = reader.read();  
            }  
            reader.close();

	}
}

public class readWriter
{
	public static void main(String[] args)throws IOException
	{
		BufferedWriterE obj = new BufferedWriterE();
		obj.read();	

		BufferedReaderE obj1 = new BufferedReaderE();
		obj1.disp();

		DataOutput obj2 = new DataOutput();
		obj2.reader();

		DataInput obj3 = new DataInput();
		obj3.displ();

		Writer obj4 = new Writer();
		obj4.reading();

		Reader obj5 = new Reader();
		obj5.display();

	}
}