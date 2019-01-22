package org.fatoumi.exercice.mock.service;

import org.fatoumi.exercice.mock.dao.ArticleDao;
import org.fatoumi.exercice.mock.entity.ArticleMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockArticleServiceTest {
    private List<ArticleMock> articles = Arrays.asList(
            new ArticleMock(1, "Title 1", "Content 1"),
            new ArticleMock(2, "Title 2", "Content 2"));

    @Mock
    private ArticleDao articleDao;

    @InjectMocks
    private MockArticleService sut = new MockArticleService();

    @Before
    public void init() {
        when(articleDao.findAll()).thenReturn(articles);
        when(articleDao.find(1)).thenReturn(articles.get(0));
    }

    @Test
    public void should_return_article_when_findAll() {
        assertEquals(articles, sut.findAll());
    }

    @Test
    public void should_return_an_article_when_find() {
        assertEquals(articles.get(0), sut.find(1));
    }

    //TODO: test create, edit, delete and add comment
    @Test
    public void should_return_created_article_when_create(){
       // ArticleMock article = sut.create(new ArticleMock("Title 3", "Content 3"));
    }
}
