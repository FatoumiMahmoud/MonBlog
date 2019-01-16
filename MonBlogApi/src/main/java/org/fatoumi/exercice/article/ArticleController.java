package org.fatoumi.exercice.article;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
@Api(value = "CRUD API for articles", description = "CRUD API for articles")
public class ArticleController {

    @ApiOperation("Find all articles")
    @GetMapping
    public List<Article> findAll() {
        return Arrays.asList( new Article("Article 1"), new Article("Article 2"));
    }

}
