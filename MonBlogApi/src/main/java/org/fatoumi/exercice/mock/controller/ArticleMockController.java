package org.fatoumi.exercice.mock.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.fatoumi.exercice.entity.Article;
import org.fatoumi.exercice.mock.entity.ArticleMock;
import org.fatoumi.exercice.mock.entity.CommentMock;
import org.fatoumi.exercice.mock.service.MockArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/mock/articles")
@Api(value = "CRUD API for articles", description = "CRUD API for articles")
public class ArticleMockController {

    @Autowired
    private MockArticleService mockArticleService;

    @ApiOperation("Find all articles")
    @GetMapping
    public Iterable<ArticleMock> findAll() {
        return mockArticleService.findAll();
    }

    @ApiOperation("Find article by id")
    @GetMapping("{id}")
    public ArticleMock find(@PathVariable Integer id) {
        return mockArticleService.find(id);
    }

    @ApiOperation("Create an article")
    @PostMapping("create")
    public ArticleMock create(@RequestBody ArticleMock article) {
        return mockArticleService.create(article);
    }

    @ApiOperation("Edit an article")
    @PutMapping("edit")
    public ArticleMock edit(@RequestBody ArticleMock editedArticle) {
        return mockArticleService.edit(editedArticle);
    }

    @ApiOperation("Delete article by id")
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Integer id) {
        mockArticleService.delete(id);
    }


    @ApiOperation("Add comment to article")
    @PutMapping("{id}/comment")
    public Article addComment(@RequestBody CommentMock comment, @PathVariable Integer id) {
        return mockArticleService.addComment(id, comment);
    }
}
