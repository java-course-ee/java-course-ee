package com.gemini.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: GGobozov
 * Date: 25.11.13
 * Time: 14:35
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping(value = "/multiupload")
public class MultiUploadController {

    @Autowired
    ServletContext context;


    @RequestMapping(method = RequestMethod.GET)
    public String getUpload() {
        return "multiUploadPage";
    }

    @ModelAttribute
    public FileBucket getFileBucket() {
        return new FileBucket();
    }


    @RequestMapping(method = RequestMethod.POST)
    public String uploadFile(@ModelAttribute FileBucket fileBucket, HttpServletRequest request, Model model) {


        List<MultipartFile> files = fileBucket.getFiles();
        for (MultipartFile file : files) {
            try {
                File f = new File(context.getRealPath("") + "/" + file.getOriginalFilename());
                if (!f.exists())
                    f.createNewFile();
                file.transferTo(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "result";

    }


}
