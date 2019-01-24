package org.fatoumi.exercice.service;

import org.fatoumi.exercice.entity.Post;
import org.fatoumi.exercice.repository.PostRepository;
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
public class DefaultPostServiceTest {
    Post post = new Post();

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private DefaultPostService sut = new DefaultPostService();

    @Before
    public void init() {
        post.setId(1);
        when(postRepository.findById(1)).thenReturn(Optional.of(post));
    }

    @Test
    public void should_return_post_when_find() {
        assertEquals(post, sut.find(1));
    }

    //TODO: test find all, create, edit and delete
}
