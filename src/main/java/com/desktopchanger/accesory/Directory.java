package com.desktopchanger.accesory;

import java.util.ArrayList;
import java.io.File;

public class Directory {
    private File root;
    private ArrayList<File> subDirs = new ArrayList<File>();
    private ArrayList<InsertValues> images = new ArrayList<InsertValues>();


    public Directory() {
        // makes instance root as the images root directory
        this.root = new File("Images/");
        // makes an array list of all the subdirectories in the root
        this.listSubs(this.root);
        // for each image in subdirs makes a new InsertValues object and inserts into images arraylist
        this.themesImages(this.subDirs);
    }

    public ArrayList<File> getSubs() {
        return this.subDirs;
        }

    public ArrayList<InsertValues> getImages() {
        return this.images;
    }

    
    public ArrayList<File> listSubs(File dirname) {
        // makes array of subdirectories inside of root
        File[] fileList = dirname.listFiles();

        for (File file : fileList) {
            // adds sub into subDirs instance variable
            this.subDirs.add(file);
        }

        return this.subDirs;
    }

    public ArrayList<InsertValues> themesImages(ArrayList<File> dirs) {

        // for each subdirectory in list passed in 
        for (File sub : dirs) {
            // makes a list of .jpg files inside of the sub
            File[] fileList = sub.listFiles();

            // for each file in list of jpgs make a new InsertValues and adds the object to images arraylist
            for (File image : fileList) {
                String title = image.toString().substring(sub.toString().length()+1, image.toString().length()-4);
                String theme = sub.toString().substring(7);
                InsertValues temp = new InsertValues(title, theme, image);
                this.images.add(temp);
            }
        }

        return this.images;
    }
}
