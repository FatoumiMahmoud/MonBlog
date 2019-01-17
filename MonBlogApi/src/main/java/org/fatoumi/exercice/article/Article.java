package org.fatoumi.exercice.article;

import lombok.Data;

@Data
public class Article {

    private Integer id;
    private String title;
    private String content;

    public Article() {
    }

    public Article(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
