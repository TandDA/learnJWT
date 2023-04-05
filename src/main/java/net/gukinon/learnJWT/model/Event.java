package net.gukinon.learnJWT.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "events")
public class Event extends BaseEntity{

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private FileEntity file;
}
