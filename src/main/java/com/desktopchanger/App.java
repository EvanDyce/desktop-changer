package com.desktopchanger;

import com.desktopchanger.accesory.*;

class Main {

    private static Database db = new Database();
    private static Directory dir = new Directory();
    private static ImageHandling handler = new ImageHandling();

    public static void main(String[] args) {
        Insert();

        // gets random image title from database
        String image = db.ChooseRandom();

        Compare(image);
        
        // creates instance calls constructor which actually switches the desktop image
        // new dllFuncs();
        new jna();
    }


    public static void Insert() {
        // clears the database and then re inserts the image files along with any new ones that have been added
        db.Clear();
        for (InsertValues values : dir.getImages()) {
            try {
                db.Insert(values);
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } 
    }

    // checks if the current desktop is the same as the randomly selected one
    // if they are the same it chooses a new one
    public static void Compare(String image) {
        try {
            // checks if buffered image and current desktop are the same
            // if they aren't change the desktop
            // !handler.CompareImage(new File(currentPath), new File(bufferPath))
            byte[] imgbytes = handler.getBin(image, db);
            handler.binToImg(imgbytes, "current.jpg");
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}