package org.fatoumi.exercice.repository;

import org.fatoumi.exercice.entity.Post;
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
public class PostRepositoryIntegrationTest {

    private String postTableName = Post.class.getAnnotation(Table.class).name();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PostRepository sut;

    @Test
    public void should_return_all_post_when_findAll() {
        Integer numberOfPostsExpected, numberOfPostsFound;

        numberOfPostsExpected = JdbcTestUtils.countRowsInTable(jdbcTemplate, postTableName);

        List<Post> posts = (List<Post>) sut.findAll();
        numberOfPostsFound = posts.size();

        assertEquals(numberOfPostsExpected, numberOfPostsFound);
    }

    @Test
    public void should_return_post_when_findById() {
        Post post = new Post("Title", "Content");
        Post postPersisted = entityManager.persist(post);
        entityManager.flush();

        Post postExpected, postFound;

        postExpected = entityManager.find(Post.class, postPersisted.getId());
        postFound = sut.findById(postPersisted.getId()).get();

        assertEquals(postExpected, postFound);
    }

    @Test
    public void should_create_post_when_create() {
        Integer numberOfPostsBeforeSave = JdbcTestUtils.countRowsInTable(jdbcTemplate, postTableName);

        Post post = new Post("Title test", "Content tes");
        Post postFound = sut.save(post);

        Post postExpected = entityManager.find(Post.class, postFound.getId());
        Integer numberOfPostsAfterSave = JdbcTestUtils.countRowsInTable(jdbcTemplate, postTableName);

        assertNotEquals(numberOfPostsBeforeSave, numberOfPostsAfterSave);
        assertEquals(numberOfPostsBeforeSave, numberOfPostsAfterSave, 1);
        assertEquals(postExpected, postFound);
    }

    @Test
    public void should_edit_post_when_edit() {
        Post post = new Post("Title", "Content");
        Post postPersisted = entityManager.persist(post);
        entityManager.flush();

        post = entityManager.find(Post.class, postPersisted.getId());
        assertEquals(post.getTitle(), "Title");
        assertEquals(post.getContent(), "Content");

        post.setTitle("Edited title");
        post.setContent("Edited content");
        sut.save(post);

        Post postFound = entityManager.find(Post.class, postPersisted.getId());
        assertEquals("Edited title", postFound.getTitle());
        assertEquals("Edited content", postFound.getContent());
    }

    @Test
    public void should_delete_post_when_delete() {

        Integer postId = entityManager.persist(new Post("Title", "Content")).getId();
        entityManager.flush();
        Integer numberOfPostsBeforeDelete = JdbcTestUtils.countRowsInTable(jdbcTemplate, postTableName);

        Post post = entityManager.find(Post.class, postId);
        sut.delete(post);
        Integer numberOfPostsAfterDelete = ((List<Post>) sut.findAll()).size();

        assertNotEquals(numberOfPostsBeforeDelete, numberOfPostsAfterDelete);
        assertEquals(numberOfPostsBeforeDelete, numberOfPostsAfterDelete, 1);
    }
}