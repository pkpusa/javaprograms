import java.util.*;
import java.io.*;

class kuchv
{
    private int id;
    private String name;

    kuchv()
    {
        id = 1004;
        name = "Prakash";
    }

    public void read() throws IOException
    {
        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please enet ID");
        id = Integer.parseInt(br.readLine());

        System.out.println("Plz enter name ");
        //name = sc.nextLine();
        name = br.readLine();



    }

    public void show() throws IOException
    {
        System.out.println("ID : "+id);
        System.out.println("Name = "+name);

    }

}

class test
{
    public static void main(String []args) throws IOException
    {
        kuchv obj[] = new kuchv[2];
        obj[0] = new kuchv();
        obj[0].read();
        obj[1] = new kuchv();
        obj[1].read();
        obj[0].show();
        obj[1].show();


    }
}



