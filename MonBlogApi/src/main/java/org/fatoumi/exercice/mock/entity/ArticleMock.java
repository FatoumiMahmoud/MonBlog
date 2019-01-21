package org.fatoumi.exercice.mock.entity;

import lombok.Data;
import org.fatoumi.exercice.entity.Article;
import org.fatoumi.exercice.entity.Comment;

import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleMock extends Article {

    private Integer id;
    private String title;
    private String content;

    private List<CommentMock> commentMocks = new ArrayList<>();

    public ArticleMock() {
    }

    public ArticleMock(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
