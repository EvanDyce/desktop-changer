package com.desktopchanger.accesory;

import com.sun.jna.Native;
import com.sun.jna.Library;

public class dllFuncs {

    public interface Idll extends Library {
        // creates interface that loads the dll file
        Idll INSTANCE = (Idll)Native.load("C:\\Users\\Evan Dyce\\Coding\\Java\\DesktopChanger\\Desktop-WallpaperChanger\\x64\\Debug\\Desktop-WallpaperChanger.dll", Idll.class);

        void Java_dllFuncs_change_wallpaper();
    }

    // constructor makes instance and calls the dll function
    public dllFuncs() {
        Idll dllRef = Idll.INSTANCE;
        System.out.println("dllFuncs is created");
        dllRef.Java_dllFuncs_change_wallpaper();
        System.out.println("the function after wallpepaer changer is called");
    }

}