package net.gukinon.learnJWT.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "permissions")
public class Permission extends BaseEntity{
    private String name;
}
