package org.fatoumi.exercice.controller;

import org.fatoumi.exercice.entity.Article;
import org.fatoumi.exercice.service.DefaultArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DefaultArticleService articleService;

    @Test
    public void should_return_json_array_when_findAll_given_article_list() throws Exception {
        Article article = new Article("Title", "Content");
        List<Article> articles = Arrays.asList(article);
        when(articleService.findAll()).thenReturn(articles);

        mvc.perform(get("/api/articles")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is(article.getTitle())));
    }

    @Test
    public void should_return_json_array_when_find() throws Exception {
        Article article = new Article("Title", "Content");
        when(articleService.find(1)).thenReturn(article);

        mvc.perform(get("/api/articles/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(article.getTitle())));
    }

    @Test
    public void should_delete_article_when_delete() throws Exception {
        mvc.perform(delete("/api/articles/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
