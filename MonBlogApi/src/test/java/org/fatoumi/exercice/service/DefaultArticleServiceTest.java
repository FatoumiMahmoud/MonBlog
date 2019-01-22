package org.fatoumi.exercice.service;

import org.fatoumi.exercice.entity.ArticleEntity;
import org.fatoumi.exercice.repository.ArticleRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DefaultArticleServiceTest {
    ArticleEntity article = new ArticleEntity();

    @Mock
    private ArticleRepository articleRepository;

    @InjectMocks
    private DefaultArticleService sut = new DefaultArticleService();

    @Before
    public void init() {
        article.setId(1);
        when(articleRepository.findById(1)).thenReturn(Optional.of(article));
    }

    @Test
    public void should_return_article_when_find() {
        assertEquals(article, sut.find(1));
    }

    //TODO: test find all, create, edit and delete
}
