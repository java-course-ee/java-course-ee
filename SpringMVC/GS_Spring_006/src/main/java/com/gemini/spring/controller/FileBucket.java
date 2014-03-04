package com.gemini.spring.controller;

import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: GGobozov
 * Date: 25.11.13
 * Time: 14:36
 * To change this template use File | Settings | File Templates.
 */
public class FileBucket {

    private List<MultipartFile> files = new ArrayList<MultipartFile>();

    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
