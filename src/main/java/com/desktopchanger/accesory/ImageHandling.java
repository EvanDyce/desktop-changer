package com.desktopchanger.accesory;

import java.sql.*;
import java.io.IOException;
import java.nio.file.*;
import java.awt.image.*;

import javax.imageio.ImageIO;

import java.io.File;


public class ImageHandling {   

    public byte[] getBin(String title, Database db) {

        byte[] imgBytes = null;

        // gets the image associated with the title passed as string
        try (PreparedStatement ps = db.conn.prepareStatement("SELECT image FROM \"ImagesDB\" WHERE title= ? ")) {
            
            // sets value and executes query
            ps.setString(1, title);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()){
                    // gets the bytes from the sql bytea type and loads into the buffer to compare
                    imgBytes = rs.getBytes(1);
                    binToImg(imgBytes, "buffer.jpg");
                    return imgBytes;
                }
                rs.close();
            }
            ps.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return imgBytes;
    }

    // given array of bytes writes to the current.jpg file
    public void binToImg (byte[] imgBytes, String file) 
        throws IOException {

        Path path = Paths.get(file);
        
        Files.write(path, imgBytes);
    }


    // compares to images and returns true if identical, false otherwise
    public boolean CompareImage(File file1, File file2){

        try {
            // loads both images into a buffer
            BufferedImage bi1 = ImageIO.read(file1);
            DataBuffer db1 = bi1.getData().getDataBuffer();
            int size1 = db1.getSize();

            BufferedImage bi2 = ImageIO.read(file2);
            DataBuffer db2 = bi2.getData().getDataBuffer();
            int size2 = db2.getSize();
            
            // comparing the images pixel by pixels is extremely inefficient
            // this method may result in some pictures not being used at that moment if they are the same size as the current
            // but evenutally all images will go through the cycle
            return size1 == size2;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
