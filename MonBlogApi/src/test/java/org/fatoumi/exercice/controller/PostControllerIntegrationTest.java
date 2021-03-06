package org.fatoumi.exercice.controller;

import org.fatoumi.exercice.entity.Post;
import org.fatoumi.exercice.service.DefaultPostService;
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
@WebMvcTest(PostController.class)
public class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DefaultPostService postService;

    @Test
    public void should_return_json_array_when_findAll_given_post_list() throws Exception {
        Post post = new Post("Title", "Content");
        List<Post> posts = Arrays.asList(post);
        when(postService.findAll()).thenReturn(posts);

        mvc.perform(get("/api/post")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].title", is(post.getTitle())));
    }

    @Test
    public void should_return_json_array_when_find() throws Exception {
        Post post = new Post("Title", "Content");
        when(postService.find(1)).thenReturn(post);

        mvc.perform(get("/api/post/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(post.getTitle())));
    }

    @Test
    public void should_delete_post_when_delete() throws Exception {
        mvc.perform(delete("/api/post/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
