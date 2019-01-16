package org.fatoumi.exercice.article;

import lombok.Data;

@Data
public class Article {

    private String title;

    public Article(String title) {
        this.title = title;
    }
}
