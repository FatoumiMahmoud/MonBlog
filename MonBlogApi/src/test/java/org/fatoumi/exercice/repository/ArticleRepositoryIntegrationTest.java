package org.fatoumi.exercice.repository;

import org.fatoumi.exercice.entity.Article;
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

    private String articleTableName = Article.class.getAnnotation(Table.class).name();

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

        List<Article> articles = (List<Article>) sut.findAll();
        numberOfArticleFound = articles.size();

        assertEquals(numberOfArticleExpected, numberOfArticleFound);
    }

    @Test
    public void should_return_article_when_findById() {
        Article article = new Article("Title", "Content");
        Article articlePersisted = entityManager.persist(article);
        entityManager.flush();

        Article articleExpected, articleFound;

        articleExpected = entityManager.find(Article.class, articlePersisted.getId());
        articleFound = sut.findById(articlePersisted.getId()).get();

        assertEquals(articleExpected, articleFound);
    }

    @Test
    public void should_create_article_when_create() {
        Integer numberOfArticleBeforeSave = JdbcTestUtils.countRowsInTable(jdbcTemplate, articleTableName);

        Article article = new Article("Title test", "Content tes");
        Article articleFound = sut.save(article);

        Article articleExpected = entityManager.find(Article.class, articleFound.getId());
        Integer numberOfArticleAfterSave = JdbcTestUtils.countRowsInTable(jdbcTemplate, articleTableName);

        assertNotEquals(numberOfArticleBeforeSave, numberOfArticleAfterSave);
        assertEquals(numberOfArticleBeforeSave, numberOfArticleAfterSave, 1);
        assertEquals(articleExpected, articleFound);
    }

    @Test
    public void should_edit_article_when_edit() {
        Article article = new Article("Title", "Content");
        Article articlePersisted = entityManager.persist(article);
        entityManager.flush();

        article = entityManager.find(Article.class, articlePersisted.getId());
        assertEquals(article.getTitle(), "Title");
        assertEquals(article.getContent(), "Content");

        article.setTitle("Edited title");
        article.setContent("Edited content");
        sut.save(article);

        Article articleFound = entityManager.find(Article.class, articlePersisted.getId());
        assertEquals("Edited title", articleFound.getTitle());
        assertEquals("Edited content", articleFound.getContent());
    }

    @Test
    public void should_delete_article_when_delete() {

        entityManager.persist(new Article("Title", "Content"));
        entityManager.flush();
        Integer numberOfArticleBeforeDelete = JdbcTestUtils.countRowsInTable(jdbcTemplate, articleTableName);

        Article article = entityManager.find(Article.class, 1);
        sut.delete(article);
        Integer numberOfArticleAfterDelete = ((List<Article>) sut.findAll()).size();

        assertNotEquals(numberOfArticleBeforeDelete, numberOfArticleAfterDelete);
        assertEquals(numberOfArticleBeforeDelete, numberOfArticleAfterDelete, 1);
    }
}