 import java.awt.Frame;

// import com.sun.glass.ui.MenuBar;
// import com.sun.glass.ui.MenuItem;

// import java.awt.*;
// public class MyMenu1
// {
//     public static void main(String args[])
//     {
//         Frame f;
//         MenuBar mb;
//         f = new Frame("Menu Frame");
//         mb = new MenuBar();
//         f.setMenuBar(mb);
//         Menu mFile,mEdit;
//         mFile = new Menu("File");
//         mEdit = new Menu("Edit");
//         mb.add(mFile);
//         mb.add(mEdit);
//         MenuItem mNew,mClose,mCopy,mPaste;
//         mNew = new MenuItem("New");
//         mClose = new MenuItem("Close");
//         mCopy = new MenuItem("Copy");
//         mPaste = new MenuItem("paste");
//         mFile.add(mNew);
//         mFile.add(mClose);
//         mEdit.add(mCopy);
//         mEdit.add(mPaste);
//         mClose.setEnabled(false);
//         CheckboxMenuItem mPrint;
//         mPrint = new CheckboxMenuItem("Print");
//         mFile.add(mPrint);
//         mFile.addSeparator();
//         Menu mFont;
//         mFont = new Menu("Font");
//         mFile.add(mFont);
//         mFont.add("Arial");
//         mFont.add("Time New Roman");
//         f.setSize(400,400);
//         f.setVisible(true);

//     }
// }


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MyMenu1
{
    public static void main(String args[])
    {
        Frame f;
        Label l1;
        MenuBar mb;
        f = new Frame("Menu Frame");
        mb = new MenuBar();
        f.setMenuBar(mb);
        Menu mFile , mEdit;
        mFile = new Menu("File");
        mEdit = new Menu("Edit");
        mb.add(mFile);
        mb.add(mEdit);
        MenuItem mNew , mClose , mCopy , mPaste;
        mNew = new MenuItem("New");
        mClose = new MenuItem("Close");
        mCopy = new MenuItem("Copy");
        mPaste = new MenuItem("Paste");
        mFile.add(mNew);
        mFile.add(mClose);
        mEdit.add(mCopy);
        mEdit.add(mPaste);
        mClose.setEnabled(false);
        CheckboxMenuItem mPrint;
        mPrint = new CheckboxMenuItem("Print");
        mFile.add(mPrint);
        mFile.addSeparator();
        Menu mFont;
        mFont = new Menu("Font");
        mFile.add(mFont);
        mFont.add("Arial");
        mFont.add("Times New Roman");
        f.setSize(400,400);
        f.setVisible(true);

        l1=new Label("Welcome Prakash");
        l1.setVisible(false); 
        l1.setBounds(50,100, 100,30);
        f.add(l1);
        mNew.addActionListener(new ActionListener(){
        
            @Override
            public void actionPerformed(ActionEvent e) {
                l1.setVisible(true);
            }
        });
        }
}