import java.util.*;
import java.io.*;

class kuchv
{
    private int id;
    private String name;

    kuchv()
    {
        id = 1004;
        name = Prakash;
    }

    public void show()
    {
        System.out.println("ID : "+id);
        System.out.println("Name = "+name);

    }

}

class test
{
    public static void main(String []args)
    {
        kuchv obj = new kuchv();

        obj.show();


    }
}