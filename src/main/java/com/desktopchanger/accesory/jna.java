package com.desktopchanger.accesory;

import com.sun.jna.Library;
import com.sun.jna.Native;
// import com.sun.jna.platform.win32.WinDef.HWND;
// import com.sun.jna.platform.win32.WinDef.PVOID;
import com.sun.jna.win32.W32APIOptions;

public class jna {    
 public static interface User32 extends Library {
     User32 INSTANCE = (User32) Native.loadLibrary("user32",User32.class,W32APIOptions.DEFAULT_OPTIONS);        
     boolean SystemParametersInfo (int one, int two, String s ,int three);         
 }

 public jna() {
   User32.INSTANCE.SystemParametersInfo(0x0014, 0, "C:\\Users\\Evan Dyce\\Coding\\Java\\desktop-changer\\current.jpg" , 1);
 }
}
// public static void main(String[] args) {   
//    User32.INSTANCE.SystemParametersInfo(0x0014, 0, "C:\\Users\\Evan Dyce\\Coding\\Java\\DesktopChanger\\desktop-changer\\current.jpg" , 1);
//    }
//  }