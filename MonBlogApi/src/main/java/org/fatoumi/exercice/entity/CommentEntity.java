package org.fatoumi.exercice.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "COMMENT")
public class CommentEntity extends Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private ArticleEntity article;

    public CommentEntity() {
    }

    public CommentEntity(String value) {
        this.value = value;
    }
}
