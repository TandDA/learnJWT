package net.gukinon.learnJWT.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "files")
public class FileEntity extends BaseEntity {
    @Column(name = "path")
    private String path;
}
