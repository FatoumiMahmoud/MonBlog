package org.fatoumi.exercice.comment;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fatoumi.exercice.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@Api(value = "CRUD API for comments", description = "CRUD API for comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ApiOperation("Find all comments")
    @GetMapping
    public List<Comment> findAll() {
        return commentService.findAll();
    }

    @ApiOperation("Find a comment by id")
    @GetMapping("{id}")
    public Comment find(@PathVariable Integer id) {
        return commentService.find(id);
    }

    @ApiOperation("Create a comment and link it to its article")
    @PostMapping("create")
    public Comment create(@RequestBody Comment comment) {
        return commentService.create(comment);
    }

    @ApiOperation("Edit a comment")
    @PutMapping("edit")
    public Comment edit(@RequestBody Comment comment) {
        return commentService.edit(comment);
    }

    @ApiOperation("Delete the comment based on its ID")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        commentService.delete(id);
    }
}
