package pl.coderslab.controller;

import javax.servlet.http.HttpServletResponse;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import pl.coderslab.entity.UploadFile;
import pl.coderslab.repository.ProjectRepository;
import pl.coderslab.repository.UploadRepository;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Handles requests for the file upload page.
 */
@Controller
public class UploadDownloadController {

    @Autowired
    private UploadRepository uploadRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/doUpload/{id}")
    public String showUploadForm(@PathVariable Long id) {
        return "forms/doUpload";
    }

    @PostMapping("/doUpload/{id}")
    public String handleFileUpload(@RequestParam CommonsMultipartFile[] fileUpload, @PathVariable Long id) throws Exception {

        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile aFile : fileUpload){

                System.out.println("Saving file: " + aFile.getOriginalFilename());

                UploadFile uploadFile = new UploadFile();
                uploadFile.setFileName(aFile.getOriginalFilename());
                uploadFile.setData(aFile.getBytes());
                uploadFile.setProject1(projectRepository.findOne(id));
                uploadRepository.save(uploadFile);
            }
        }

        return "forms/Success";
    }

    @GetMapping("/showAllUploadOfProjectById/{id}")
    public String showAllUploadByProjectId(@PathVariable Long id, Model model){
        model.addAttribute("uploads", uploadRepository.findAllUploadByProject1Id(id));
        return "forms/showAllUploadOfProjectById";
    }

    @RequestMapping("/retrieve/{id}")
    public void download(@PathVariable("id")
                                   Long id, HttpServletResponse response) {

        UploadFile downloadDocument = uploadRepository.findOne(id);
        try {
            response.setHeader("Content-Disposition", "inline; filename=\"" + downloadDocument.getFileName() + "\"");
            OutputStream out = response.getOutputStream();
            FileCopyUtils.copy(downloadDocument.getData(), out);
            out.flush();
            out.close();

        } catch (IOException e) {
            System.out.println(e.toString());
            //Handle exception here
        }

    }




}