import bank.employee;
import bank.manager;


public class MainClass
{
    public static void main(String []args)
    {
        manager m = new manager();
        m.display();
        employee e = new employee();
        e.display();
 
    }
}