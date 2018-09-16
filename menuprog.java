import java.awt.*;
public class menuprog
{
    public static void main(String args[])
    {
        Frame f;
        MenuBar mb;
        f = new Frame("Menu Frame");
        mb = new MenuBar();
        f.setMenuBAr(mb);
        Menu mFile, mEdit;
        mFile new Menu("File");
        mEdit new Menu("Edit");
        mNew = new MenuItem("New");
        mClose = new MenuItem("Close");
        mClose = new MenuItem("Copy");
        mPaste = new MenuItem("paste");
        mFile.add(mNew);
        mFile.add(mClose);
        mEdit.add(mCopy);
        mEdit.add(mPaste);
        mClose.setEnabled(false);
        CheckboxMenuItem mPrint;
        mPrint =  new CheckboxMenuItem("Print");
        mFile.add(mPrint);
        mFile.addSeparator();
        Menu mFont;
        mFont = new Menu("Font");
        mFile.add(mFont);
        mFont.add("Arial");

        mFont.add("Times New Roman");
        f.setSize(400,400);
        f.setVisible(true);



    }
}