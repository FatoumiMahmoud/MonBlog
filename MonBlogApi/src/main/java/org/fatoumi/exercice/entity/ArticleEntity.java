package org.fatoumi.exercice.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ArticleEntity extends  Article{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //TODO: use Long instead of Integer
    private Integer id;
    private String title;
    private String content;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "article_id")
    private List<CommentEntity> comments = new ArrayList<>();

    public ArticleEntity() {
    }

    public ArticleEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
