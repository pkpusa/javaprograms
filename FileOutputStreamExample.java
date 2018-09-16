import java.io.FileOutputStream;
public class FileOutputStreamExample
{
    public static void main(String args[])
    {
        try {
            {
                FileOutputStream fout = new FileOutputStream("E:\\abc.txt");
                fout.write(65);
                fout.close();
                System.out.println("Sucess");
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
}