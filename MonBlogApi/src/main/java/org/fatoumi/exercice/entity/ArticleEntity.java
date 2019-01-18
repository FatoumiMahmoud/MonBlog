package org.fatoumi.exercice.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class ArticleEntity extends  Article{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //TODO: use Long instead of Integer
    private Integer id;
    private String title;
    private String content;

    public ArticleEntity() {
    }

    public ArticleEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
