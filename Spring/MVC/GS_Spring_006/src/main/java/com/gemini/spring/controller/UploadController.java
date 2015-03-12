package com.gemini.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Author: Georgy Gobozov
 * Date: 25.11.13
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController {


    @Autowired
    ServletContext context;

    @RequestMapping(method = RequestMethod.GET)
    public String getUpload() {
        return "uploadPage";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String uploadFile(@RequestParam MultipartFile file, HttpServletRequest request, Model model) {

        String fileName = file.getOriginalFilename();
        System.out.println("fileName = " + fileName);

        boolean uploadResult = saveFile(file);
        System.out.println(uploadResult);
        request.setAttribute("result", uploadResult);
        return "result";

    }


    private boolean saveFile(MultipartFile file) {

        InputStream inputStream = null;
        OutputStream outputStream = null;


        try {
            inputStream = file.getInputStream();

            File newFile = new File(context.getRealPath("") + "/" + file.getOriginalFilename());
            if (!newFile.exists()) {
                newFile.createNewFile();
                System.out.println("File path = " + newFile.getAbsolutePath());

            }
            outputStream = new FileOutputStream(newFile);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;

    }


}
