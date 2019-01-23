package org.fatoumi.exercice.repository;

import org.fatoumi.exercice.entity.ArticleEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.persistence.Table;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ArticleRepositoryIntegrationTest {

    private String articleTableName = ArticleEntity.class.getAnnotation(Table.class).name();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ArticleRepository sut;

    @Test
    public void should_return_all_articles_when_findAll() {
        Integer numberOfArticleExpected, numberOfArticleFound;

        numberOfArticleExpected = JdbcTestUtils.countRowsInTable(jdbcTemplate, articleTableName);

        List<ArticleEntity> articles = (List<ArticleEntity>) sut.findAll();
        numberOfArticleFound = articles.size();

        assertEquals(numberOfArticleExpected, numberOfArticleFound);
    }

    @Test
    public void should_return_article_when_findById() {
        ArticleEntity article = new ArticleEntity("Title", "Content");
        ArticleEntity articlePersisted = entityManager.persist(article);
        entityManager.flush();

        ArticleEntity articleExpected, articleFound;

        articleExpected = entityManager.find(ArticleEntity.class, articlePersisted.getId());
        articleFound = sut.findById(articlePersisted.getId()).get();

        assertEquals(articleExpected, articleFound);
    }

    @Test
    public void should_create_article_when_create() {
        Integer numberOfArticleBeforeSave = JdbcTestUtils.countRowsInTable(jdbcTemplate, articleTableName);

        ArticleEntity article = new ArticleEntity("Title test", "Content tes");
        ArticleEntity articleFound = sut.save(article);

        ArticleEntity articleExpected = entityManager.find(ArticleEntity.class, articleFound.getId());
        Integer numberOfArticleAfterSave = JdbcTestUtils.countRowsInTable(jdbcTemplate, articleTableName);

        assertNotEquals(numberOfArticleBeforeSave, numberOfArticleAfterSave);
        assertEquals(numberOfArticleBeforeSave, numberOfArticleAfterSave, 1);
        assertEquals(articleExpected, articleFound);
    }

    @Test
    public void should_edit_article_when_edit() {
        ArticleEntity article = new ArticleEntity("Title", "Content");
        ArticleEntity articlePersisted = entityManager.persist(article);
        entityManager.flush();

        article = entityManager.find(ArticleEntity.class, articlePersisted.getId());
        assertEquals(article.getTitle(), "Title");
        assertEquals(article.getContent(), "Content");

        article.setTitle("Edited title");
        article.setContent("Edited content");
        sut.save(article);

        ArticleEntity articleFound = entityManager.find(ArticleEntity.class, articlePersisted.getId());
        assertEquals("Edited title", articleFound.getTitle());
        assertEquals("Edited content", articleFound.getContent());
    }

    @Test
    public void should_delete_article_when_delete() {

        entityManager.persist(new ArticleEntity("Title", "Content"));
        entityManager.flush();
        Integer numberOfArticleBeforeDelete = JdbcTestUtils.countRowsInTable(jdbcTemplate, articleTableName);

        ArticleEntity article = entityManager.find(ArticleEntity.class, 1);
        sut.delete(article);
        Integer numberOfArticleAfterDelete = ((List<ArticleEntity>) sut.findAll()).size();

        assertNotEquals(numberOfArticleBeforeDelete, numberOfArticleAfterDelete);
        assertEquals(numberOfArticleBeforeDelete, numberOfArticleAfterDelete, 1);
    }
}