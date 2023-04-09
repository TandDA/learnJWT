package net.gukinon.learnJWT.service.Impl;

import net.gukinon.learnJWT.model.FileEntity;
import net.gukinon.learnJWT.model.UserEntity;
import net.gukinon.learnJWT.repository.FileRepository;
import net.gukinon.learnJWT.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Autowired
    FileRepository fileRepository;

    @Override
    public List<FileEntity> getAll() {
        return fileRepository.findAll();
    }

    @Override
    public FileEntity create(FileEntity file) {
        return fileRepository.save(file);
    }

    @Override
    public FileEntity findById(Integer id) {
        return fileRepository.findById(id).get();
    }

    @Override
    public void deleteById(Integer id) {
        fileRepository.deleteById(id);
    }

    @Override
    public String loadFile(MultipartFile file) {
        String name = file.getOriginalFilename();
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/media/"+name)));
                stream.write(bytes);
                stream.close();
                return "Вы удачно загрузили " + name;
            } catch (Exception e) {
                return "Вам не удалось загрузить " + name + " => " + e.getMessage();
            }
        } else {
            return "Вам не удалось загрузить " + name + " потому что файл пустой.";
        }
    }
}
