package org.fatoumi.exercice.article;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Article2 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //TODO: use Long instead of Integer
    private Integer id;
    private String title;
    private String content;

    public Article2() {
    }

    public Article2(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
