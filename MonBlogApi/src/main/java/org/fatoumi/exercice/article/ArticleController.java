package org.fatoumi.exercice.article;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fatoumi.exercice.article.service.ArticleService;
import org.fatoumi.exercice.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@Api(value = "CRUD API for articles", description = "CRUD API for articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @ApiOperation("Find all articles")
    @GetMapping
    public List<Article> findAll() {
        return articleService.findAll();
    }

    @ApiOperation("Find article by id")
    @GetMapping("{id}")
    public Article find(@PathVariable Integer id) {
        return articleService.find(id);
    }

    @ApiOperation("Create an article")
    @PostMapping("create")
    public Article create(@RequestBody Article article) {
        return articleService.create(article);
    }

    @ApiOperation("Edit an article")
    @PutMapping("edit")
    public Article edit(@RequestBody Article editedArticle) {
        return articleService.edit(editedArticle);
    }

    @ApiOperation("Delete article by id")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        articleService.delete(id);
    }

    @ApiOperation("Add comment to article")
    @PutMapping("{id}/comment")
    public Article addComment(@RequestBody Comment comment, @PathVariable Integer id) {
        return articleService.addComment(id, comment);
    }
}
