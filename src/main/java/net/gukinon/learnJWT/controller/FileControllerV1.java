package net.gukinon.learnJWT.controller;

import net.gukinon.learnJWT.model.FileEntity;
import net.gukinon.learnJWT.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@RestController
@RequestMapping("/api/v1/files")
public class FileControllerV1 {
    @Autowired
    FileService fileService;
    @GetMapping
    public List<FileEntity> getAllFiles(){
        return fileService.getAll();
    }
    @GetMapping("/{id}")
    public FileEntity getFileById(@PathVariable int id){
        return fileService.findById(id);
    }
    @PostMapping("/upload")
    public @ResponseBody String handleFileUpload(@RequestParam("file") MultipartFile file){
        return fileService.loadFile(file);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteFile(@PathVariable int id){
        fileService.deleteById(id);
    }
}
