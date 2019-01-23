package org.fatoumi.exercice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "COMMENT")
public class Comment {

    @ApiModelProperty(notes = "The id of the comment")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ApiModelProperty(notes = "The value of the comment")
    @Column(name = "VALUE")
    private String value;

    @ApiModelProperty(notes = "The article linked to the comment")
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;

    public Comment() {
    }

    public Comment(String value) {
        this.value = value;
    }

    public Comment(String value, Article article) {
        this.value = value;
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment that = (Comment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
