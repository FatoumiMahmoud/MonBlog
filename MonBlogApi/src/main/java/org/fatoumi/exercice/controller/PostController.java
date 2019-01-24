package org.fatoumi.exercice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fatoumi.exercice.entity.Post;
import org.fatoumi.exercice.entity.Comment;
import org.fatoumi.exercice.service.DefaultPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@Api(value = "CRUD API for posts", description = "CRUD API for posts")
public class PostController {

    @Autowired
    private DefaultPostService postService;

    @ApiOperation("Find all posts")
    @GetMapping
    public Iterable<Post> findAll() {
        return postService.findAll();
    }

    @ApiOperation("Find post by id")
    @GetMapping("{id}")
    public Post find(@PathVariable Integer id) {
        return postService.find(id);
    }

    @ApiOperation("Create an post")
    @PostMapping("create")
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @ApiOperation("Edit an post")
    @PutMapping("edit")
    public Post edit(@RequestBody Post editedPost) {
        return postService.edit(editedPost);
    }

    @ApiOperation("Delete post by id")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        postService.delete(id);
    }

    @ApiOperation("Add comment to post")
    @PutMapping("{id}/comment")
    public Post addComment(@RequestBody Comment comment, @PathVariable Integer id) {
        return postService.addComment(id, comment);
    }
}
