package com.example.api;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImageService {

    JSONObject response;
    
    public JSONObject createImage(MultipartFile file) {

        if(!file.isEmpty()) {
            System.out.println("inside ImageService createImage()");
            ExtractTags extractAllTags = new ExtractTags();

            //extractAllTags.getTags();
            System.out.println("\n\n\n Has this ");
            response = extractAllTags.getSpecificTag(file);  
        }
        else{
            System.out.println("fail ImageService createImage()");
        }

        return response;

    }

}