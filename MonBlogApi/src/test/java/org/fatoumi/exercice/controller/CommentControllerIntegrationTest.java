package org.fatoumi.exercice.controller;

import org.fatoumi.exercice.service.DefaultCommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
public class CommentControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DefaultCommentService commentService;

    @Test
    public void test() {
        // TODO: add test for all api verbs
    }
}
