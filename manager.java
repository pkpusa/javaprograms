package bank;

public class manager extends employee
{
    private int empid = 987555;
    String name = "Prakash KUmar";
    String deptName = "COmputer Science";
    public void display()
    {
        //System.out.println("Name of employee = "+name);
        //System.out.println("Name Dept = "+deptName);
        System.out.println("Id= "+empid);
    }
}
public class srmanager extends manager
{   

    public void disp()
    {
        System.out.println("This is senior manger class");
    }


}

