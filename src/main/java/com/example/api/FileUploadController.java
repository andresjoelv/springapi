package com.example.api;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

    private final ImageService imageService;
    private JSONObject response;

    @Autowired
    public FileUploadController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {
        return "uploadForm";
    }


    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        try{
            response = imageService.createImage(file);
            //JSON.stringify(response, null, 4);
            redirectAttributes.addFlashAttribute("message", (response));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message",
                "error " + file.getOriginalFilename() + "!" + e.getMessage());
        }
        
        return "redirect:/";
    }

}