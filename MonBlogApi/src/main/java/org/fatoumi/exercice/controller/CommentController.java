package org.fatoumi.exercice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fatoumi.exercice.entity.Comment;
import org.fatoumi.exercice.entity.CommentEntity;
import org.fatoumi.exercice.service.DefaultCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@Api(value = "CRUD API for comment", description = "CRUD API for comment")
public class CommentController {

    @Autowired
    private DefaultCommentService commentService;

    @ApiOperation("Find all commentMocks")
    @GetMapping
    public Iterable<? extends Comment> findAll() {
        return commentService.findAll();
    }

    @ApiOperation("Find a comment by id")
    @GetMapping("{id}")
    public Comment find(@PathVariable Integer id) {
        return commentService.find(id);
    }

    @ApiOperation("Create a comment and link it to its article")
    @PostMapping("create")
    public Comment create(@RequestBody CommentEntity comment) {
        return commentService.create(comment);
    }

    @ApiOperation("Edit a comment")
    @PutMapping("edit")
    public Comment edit(@RequestBody CommentEntity comment) {
        return commentService.edit(comment);
    }

    @ApiOperation("Delete the comment based on its ID")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        commentService.delete(id);
    }

    @ApiOperation("Find all comments for one article")
    @GetMapping("article/{articleId}")
    public Iterable<? extends Comment> findByArticle(@PathVariable Integer articleId){
        return commentService.findByArticle(articleId);
    }
}
