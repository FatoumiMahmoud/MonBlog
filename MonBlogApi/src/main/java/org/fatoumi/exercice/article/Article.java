package org.fatoumi.exercice.article;

import lombok.Data;
import org.fatoumi.exercice.comment.Comment;

import java.util.ArrayList;
import java.util.List;

@Data
public class Article {

    private Integer id;
    private String title;
    private String content;

    private List<Comment> comments = new ArrayList<>();

    public Article() {
    }

    public Article(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
