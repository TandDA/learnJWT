package net.gukinon.learnJWT.service;

import net.gukinon.learnJWT.model.Event;
import net.gukinon.learnJWT.model.FileEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface EventService {
    List<Event> getAll();
    Event create(Event event);
    Event findById(Integer id);
    void deleteById(Integer id);
}
