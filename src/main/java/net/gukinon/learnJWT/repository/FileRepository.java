package net.gukinon.learnJWT.repository;

import net.gukinon.learnJWT.model.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileEntity,Integer> {
}
