package org.fatoumi.exercice.mock.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fatoumi.exercice.entity.Comment;
import org.fatoumi.exercice.mock.entity.CommentMock;
import org.fatoumi.exercice.mock.service.MockCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mock/comments")
@Api(value = "CRUD API for commentMocks", description = "CRUD API for commentMocks")
public class CommentMockController {

    @Autowired
    private MockCommentService commentService;

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
    public Comment create(@RequestBody CommentMock comment) {
        return commentService.create(comment);
    }

    @ApiOperation("Edit a comment")
    @PutMapping("edit")
    public Comment edit(@RequestBody CommentMock comment) {
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
