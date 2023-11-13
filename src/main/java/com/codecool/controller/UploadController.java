package com.codecool.controller;

import com.codecool.model.VolunteerData;
import com.codecool.database.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


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
    public String handleUpload(@RequestParam("name") String name,
                               @RequestParam("personalObjective") String personalObjective,
                               @RequestParam("phoneNbr") String phoneNbr,
                               @RequestParam("email") String email,
                               @RequestParam("file") MultipartFile file) {
        try {
            // save data to database
            VolunteerData userData = new VolunteerData();
            userData.setName(name);
            userData.setPersonalObjective(personalObjective);
            userData.setPhoneNbr(phoneNbr);
            userData.setEmail(email);
            userDataRepository.save(userData);

            if (!file.isEmpty()) {
                // unique file name
                String originalFileName = file.getOriginalFilename();
                String uniqueFileName = generateUniqueFileName(originalFileName);

                // store the file
                String filePath = fileUploadDirectory + File.separator + uniqueFileName;
                Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

                return "Data and file uploaded and saved successfully";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return "Data and file upload failed";
    }


    private String generateUniqueFileName(String originalFileName) {
        long timestamp = System.currentTimeMillis();
        return originalFileName + "_" + timestamp + ".pdf";
    }

    @GetMapping("/testing")
    public String testing() {
        return "Testing Works!";
    }
}
