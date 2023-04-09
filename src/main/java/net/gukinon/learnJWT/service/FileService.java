package net.gukinon.learnJWT.service;

import net.gukinon.learnJWT.model.FileEntity;
import net.gukinon.learnJWT.model.UserEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    List<FileEntity> getAll();
    FileEntity create(FileEntity file);
    FileEntity findById(Integer id);
    void deleteById(Integer id);

    String loadFile(MultipartFile file);
}
