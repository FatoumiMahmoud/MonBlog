package org.fatoumi.exercice.mock.entity;

import lombok.Data;

@Data
public class CommentMock {

    private Integer id;

    private String value;

    public CommentMock() {
    }

    public CommentMock(Integer id, String value) {
        this.id = id;
        this.value = value;
    }
}
