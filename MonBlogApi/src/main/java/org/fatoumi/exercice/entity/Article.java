package org.fatoumi.exercice.entity;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "ARTICLE")
public class Article {

    @ApiModelProperty(notes = "the id of the article")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    //TODO: use Long instead of Integer
    private Integer id;

    @ApiModelProperty(notes = "the title of the article")
    @Column(name = "TITLE")
    private String title;

    @ApiModelProperty(notes = "the content of the article")
    @Column(name = "CONTENT")
    private String content;

    @ApiModelProperty(notes = "The comments list of the article")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    public Article() {
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article that = (Article) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                '}';
    }
}
