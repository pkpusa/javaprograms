//Sample 01: Package inclusion
import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.Serializable;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
 
class Read_Write implements Serializable
{
    private String stud_name;
    private String stud_class;
    private Double Stud_reg;
    private int marks1;
    private int marks2;
    private int marks3;
    private int total;


    public void read() throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       try{
        System.out.println("Enter the name of Student");
        stud_name=br.readLine();
        System.out.println("Enter the Class of Student");
        stud_class=br.readLine();
        System.out.println("Enter the Registrtaion Number of Student");
        Stud_reg=Double.parseDouble(br.readLine());
        System.out.println("Enter the First CIA marks");
        marks1=Integer.parseInt(br.readLine());
        System.out.println("Enter the Second CIA marks");
        marks2=Integer.parseInt(br.readLine());
        System.out.println("Enter the Third CIA marks");
        marks3=Integer.parseInt(br.readLine());
       }
       catch(Exception e)
       {
        System.out.println(e.toString());
       }
    }
       public void display()
       {
           System.out.println("Name of Student: "+stud_name);
           System.out.println("Class of Student: "+stud_class);
           System.out.println("Reg_ NO of Student: "+Stud_reg);
           System.out.println("1st CIA marks: "+marks1);
           System.out.println("2nd CIA marks:"+marks2);
           System.out.println("3rd CIA marks: "+marks3);
       }
    
    }
  


 class Fileopr {

    
    public static void main(String[] args) throws IOException
     {
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        int ch;
      
        
        while (loop)
        {
            System.out.println("======================================\n");
            System.out.println("       File Operation in Java         \n");
            System.out.println("======================================\n");
            System.out.println(" 1.Read & Write using BufferInputStream");
            System.out.println(" 2.Read & Write Using FileReader");
            System.out.println(" 3.Read & Write Using BufferReader");
            System.out.println(" 4.Exit");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                        File file = new File("Student.txt");
                        BufferedInputStream bis = null;
                        FileInputStream  fis= null;

                        try
                        {
                            //FileInputStream to read the file
                            fis = new FileInputStream(file);

                            /*Passed the FileInputStream to BufferedInputStream
                            *For Fast read using the buffer array.*/
                            bis = new BufferedInputStream(fis);

                            /*available() method of BufferedInputStream
                            * returns 0 when there are no more bytes
                            * present in the file to be read*/
                            while( bis.available() > 0 ){             	
                                System.out.print((char)bis.read());
                            }

                        }catch(FileNotFoundException fnfe)
                            {
                                System.out.println("The specified file not found" + fnfe);
                            }
                            catch(IOException ioe)
                            {
                                System.out.println("I/O Exception: " + ioe); 
                            }
                            finally
                            {
                                try{
                                if(bis != null && fis!=null)
                                {
                                    fis.close();
                                    bis.close();
                                }      
                                }catch(IOException ioe)
                                {
                                    System.out.println("Error in InputStream close(): " + ioe);
                                }         
                            }

                            BufferedWriter bw = null;
                            try {
                           String mycontent = "This String would be written" +
                              " to the specified File";
                               //Specify the file name and path here
                           File f = new File("Student.txt");
                      
                           /* This logic will make sure that the file 
                            * gets created if it is not present at the
                            * specified location*/
                            if (!f.exists()) {
                               f.createNewFile();
                            }
                      
                            FileWriter fw = new FileWriter(f);
                            bw = new BufferedWriter(fw);
                            bw.write(mycontent);
                                System.out.println("File written Successfully");
                      
                            } catch (IOException ioe) {
                             ioe.printStackTrace();
                          }
                          finally
                          { 
                             try{
                                if(bw!=null)
                               bw.close();
                             }catch(Exception ex){
                                 System.out.println("Error in closing the BufferedWriter"+ex);
                              }
                          }
                      

                                    break;
                case 2:
                try{
                    Read_Write rw=new Read_Write();
                    FileOutputStream fileout=new FileOutputStream("Student");
                    ObjectOutputStream objout=new ObjectOutputStream(fileout);
                    for(int i=0;i<4;i++){
                    rw.read();
                    objout.writeObject(rw);
                    }
                    objout.close();
                   }
                    catch(Exception e)
                    {
                      System.out.println(e.toString());
                    }

                    try{
                        Read_Write rw=new Read_Write();
                        FileInputStream fi=new FileInputStream("Student");
                        ObjectInputStream ois=new ObjectInputStream(fi);
                        for(int i=0;i<6;i++)
                        {
                            try{
                                rw=(Read_Write)ois.readObject();
                            }
                            catch(Exception e)
                            {
                            }
                        rw.display();
                        }	
                    
                    ois.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e.toString());
                    }
                    break;
              
            case 3:
                BufferedReader br = null;
                BufferedReader br2 = null;
                try{	
                    br = new BufferedReader(new FileReader("Student.txt"));		
         
                    //One way of reading the file
                System.out.println("Reading the file using readLine() method:");
                String contentLine = br.readLine();
                while (contentLine != null) {
                   System.out.println(contentLine);
                   contentLine = br.readLine();
                }
         
                br2 = new BufferedReader(new FileReader("Student.txt"));
         
                //Second way of reading the file
                System.out.println("Reading the file using read() method:");
                int num=0;
                char chr;
                while((num=br2.read()) != -1)
                {	
                        chr=(char)num;
                    System.out.print(ch);
                }
         
                } 
                catch (IOException ioe) 
                {
                ioe.printStackTrace();
                } 
                finally 
                {
                try {
                   if (br != null)
                  br.close();
                   if (br2 != null)
                  br2.close();
                } 
                catch (IOException ioe) 
                    {
                 System.out.println("Error in closing the BufferedReader");
                }
             }
              
             BufferedWriter bwt = null;
             try {
            String mycontent = "This String would be written" +
               " to the specified File";
                //Specify the file name and path here
            File fle = new File("Student.txt");
       
            /* This logic will make sure that the file 
             * gets created if it is not present at the
             * specified location*/
             if (!fle.exists()) {
                fle.createNewFile();
             }
       
             FileWriter fw = new FileWriter(fle);
             bwt = new BufferedWriter(fw);
             bwt.write(mycontent);
                 System.out.println("File written Successfully");
       
             } catch (IOException ioe) {
              ioe.printStackTrace();
           }
           finally
           { 
              try{
                 if(bwt!=null)
                bwt.close();
              }catch(Exception ex){
                  System.out.println("Error in closing the BufferedWriter"+ex);
               }
           }
       
                    break;
                    
                case 4: loop=false;
                        System.out.println("Program is Existing...!!");
                        break;    
                }


        }

    
    }     
}