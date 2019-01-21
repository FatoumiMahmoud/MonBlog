package org.fatoumi.exercice.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ARTICLE")
public class ArticleEntity extends Article {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    //TODO: use Long instead of Integer
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> comments = new ArrayList<>();

    public ArticleEntity() {
    }

    public ArticleEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
