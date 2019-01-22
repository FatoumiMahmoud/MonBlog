package org.fatoumi.exercice.mock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MockCommentServiceTest {

    @InjectMocks
    private MockCommentService sut = new MockCommentService();

    //TODO: test find all, find, create, edit, delete and find by article

    @Test
    public void test(){

    }
}
