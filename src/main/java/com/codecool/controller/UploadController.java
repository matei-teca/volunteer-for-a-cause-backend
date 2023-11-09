package com.codecool.controller;

import com.codecool.database.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/upload")
public class UploadController {

    private final UserDataRepository userDataRepository;
    private final String fileUploadDirectory;
    // TODO: public class AppConfig

    @Autowired
    public UploadController(UserDataRepository userDataRepository, @Value("/Users/mateiteca/IdeaProjects/ADVANCED/pet_project/uploads") String fileUploadDirectory) {
        this.userDataRepository = userDataRepository;
        this.fileUploadDirectory = fileUploadDirectory;
    }

    @PostMapping
    @ResponseBody
    public String handleUpload() {
        return "Data and file uploaded and saved successfully";
    }

    private String generateUniqueFileName(String originalFileName) {
        long timestamp = System.currentTimeMillis();
        return originalFileName + "_" + timestamp + ".pdf";
    }

    @GetMapping("/testing")
    public String testing(){
        return "Testing Works!";
    }
}
