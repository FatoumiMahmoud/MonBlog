package org.fatoumi.exercice.service;

import org.fatoumi.exercice.entity.Comment;

public interface CommentService {

    /**
     * @return list off all Comments
     */
    Iterable<Comment> findAll();

    /**
     * @param id post id
     * @return the comment with the id
     */
    Comment find(Integer id);

    /**
     * @param Comment the Comment without id
     * @return the created Comment
     */
    Comment create(Comment Comment);

    /**
     * @param Comment
     * @return the edited Comment
     */
    Comment edit(Comment Comment);

    /**
     * @param id comment id to be deleted
     */
    void delete(Integer id);

    /**
     * @param postId
     * @return the comments for the post
     */
    Iterable<Comment> findByPost(Integer postId);
}
