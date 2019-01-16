package org.fatoumi.exercice.comment;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
@Api(value = "CRUD API for comments", description = "CRUD API for comments")
public class CommentController {

    @ApiOperation("Find all comments")
    @GetMapping
    public List<Comment> findAll(){
         return Arrays.asList(new Comment(1, "Cool !!!!"), new Comment(2, "WOW !!!"));
     }
}
