package com.example.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.*;
import com.drew.metadata.iptc.*;
import com.drew.metadata.jpeg.*;

import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.util.logging.Logger;
import java.util.Iterator;
import java.util.logging.Level;




public class ExtractTags {

    String allTags;
    String tag;
    String height, width, date, size, name;
    File image;
    // File jpegFile = new File("C:\\aecu-can\\gallery\\9-exotism.jpg");

    // public String getTags(MultipartFile file) {

    //     try {

    //         image = convert(file);

    //         Metadata metadata = ImageMetadataReader.readMetadata(image);

    //         for (Directory directory : metadata.getDirectories()) {
    //             for (Tag allTags : directory.getTags()) {

    //                 System.out.println(allTags);
    //             }
    //         }
    //     } catch (ImageProcessingException ex) {
    //         Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
    //     } catch (Exception ex) {
    //         Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
    //     }
    //     return allTags;
    // }

    public JSONObject getSpecificTag(MultipartFile file){
        JSONObject json = new JSONObject();
        try {
            
            image = convert(file);

            Metadata metadata = ImageMetadataReader.readMetadata(image);

            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    if (tag.getTagName().equals("Image Height")){
                        height = tag.getDescription();
                    }
                    if (tag.getTagName().equals("Image Width")){
                        width = tag.getDescription();
                    }
                    if (tag.getTagName().equals("Date/Time")){
                        date = tag.getDescription();
                    }
                    if (tag.getTagName().equals("File Size")){
                        size = tag.getDescription();
                    }
                    if (tag.getTagName().equals("File Name")){
                        name = tag.getDescription();
                    }
                }
            }

            String message;

            json.put("File length", size);
            json.put("Datetime", date);
            json.put("Height", height);
            json.put("Width", width);
            json.put("Desc", name);

            message = json.toString();
            System.out.println(message);
            
        } catch (ImageProcessingException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        return json;
    }

    public static File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}