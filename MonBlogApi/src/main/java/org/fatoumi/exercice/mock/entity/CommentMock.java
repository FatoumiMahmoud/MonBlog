package org.fatoumi.exercice.mock.entity;

import lombok.Data;
import org.fatoumi.exercice.entity.Comment;

@Data
public class CommentMock extends Comment {

    private Integer id;

    private String value;

    public CommentMock() {
    }

    public CommentMock(Integer id, String value) {
        this.id = id;
        this.value = value;
    }
}
