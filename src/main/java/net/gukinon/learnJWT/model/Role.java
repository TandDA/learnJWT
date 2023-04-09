package net.gukinon.learnJWT.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "roles")
public class Role extends BaseEntity {
    @Column(name = "name")
    private String name;
}
