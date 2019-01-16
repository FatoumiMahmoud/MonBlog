package org.fatoumi.exercice.comment;

import lombok.Data;

@Data
public class Comment {

    private Integer id;

    private String value;

    public Comment(Integer id, String value) {
        this.id = id;
        this.value = value;
    }
}
