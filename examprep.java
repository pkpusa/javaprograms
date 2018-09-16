import java.util.*;
import java.io.*;

class publication
{
    public int pId;
    public String author;
    public String title;
    public float price;

    publication()
    {
        pId = 1001;
        author = "Prakash Kumar";
        title =  "TITLE NAME";
        price =  100;

    }

    publication(String name)
    {
        pId = ++pId;
        tile = name;

    }

    public void getdata()
    {
        BufferedReader br = new BufferedReadeR(new InputStreamReader(System.in));

        System.out.println("PLease enter NAme of the Author");
        author = br.readLIne();
       /* System.out.println("Please Enter the Title Name ");
        title = br.readLine();*/
        System.out.println("Please Enter the Price");
        price = Float.parseFloat(br.readLine());
    }

    public void putdata()
    {
        System.out.println("Publication Id : "+pID);

        System.out.println("Author Name  : "+author);

        System.out.println("Title Name : "+title);

        System.out.println("Price  : "+price);

    }


}

class textbook extends publication
{
    public  int pagecount;

    textbook()
    {
        
    }


}