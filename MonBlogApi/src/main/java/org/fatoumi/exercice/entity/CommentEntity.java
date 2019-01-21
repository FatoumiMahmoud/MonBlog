package org.fatoumi.exercice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class CommentEntity extends Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String value;

    public CommentEntity() {
    }

    public CommentEntity(String value) {
        this.value = value;
    }
}
