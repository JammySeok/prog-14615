package com.example.prog_14615.domain.wise;

import com.example.prog_14615.domain.post.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Wise extends BaseEntity {

    private String author;
    private String saying;

}
