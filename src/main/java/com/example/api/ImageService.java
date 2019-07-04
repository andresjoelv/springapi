package com.example.api;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImageService {

    JSONObject response;
    
    public JSONObject createImage(MultipartFile file) {

        if(!file.isEmpty()) {
            ExtractTags extractAllTags = new ExtractTags();

            System.out.println("\n\n\n JSON Response ");
            response = extractAllTags.getSpecificTag(file);  
        }
        else{
            System.out.println("error - file empty!");
        }

        return response;

    }

}