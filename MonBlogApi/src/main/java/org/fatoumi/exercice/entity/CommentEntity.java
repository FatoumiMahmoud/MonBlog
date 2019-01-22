package org.fatoumi.exercice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

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

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private ArticleEntity article;

    public CommentEntity() {
    }

    public CommentEntity(String value) {
        this.value = value;
    }

    public CommentEntity(String value, ArticleEntity article) {
        this.value = value;
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentEntity that = (CommentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
