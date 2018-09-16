/* 
Threads are needed when you want to perfom actions over and over again. 
We want to show the current time and update that every second. 
*/ 
 
import java.awt.*; 
import java.applet.*; 
// We need Date to get the current time. 
import java.util.Date;

// Implement Runnable, this will make it possible for threads 
// to call the run method when activated. 
    public class AppletRunable extends Applet implements Runnable 
    { 
         // Define your thread. 
         Thread clockThread; 
         // This textfield will show the time. 
         TextField clockField; 
         // Date will give us the current hours, minutes and seconds 
         Date date; 
         // This variable will remain true for as long 
         // we want the thread to run. 
         boolean running = true;

         public void init() 
         { 
              // a standard layout to place just one textfield 
              setLayout(new BorderLayout()); 
               clockField = new TextField(); 
              add(clockField,"Center"); 
              // Create the thread. 
              clockThread= new Thread(this); 
              // and let it start running 
              clockThread.start(); 
         }

         // Very important. You do not want your thread to keep running when 
         // the applet is deactivated (eg. user left page) 
         public void destroy() 
         { 
              // will cause thread to stop looping 
              running = false; 
              // destroy it. 
              clockThread = null; 
         } 
 

     // The method that will be called when you have a thread. 
     // You always need this when you implement Runnable (use a thread) 
     public void run() 
     { 
          // loop until told to stop 
          while (running) 
          { 
               // Construct the current date. 
               date = new Date(); 
               // Get the hours, minutes and hours 
               String time = date.getHours()+":"+date.getMinutes()+":"+date.getSeconds(); 
               // Put that result in the textfield 
               clockField.setText(time); 
               //Now the reason for threads 
               try 
               { 
                     // Wait 500milliseconds before continuing 
                    clockThread.sleep(500); 
               } 
               catch (InterruptedException e) 
               { 
                    System.out.println(e); 
                } 
               // he has wait and will now restart his actions. 
          } 
     } 


     public void paint (Graphics g)
    {
        background(g);
        house (g);
        roof1 (g);
        roof2 (g);
        windows (g);
        framing (g);
        extras (g);
        text (g);
    }
     
    public void background(Graphics g) 
    {
        setBackground (new Color(65,105,225));   //sky
        g.setColor (new Color (225,225,225));   //coluds
        g.fillOval (15,35,170,55);
        g.fillOval (20,20,160,50);
        g.fillOval (350,50,170,55);
        g.fillOval (355,35,160,50);   
        g.setColor (new Color(225,140,0));   //sun
        g.fillOval (650,035,120,120);
        g.setColor (new Color(0,100,0));   //grass
        g.fillRect (000,370,800,800);
        g.fillOval (400,300,500,300);
        g.fillOval (150,320,500,300);
        g.fillOval (000,280,500,300);
        g.fillOval (000,320,300,110);   
    }
     
    public void house (Graphics g)
    {
        g.setColor (new Color(139,69,19));   //house and garage
        g.fillRect (100,250,400,200);
        g.fillRect (499,320,200,130);
        g.setColor(new Color(190,190,190));   //doors and chimney    
        g.fillRect (160,150,60,90);
        g.fillRect (245,380,110,70);
        g.fillRect (508,350,180,100);
        g.setColor (new Color(186,134,11));   //door knobs
        g.fillOval (282,412,10,10);
        g.fillOval (307,412,10,10);
         
    }
     
    public void roof1 (Graphics g)
    {
        g.setColor(new Color(190,190,190));   //house roof
        int x[] = {98,300,501};
        int y[] = {250,130,250};
        g.fillPolygon(x,y,3);
    }
     
    public void roof2 (Graphics g)
    {
        g.setColor (new Color(190,190,190));   //garage roof
        int x[] = {499,499,700};
        int y[] = {320,249,320};
        g.fillPolygon(x,y,3);
    }
     
     
    public void windows (Graphics g)
    {
        g.setColor (new Color(186,134,11));   //outer frame effect
        g.fillOval (521,350,68,31);
        g.fillOval (606,350,68,31);
        g.fillRect (121,261,78,78);
        g.fillRect (121,361,78,78);
        g.fillRect (401,261,78,78);
        g.fillRect (401,361,78,78);
        g.fillOval (241,261,118,78);   
        g.setColor (new Color(175,238,238));   //windows
        g.fillRect (125,265,70,70);
        g.fillRect (125,365,70,70);
        g.fillRect (405,265,70,70);
        g.fillRect (405,365,70,70);
        g.fillOval (245,265,110,70);
        g.fillOval (525,353,60,25);
        g.fillOval (610,353,60,25);
    }
     
    public void framing (Graphics g)
    {
        g.setColor (new Color(139,69,19));   //grage and door sections
        g.fillRect (298,380,2,70);
        g.fillRect (508,382,180,2);
        g.fillRect (508,417,180,2);
        g.setColor (new Color(186,134,11));   //inner frame effect
        g.fillRect (157,265,5,70);
        g.fillRect (157,365,5,70);
        g.fillRect (437,265,5,70);
        g.fillRect (438,365,5,70);
        g.fillRect (297,265,5,70);
        g.fillRect (125,298,70,5);
        g.fillRect (125,398,70,5);
        g.fillRect (405,298,70,5);
        g.fillRect (405,398,70,5);
        g.fillRect (245,298,110,5);
        g.fillRect (245,375,110,5);   //door and garage frame
        g.fillRect (240,375,5,75);
        g.fillRect (352,375,5,75);
        g.fillRect (508,345,180,5);
        g.fillRect (503,345,5,105);
        g.fillRect (688,345,5,105);
    }
     
    public void extras (Graphics g)
    {
        g.setColor (new Color(210,180,140));   //smoke for chimney
        g.fillOval (160,105,35,45);
        g.fillOval (170,95,35,45);
        g.fillOval (160,85,35,45);
        g.fillOval (170,35,35,45);
        g.fillOval (160,25,35,45);
        g.fillOval (170,15,35,45);
        g.setColor (new Color(105,105,105));   //sidewalk and driveway
        g.fillRect (508,450,180,150);
        g.fillRect (245,450,107,50);
        g.fillRect (274,500,50,40);
        g.fillRect (274,520,250,45);
        }
         
    public void text (Graphics g)   //header text
    {   
        g.setColor(new Color(225,0,0));             
                g.drawString("Welcome To Christ University.",390,70);
    }
} 

/* 
Be cautious when using threads, make sure to end them sometime and not to let them run too 
fast. When threads are used to time on-screen drawing things could slow down 
heavily. 
*/ 
 