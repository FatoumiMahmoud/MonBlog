package org.fatoumi.exercice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fatoumi.exercice.entity.Comment;
import org.fatoumi.exercice.entity.Post;
import org.fatoumi.exercice.service.DefaultPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@Api(value = "CRUD API for posts", description = "CRUD API for posts")
public class PostController {

    @Autowired
    private DefaultPostService postService;

    @ApiOperation("Add comment to post")
    @PostMapping("{id}/comments")
    public Post addComment(@RequestBody Comment comment, @PathVariable Integer id) {
        return postService.addComment(id, comment);
    }

    @ApiOperation("Return all comments for one post")
    @GetMapping("{id}/comments")
    public List<Comment> getAllPostComments(@PathVariable Integer id) {
        return postService.find(id).getComments();
    }

    //*******************************************************************************//

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

    @ApiOperation("Create a post")
    @PostMapping("create")
    public Post create(@RequestBody Post post) {
        return postService.create(post);
    }

    @ApiOperation("Edit a post")
    @PutMapping("edit")
    public Post edit(@RequestBody Post editedPost) {
        return postService.edit(editedPost);
    }

    @ApiOperation("Delete post by id")
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        postService.delete(id);
    }

}
